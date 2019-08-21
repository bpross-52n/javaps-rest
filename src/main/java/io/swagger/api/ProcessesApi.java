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
/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import javax.validation.Valid;

import org.n52.shetland.ogc.ows.exception.CodedException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Exception;
import io.swagger.model.Execute;
import io.swagger.model.JobCollection;
import io.swagger.model.ProcessCollection;
import io.swagger.model.Result;
import io.swagger.model.StatusInfo;
import io.swagger.model.Process;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-08T09:36:12.450Z[GMT]")

@Api(value = "processes", description = "the processes API")
public interface ProcessesApi {

    final String baseURL = "/rest";
    
    @ApiOperation(value = "execute a process.", nickname = "execute", notes = "", tags={ "Execute", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Started execution. Created job."),
        @ApiResponse(code = 404, message = "The process with id {id} does not exist.", response = Exception.class),
        @ApiResponse(code = 200, message = "An error occured.", response = Exception.class) })
    @RequestMapping(value = baseURL + "/processes/{id}/jobs",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<?> execute(@ApiParam(value = "Mandatory execute request JSON" ,required=true )  @Valid @RequestBody Execute body,@ApiParam(value = "The id of a process.",required=true) @PathVariable("id") String id) throws CodedException;


    @ApiOperation(value = "retrieve the list of jobs for a process.", nickname = "getJobList", notes = "", response = JobCollection.class, tags={ "JobList", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of jobs for this process.", response = JobCollection.class),
        @ApiResponse(code = 404, message = "The process with id {id} does not exist.", response = Exception.class),
        @ApiResponse(code = 200, message = "An error occured.", response = Exception.class) })
    @RequestMapping(value = baseURL + "/processes/{id}/jobs",
        produces = { "application/json" }, 
        method = RequestMethod.GET)    
    ResponseEntity<?> getJobList(@ApiParam(value = "The id of a process.",required=true) @PathVariable("id") String id);
    
    @RequestMapping(value = baseURL + "/processes/{id}/jobs",
            produces = { "text/html" }, 
            method = RequestMethod.GET)
    String getExecuteForm(@ApiParam(value = "The id of a process.",required=true) @PathVariable("id") String id, Model model);


    @ApiOperation(value = "retrieve a process description", nickname = "getProcessDescription", notes = "", response = Process.class, tags={ "ProcessDescription", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A process description.", response = Process.class),
        @ApiResponse(code = 404, message = "The process with id {id} does not exist.", response = Exception.class),
        @ApiResponse(code = 200, message = "An error occured.", response = Exception.class) })
    @RequestMapping(value = baseURL + "/processes/{id:.+}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getProcessDescription(@ApiParam(value = "The id of a process",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "retrieve available processes", nickname = "getProcesses", notes = "TODO", response = ProcessCollection.class, tags={ "Processes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Information about the available processes", response = ProcessCollection.class),
        @ApiResponse(code = 200, message = "An error occured.", response = Exception.class) })
    @RequestMapping(value = baseURL + "/processes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ProcessCollection> getProcesses();


    @ApiOperation(value = "retrieve the result(s) of a job", nickname = "getResult", notes = "", response = Result.class, tags={ "Result", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The result of a job.", response = Result.class),
        @ApiResponse(code = 404, message = "The process with id {id} or the job with id {jobID} does not exist.", response = Exception.class),
        @ApiResponse(code = 200, message = "An error occured.", response = Exception.class) })
    @RequestMapping(value = baseURL + "/processes/{id}/jobs/{jobID}/results",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getResult(@ApiParam(value = "The id of a process",required=true) @PathVariable("id") String id,@ApiParam(value = "The id of a job",required=true) @PathVariable("jobID") String jobID);


    @ApiOperation(value = "retrieve the status of a job", nickname = "getStatus", notes = "", response = StatusInfo.class, tags={ "Status", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The status of a job.", response = StatusInfo.class),
        @ApiResponse(code = 404, message = "The process with id {id} or the job with id {jobID} does not exist.", response = Exception.class),
        @ApiResponse(code = 200, message = "An error occured.", response = Exception.class) })
    @RequestMapping(value = baseURL + "/processes/{id}/jobs/{jobID}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getStatus(@ApiParam(value = "The id of a process",required=true) @PathVariable("id") String id,@ApiParam(value = "The id of a job",required=true) @PathVariable("jobID") String jobID);

}
