package org.tsir.toll.platform.resources.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;
import org.tsir.toll.platform.resources.domain.values.MatchMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * RouterDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-17T00:37:58.511Z[GMT]")
@JacksonXmlRootElement(localName = "RouterDTO")
@XmlRootElement(name = "RouterDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class RouterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("mode")
	@JacksonXmlProperty(localName = "mode")
	private MatchMode mode = null;

	@JsonProperty("base")
	@JacksonXmlProperty(localName = "base")
	private String base = null;

	@JsonProperty("disableWarnings")
	@JacksonXmlProperty(localName = "disableWarnings")
	private Boolean disableWarnings = null;

	@JsonProperty("containerEl")
	@JacksonXmlProperty(localName = "containerEl")
	private String containerEl = null;

	@JsonProperty("routes")
	@JacksonXmlProperty(localName = "routes")
	@Valid
	private List<OneOfRouterDTORoutesItems> routes = null;

	public RouterDTO mode(MatchMode mode) {
		this.mode = mode;
		return this;
	}

	/**
	 * Get mode
	 * 
	 * @return mode
	 **/
	@Schema(description = "")

	@Valid
	public MatchMode getMode() {
		return mode;
	}

	public void setMode(MatchMode mode) {
		this.mode = mode;
	}

	public RouterDTO base(String base) {
		this.base = base;
		return this;
	}

	/**
	 * A string URL prefix that will be considered when matching route paths.
	 * 
	 * @return base
	 **/
	@Schema(example = "/", description = "A string URL prefix that will be considered when matching route paths.")

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public RouterDTO disableWarnings(Boolean disableWarnings) {
		this.disableWarnings = disableWarnings;
		return this;
	}

	/**
	 * A boolean that turns of single-spa-layout's console warnings when the
	 * elements provided are incorrect.
	 * 
	 * @return disableWarnings
	 **/
	@Schema(description = "A boolean that turns of single-spa-layout's console warnings when the elements provided are incorrect.")

	public Boolean isDisableWarnings() {
		return disableWarnings;
	}

	public void setDisableWarnings(Boolean disableWarnings) {
		this.disableWarnings = disableWarnings;
	}

	public RouterDTO containerEl(String containerEl) {
		this.containerEl = containerEl;
		return this;
	}

	/**
	 * Contenedor (A string CSS Selector or HTMLElement that is used as the
	 * container for all single-spa dom elements. Defaults to body).
	 * 
	 * @return containerEl
	 **/
	@Schema(example = "#container", description = "Contenedor (A string CSS Selector or HTMLElement that is used as the container for all single-spa dom elements. Defaults to body).")

	public String getContainerEl() {
		return containerEl;
	}

	public void setContainerEl(String containerEl) {
		this.containerEl = containerEl;
	}

	public RouterDTO routes(List<OneOfRouterDTORoutesItems> routes) {
		this.routes = routes;
		return this;
	}

	public RouterDTO addRoutesItem(OneOfRouterDTORoutesItems routesItem) {
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

	public List<OneOfRouterDTORoutesItems> getRoutes() {
		return routes;
	}

	public void setRoutes(List<OneOfRouterDTORoutesItems> routes) {
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
		RouterDTO routerDTO = (RouterDTO) o;
		return Objects.equals(this.mode, routerDTO.mode) && Objects.equals(this.base, routerDTO.base)
				&& Objects.equals(this.disableWarnings, routerDTO.disableWarnings)
				&& Objects.equals(this.containerEl, routerDTO.containerEl)
				&& Objects.equals(this.routes, routerDTO.routes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mode, base, disableWarnings, containerEl, routes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RouterDTO {\n");

		sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
		sb.append("    base: ").append(toIndentedString(base)).append("\n");
		sb.append("    disableWarnings: ").append(toIndentedString(disableWarnings)).append("\n");
		sb.append("    containerEl: ").append(toIndentedString(containerEl)).append("\n");
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
