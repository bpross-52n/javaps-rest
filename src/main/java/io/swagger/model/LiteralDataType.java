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
import io.swagger.model.LiteralDataDomain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LiteralDataType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-28T10:33:35.029Z[GMT]")
public class LiteralDataType {
  @JsonProperty("literalDataDomains")
  @Valid
  private List<LiteralDataDomain> literalDataDomains = new ArrayList<LiteralDataDomain>();

  public LiteralDataType literalDataDomains(List<LiteralDataDomain> literalDataDomains) {
    this.literalDataDomains = literalDataDomains;
    return this;
  }

  public LiteralDataType addLiteralDataDomainsItem(LiteralDataDomain literalDataDomainsItem) {
    this.literalDataDomains.add(literalDataDomainsItem);
    return this;
  }

  /**
   * Get literalDataDomains
   * @return literalDataDomains
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
    public List<LiteralDataDomain> getLiteralDataDomains() {
    return literalDataDomains;
  }

  public void setLiteralDataDomains(List<LiteralDataDomain> literalDataDomains) {
    this.literalDataDomains = literalDataDomains;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiteralDataType literalDataType = (LiteralDataType) o;
    return Objects.equals(this.literalDataDomains, literalDataType.literalDataDomains);
  }

  @Override
  public int hashCode() {
    return Objects.hash(literalDataDomains);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiteralDataType {\n");
    
    sb.append("    literalDataDomains: ").append(toIndentedString(literalDataDomains)).append("\n");
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
