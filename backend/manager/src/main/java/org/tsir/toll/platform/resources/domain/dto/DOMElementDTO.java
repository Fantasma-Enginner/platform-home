package org.tsir.toll.platform.resources.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DOMElementDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-17T00:37:58.511Z[GMT]")
@JacksonXmlRootElement(localName = "DOMElementDTO")
@XmlRootElement(name = "DOMElementDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class DOMElementDTO
		implements Serializable, OneOfDOMElementDTORoutesItems, OneOfRouteDTORoutesItems, OneOfRouterDTORoutesItems {
	private static final long serialVersionUID = 1L;

	@JsonProperty("type")
	@JacksonXmlProperty(localName = "type")
	private String type = null;

	@JsonProperty("value")
	@JacksonXmlProperty(localName = "value")
	private String value = null;

	@JsonProperty("attrs")
	@JacksonXmlProperty(localName = "attrs")
	@Valid
	private List<AttributeDTO> attrs = null;

	@JsonProperty("routes")
	@JacksonXmlProperty(localName = "routes")
	@Valid
	private List<OneOfDOMElementDTORoutesItems> routes = null;

	public DOMElementDTO type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DOMElementDTO value(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Sets value for the next elements. - Text Nodes are defined separately from
	 * the parent containers, as separate objects with type set to #text. - Comment
	 * Nodes are defined as objects whose type is #comment
	 * 
	 * @return value
	 **/
	@Schema(description = "Sets value for the next elements. - Text Nodes are defined separately from the parent containers, as separate objects with type set to #text.  - Comment Nodes are defined as objects whose type is #comment")

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DOMElementDTO attrs(List<AttributeDTO> attrs) {
		this.attrs = attrs;
		return this;
	}

	public DOMElementDTO addAttrsItem(AttributeDTO attrsItem) {
		if (this.attrs == null) {
			this.attrs = new ArrayList<>();
		}
		this.attrs.add(attrsItem);
		return this;
	}

	/**
	 * Get attrs
	 * 
	 * @return attrs
	 **/
	@Schema(description = "")
	@Valid
	public List<AttributeDTO> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<AttributeDTO> attrs) {
		this.attrs = attrs;
	}

	public DOMElementDTO routes(List<OneOfDOMElementDTORoutesItems> routes) {
		this.routes = routes;
		return this;
	}

	public DOMElementDTO addRoutesItem(OneOfDOMElementDTORoutesItems routesItem) {
		if (this.routes == null) {
			this.routes = new ArrayList<>();
		}
		this.routes.add(routesItem);
		return this;
	}

	/**
	 * Get routes
	 * 
	 * @return routes
	 **/
	@Schema(description = "")

	public List<OneOfDOMElementDTORoutesItems> getRoutes() {
		return routes;
	}

	public void setRoutes(List<OneOfDOMElementDTORoutesItems> routes) {
		this.routes = routes;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DOMElementDTO doMElementDTO = (DOMElementDTO) o;
		return Objects.equals(this.type, doMElementDTO.type) && Objects.equals(this.value, doMElementDTO.value)
				&& Objects.equals(this.attrs, doMElementDTO.attrs) && Objects.equals(this.routes, doMElementDTO.routes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, value, attrs, routes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DOMElementDTO {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    attrs: ").append(toIndentedString(attrs)).append("\n");
		sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
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
