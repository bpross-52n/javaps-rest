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

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InputDescription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-28T10:33:35.029Z[GMT]")
public class InputDescription extends DataDescriptionType  {
  @JsonProperty("input")
  private Object input = null;

  @JsonProperty("minOccurs")
  private Integer minOccurs = null;

  @JsonProperty("maxOccurs")
  private Object maxOccurs = null;

  public InputDescription input(Object input) {
    this.input = input;
    return this;
  }

  /**
   * Get input
   * @return input
  **/
  @ApiModelProperty(value = "")
  
    public Object getInput() {
    return input;
  }

  public void setInput(Object input) {
    this.input = input;
  }

  public InputDescription minOccurs(Integer minOccurs) {
    this.minOccurs = minOccurs;
    return this;
  }

  /**
   * Get minOccurs
   * @return minOccurs
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMinOccurs() {
    return minOccurs;
  }

  public void setMinOccurs(Integer minOccurs) {
    this.minOccurs = minOccurs;
  }

  public InputDescription maxOccurs(Object maxOccurs) {
    this.maxOccurs = maxOccurs;
    return this;
  }

  /**
   * Get maxOccurs
   * @return maxOccurs
  **/
  @ApiModelProperty(value = "")
  
    public Object getMaxOccurs() {
    return maxOccurs;
  }

  public void setMaxOccurs(Object maxOccurs) {
    this.maxOccurs = maxOccurs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputDescription inputDescription = (InputDescription) o;
    return Objects.equals(this.input, inputDescription.input) &&
        Objects.equals(this.minOccurs, inputDescription.minOccurs) &&
        Objects.equals(this.maxOccurs, inputDescription.maxOccurs) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, minOccurs, maxOccurs, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputDescription {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    minOccurs: ").append(toIndentedString(minOccurs)).append("\n");
    sb.append("    maxOccurs: ").append(toIndentedString(maxOccurs)).append("\n");
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
