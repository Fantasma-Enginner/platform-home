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
import org.tsir.toll.platform.resources.domain.values.RouteType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * RouteDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-17T00:37:58.511Z[GMT]")
@JacksonXmlRootElement(localName = "RouteDTO")
@XmlRootElement(name = "RouteDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class RouteDTO implements Serializable, OneOfDOMElementDTORoutesItems, OneOfRouterDTORoutesItems {
	private static final long serialVersionUID = 1L;

	@JsonProperty("type")
	@JacksonXmlProperty(localName = "type")
	private RouteType type = null;

	@JsonProperty("path")
	@JacksonXmlProperty(localName = "path")
	private String path = null;

	@JsonProperty("default")
	@JacksonXmlProperty(localName = "default")
	private Boolean _default = null;

	@JsonProperty("exact")
	@JacksonXmlProperty(localName = "exact")
	private Boolean exact = null;

	@JsonProperty("props")
	@JacksonXmlProperty(localName = "props")
	private Object props = null;

	@JsonProperty("routes")
	@JacksonXmlProperty(localName = "routes")
	@Valid
	private List<OneOfRouteDTORoutesItems> routes = new ArrayList<>();

	public RouteDTO type(RouteType type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 **/
	@Schema(description = "")

	@Valid
	public RouteType getType() {
		return type;
	}

	public void setType(RouteType type) {
		this.type = type;
	}

	public RouteDTO path(String path) {
		this.path = path;
		return this;
	}

	/**
	 * A path that will be matched against the browser's URL. The path is relative
	 * to its parent route (or the base URL). Leading and trailing / characters are
	 * unnecessary and are automatically applied.
	 * 
	 * @return path
	 **/
	@Schema(example = "clients/:id/reports", description = "A path that will be matched against the browser's URL. The path is relative to its parent route (or the base URL). Leading and trailing / characters are unnecessary and are automatically applied.")

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public RouteDTO _default(Boolean _default) {
		this._default = _default;
		return this;
	}

	/**
	 * A boolean that determines whether this route will match all remaining URLs
	 * that have not been defined by sibling routes.
	 * 
	 * @return _default
	 **/
	@Schema(description = "A boolean that determines whether this route will match all remaining URLs that have not been defined by sibling routes.")

	public Boolean isDefault() {
		return _default;
	}

	public void setDefault(Boolean _default) {
		this._default = _default;
	}

	public RouteDTO exact(Boolean exact) {
		this.exact = exact;
		return this;
	}

	/**
	 * A boolean that determines whether the path should be treated as a prefix or
	 * exact match.
	 * 
	 * @return exact
	 **/
	@Schema(description = "A boolean that determines whether the path should be treated as a prefix or exact match.")

	public Boolean isExact() {
		return exact;
	}

	public void setExact(Boolean exact) {
		this.exact = exact;
	}

	public RouteDTO props(Object props) {
		this.props = props;
		return this;
	}

	/**
	 * An object of single-spa custom props that will be provided to the application
	 * when it is mounted.
	 * 
	 * @return props
	 **/
	@Schema(description = "An object of single-spa custom props that will be provided to the application when it is mounted.")

	public Object getProps() {
		return props;
	}

	public void setProps(Object props) {
		this.props = props;
	}

	public RouteDTO routes(List<OneOfRouteDTORoutesItems> routes) {
		this.routes = routes;
		return this;
	}

	public RouteDTO addRoutesItem(OneOfRouteDTORoutesItems routesItem) {
		this.routes.add(routesItem);
		return this;
	}

	/**
	 * Get routes
	 * 
	 * @return routes
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public List<OneOfRouteDTORoutesItems> getRoutes() {
		return routes;
	}

	public void setRoutes(List<OneOfRouteDTORoutesItems> routes) {
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
		RouteDTO routeDTO = (RouteDTO) o;
		return Objects.equals(this.type, routeDTO.type) && Objects.equals(this.path, routeDTO.path)
				&& Objects.equals(this._default, routeDTO._default) && Objects.equals(this.exact, routeDTO.exact)
				&& Objects.equals(this.props, routeDTO.props) && Objects.equals(this.routes, routeDTO.routes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, path, _default, exact, props, routes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RouteDTO {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    path: ").append(toIndentedString(path)).append("\n");
		sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
		sb.append("    exact: ").append(toIndentedString(exact)).append("\n");
		sb.append("    props: ").append(toIndentedString(props)).append("\n");
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
