package org.tsir.toll.platform.resources.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;
import org.tsir.toll.platform.resources.domain.values.ApplicationType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ApplicationDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-17T00:37:58.511Z[GMT]")
@JacksonXmlRootElement(localName = "ApplicationDTO")
@XmlRootElement(name = "ApplicationDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class ApplicationDTO
		implements Serializable, OneOfDOMElementDTORoutesItems, OneOfRouteDTORoutesItems, OneOfRouterDTORoutesItems {
	private static final long serialVersionUID = 1L;

	@JsonProperty("type")
	@JacksonXmlProperty(localName = "type")
	private ApplicationType type = null;

	@JsonProperty("name")
	@JacksonXmlProperty(localName = "name")
	private String name = null;

	@JsonProperty("loader")
	@JacksonXmlProperty(localName = "loader")
	private String loader = null;

	@JsonProperty("props")
	@JacksonXmlProperty(localName = "props")
	private Object props = null;

	public ApplicationDTO type(ApplicationType type) {
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

	@Valid
	public ApplicationType getType() {
		return type;
	}

	public void setType(ApplicationType type) {
		this.type = type;
	}

	public ApplicationDTO name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The string application name.
	 * 
	 * @return name
	 **/
	@Schema(required = true, description = "The string application name.")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ApplicationDTO loader(String loader) {
		this.loader = loader;
		return this;
	}

	/**
	 * An HTML string or single-spa parcel config object. The loader will be mounted
	 * to the DOM while waiting for the application's loading function to resolve.
	 * 
	 * @return loader
	 **/
	@Schema(example = "<img src='loading.gif'>", description = "An HTML string or single-spa parcel config object. The loader will be mounted to the DOM while waiting for the application's loading function to resolve.")

	public String getLoader() {
		return loader;
	}

	public void setLoader(String loader) {
		this.loader = loader;
	}

	public ApplicationDTO props(Object props) {
		this.props = props;
		return this;
	}

	/**
	 * An object of single-spa custom props that will be provided to the application
	 * when it is mounted.
	 * 
	 * @return props
	 **/
	@Schema(example = "{\"myProp\": \"some-value\"}", description = "An object of single-spa custom props that will be provided to the application when it is mounted.")

	public Object getProps() {
		return props;
	}

	public void setProps(Object props) {
		this.props = props;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ApplicationDTO applicationDTO = (ApplicationDTO) o;
		return Objects.equals(this.type, applicationDTO.type) && Objects.equals(this.name, applicationDTO.name)
				&& Objects.equals(this.loader, applicationDTO.loader)
				&& Objects.equals(this.props, applicationDTO.props);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, name, loader, props);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ApplicationDTO {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    loader: ").append(toIndentedString(loader)).append("\n");
		sb.append("    props: ").append(toIndentedString(props)).append("\n");
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
