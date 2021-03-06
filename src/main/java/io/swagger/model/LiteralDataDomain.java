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
package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.LiteralDataDataType;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LiteralDataDomain
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-28T10:33:35.029Z[GMT]")
public class LiteralDataDomain   {
  @JsonProperty("valueDefinition")
  private Object valueDefinition = null;

  @JsonProperty("defaultValue")
  private String defaultValue = null;

  @JsonProperty("dataType")
  private LiteralDataDataType dataType = null;

  @JsonProperty("uom")
  private LiteralDataDataType uom = null;

  public LiteralDataDomain valueDefinition(Object valueDefinition) {
    this.valueDefinition = valueDefinition;
    return this;
  }

  /**
   * Get valueDefinition
   * @return valueDefinition
  **/
  @ApiModelProperty(value = "")
  
    public Object getValueDefinition() {
    return valueDefinition;
  }

  public void setValueDefinition(Object valueDefinition) {
    this.valueDefinition = valueDefinition;
  }

  public LiteralDataDomain defaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  /**
   * Get defaultValue
   * @return defaultValue
  **/
  @ApiModelProperty(value = "")
  
    public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public LiteralDataDomain dataType(LiteralDataDataType dataType) {
    this.dataType = dataType;
    return this;
  }

  /**
   * Get dataType
   * @return dataType
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public LiteralDataDataType getDataType() {
    return dataType;
  }

  public void setDataType(LiteralDataDataType dataType) {
    this.dataType = dataType;
  }

  public LiteralDataDomain uom(LiteralDataDataType uom) {
    this.uom = uom;
    return this;
  }

  /**
   * Get uom
   * @return uom
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public LiteralDataDataType getUom() {
    return uom;
  }

  public void setUom(LiteralDataDataType uom) {
    this.uom = uom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiteralDataDomain literalDataDomain = (LiteralDataDomain) o;
    return Objects.equals(this.valueDefinition, literalDataDomain.valueDefinition) &&
        Objects.equals(this.defaultValue, literalDataDomain.defaultValue) &&
        Objects.equals(this.dataType, literalDataDomain.dataType) &&
        Objects.equals(this.uom, literalDataDomain.uom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueDefinition, defaultValue, dataType, uom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiteralDataDomain {\n");
    
    sb.append("    valueDefinition: ").append(toIndentedString(valueDefinition)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
