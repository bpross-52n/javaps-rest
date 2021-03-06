/*
 * Copyright (C) 2019 by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.wps.javaps.rest.deserializer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.n52.javaps.io.bbox.json.JSONBoundingBoxInputOutputHandler;
import org.n52.shetland.ogc.ows.OwsCode;
import org.n52.shetland.ogc.wps.DataTransmissionMode;
import org.n52.shetland.ogc.wps.Format;
import org.n52.shetland.ogc.wps.OutputDefinition;
import org.n52.shetland.ogc.wps.data.FormattedProcessData;
import org.n52.shetland.ogc.wps.data.ProcessData;
import org.n52.shetland.ogc.wps.data.ReferenceProcessData;
import org.n52.shetland.ogc.wps.data.impl.StringValueProcessData;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import io.swagger.model.InlineValue;
import io.swagger.model.Input;
import io.swagger.model.Output;
import io.swagger.model.TransmissionMode;

public class ExecuteDeserializer {

    private static final String VALUE_KEY = "value";

    private static final String INLINE_VALUE_KEY = "inlineValue";

    private static final String HREF_KEY = "href";

    private static final String FORMAT_KEY = "format";

    private static final String MIME_TYPE_KEY = "mimeType";

    private static final String ENCODING_KEY = "encoding";

    private static final String SCHEMA_KEY = "schema";

    private static final Format FORMAT_TEXT_PLAIN = new Format("text/plain");

    public static List<OutputDefinition> readOutputs(List<Output> outputs) {

        List<OutputDefinition> outputDefinitions = new ArrayList<>();

        if(outputs == null) {
            return outputDefinitions;
        }
        
        for (Output output : outputs) {
            OutputDefinition outputDefinition = new OutputDefinition();

            outputDefinition.setId(createId(output.getId()));

            outputDefinition.setFormat(getFormat((io.swagger.model.Format) output.getFormat()));

            outputDefinition.setDataTransmissionMode(getTransmisionMode(output.getTransmissionMode()));

            outputDefinitions.add(outputDefinition);
        }

        return outputDefinitions;
    }

    private static DataTransmissionMode getTransmisionMode(TransmissionMode transmissionMode) {
        switch (transmissionMode) {
        case REFERENCE:
            return DataTransmissionMode.REFERENCE;
        case VALUE:
            return DataTransmissionMode.VALUE;
        default:
            return DataTransmissionMode.REFERENCE;
        }
    }

    private static Format getFormat(Object object) {

        String mimeType = "";
        String encoding = "";
        String schema = "";

        if (object instanceof LinkedHashMap<?, ?>) {

            LinkedHashMap<?, ?> linkedHashMap = (LinkedHashMap<?, ?>) object;

            mimeType = linkedHashMap.containsKey(MIME_TYPE_KEY) ? linkedHashMap.get(MIME_TYPE_KEY).toString() : "";
            encoding = linkedHashMap.containsKey(ENCODING_KEY) ? linkedHashMap.get(ENCODING_KEY).toString() : "";
            schema = linkedHashMap.containsKey(SCHEMA_KEY) ? linkedHashMap.get(SCHEMA_KEY).toString() : "";

        } else if (object instanceof io.swagger.model.Format) {
            
            io.swagger.model.Format format = (io.swagger.model.Format)object;
            
            return new Format(format.getMimeType(), format.getEncoding(), format.getSchema());
        }
        return new Format(mimeType, encoding, schema);
    }

    private static OwsCode createId(String id) {
        return new OwsCode(id);
    }

    public static List<ProcessData> readInputs(List<Input> inputs) throws URISyntaxException, JsonProcessingException {

        List<ProcessData> processDataList = new ArrayList<>();

        if(inputs == null) {
            return processDataList;
        }
        
        for (Input input : inputs) {

            ProcessData processData = null;

            OwsCode id = createId(input.getId());

            Object object = input.getInput();

            if (object instanceof LinkedHashMap<?, ?>) {

                LinkedHashMap<?, ?> linkedHashMap = (LinkedHashMap<?, ?>) object;

                processData = readInput(id, processData, linkedHashMap);

            }

            processDataList.add(processData);
        }

        return processDataList;
    }

    private static ProcessData readInput(OwsCode id,
            ProcessData processData,
            LinkedHashMap<?, ?> linkedHashMap) throws URISyntaxException, JsonProcessingException {

        //
        if (linkedHashMap.containsKey(VALUE_KEY)) {

            Object value = linkedHashMap.get(VALUE_KEY);

            if (value instanceof LinkedHashMap<?, ?>) {
                // complex data
                LinkedHashMap<?, ?> complexValueMap = (LinkedHashMap<?, ?>) value;

                if (complexValueMap.containsKey(INLINE_VALUE_KEY)) {

                    Format format = new Format("text/plain");

                    if (linkedHashMap.containsKey(FORMAT_KEY)) {
                        format = getFormat(linkedHashMap.get(FORMAT_KEY));
                    }

                    String mimeType = format.getMimeType().orElse("");
                    
                    String valueString = "";
                    
                    Object valueObject = complexValueMap.get(INLINE_VALUE_KEY);
                    
                    if (mimeType != null && mimeType.equals(MimeTypeUtils.APPLICATION_JSON_VALUE)) {
                        valueString = new Gson().toJson(valueObject);
//                        if(valueObject instanceof LinkedTreeMap<?, ?>) {
//                            
//                        }
                    } else {
                        valueString = valueObject.toString();
                    }
                    
                    processData = new StringValueProcessData(id, format, valueString);

                    return processData;

                } else if (complexValueMap.containsKey(HREF_KEY)) {

                    URI uri = new URI(complexValueMap.get(HREF_KEY).toString());

                    Format format = new Format();

                    if (linkedHashMap.containsKey(FORMAT_KEY)) {
                        format = getFormat(linkedHashMap.get(FORMAT_KEY));
                    }

                    processData = new ReferenceProcessData(id, format, uri);

                    return processData;
                }
            } else if (value instanceof String) {
                processData = new StringValueProcessData(id, FORMAT_TEXT_PLAIN, (String) value);

                return processData;
            }
        }else if(linkedHashMap.containsKey(JSONBoundingBoxInputOutputHandler.BBOX)) {
            processData = new StringValueProcessData(id, JSONBoundingBoxInputOutputHandler.FORMAT_APPLICATION_JSON, new ObjectMapper().writeValueAsString(linkedHashMap));

            return processData;
        }
        
        return processData;
    }

}
