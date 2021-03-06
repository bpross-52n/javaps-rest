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
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Link;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StatusInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-28T10:33:35.029Z[GMT]")
public class StatusInfo   {
  @JsonProperty("jobID")
  private String jobID = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    ACCEPTED("accepted"),
    
    RUNNING("running"),
    
    SUCCESSFUL("successful"),
    
    FAILED("failed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("progress")
  private Integer progress = null;

  @JsonProperty("links")
  @Valid
  private List<Link> links = null;

  public StatusInfo jobID(String jobID) {
    this.jobID = jobID;
    return this;
  }

  /**
   * Get jobID
   * @return jobID
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getJobID() {
    return jobID;
  }

  public void setJobID(String jobID) {
    this.jobID = jobID;
  }

  public StatusInfo status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public StatusInfo message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(value = "")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public StatusInfo progress(Integer progress) {
    this.progress = progress;
    return this;
  }

  /**
   * Get progress
   * minimum: 0
   * maximum: 100
   * @return progress
  **/
  @ApiModelProperty(value = "")
  
  @Min(0) @Max(100)   public Integer getProgress() {
    return progress;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  public StatusInfo links(List<Link> links) {
    this.links = links;
    return this;
  }

  public StatusInfo addLinksItem(Link linksItem) {
    if (this.links == null) {
      this.links = new ArrayList<Link>();
    }
    this.links.add(linksItem);
    return this;
  }

  /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusInfo statusInfo = (StatusInfo) o;
    return Objects.equals(this.jobID, statusInfo.jobID) &&
        Objects.equals(this.status, statusInfo.status) &&
        Objects.equals(this.message, statusInfo.message) &&
        Objects.equals(this.progress, statusInfo.progress) &&
        Objects.equals(this.links, statusInfo.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobID, status, message, progress, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusInfo {\n");
    
    sb.append("    jobID: ").append(toIndentedString(jobID)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
