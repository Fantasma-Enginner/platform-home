package org.tsir.toll.platform.resources.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * AttributeDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-17T00:37:58.511Z[GMT]")
@JacksonXmlRootElement(localName = "AttributeDTO")
@XmlRootElement(name = "AttributeDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class AttributeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	@JacksonXmlProperty(localName = "name")
	private String name = null;

	@JsonProperty("value")
	@JacksonXmlProperty(localName = "value")
	private String value = null;

	public AttributeDTO name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name for the attribute.
	 * 
	 * @return name
	 **/
	@Schema(description = "The name for the attribute.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttributeDTO value(String value) {
		this.value = value;
		return this;
	}

	/**
	 * the value for the attribute.
	 * 
	 * @return value
	 **/
	@Schema(description = "the value for the attribute.")

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AttributeDTO attributeDTO = (AttributeDTO) o;
		return Objects.equals(this.name, attributeDTO.name) && Objects.equals(this.value, attributeDTO.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AttributeDTO {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
