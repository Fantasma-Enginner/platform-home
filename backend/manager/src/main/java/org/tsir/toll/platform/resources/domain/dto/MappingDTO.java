package org.tsir.toll.platform.resources.domain.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * MappingDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-17T00:37:58.511Z[GMT]")
@JacksonXmlRootElement(localName = "MappingDTO")
@XmlRootElement(name = "MappingDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class MappingDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("imports")
	@JacksonXmlProperty(localName = "imports")
	@Valid
	private Map<String, String> imports = null;

	public MappingDTO imports(Map<String, String> imports) {
		this.imports = imports;
		return this;
	}

	public MappingDTO putImportsItem(String key, String importsItem) {
		if (this.imports == null) {
			this.imports = new HashMap<>();
		}
		this.imports.put(key, importsItem);
		return this;
	}

	/**
	 * Cadena de mapeo de los módulos que tiene asociada interfaz visual. La cadena
	 * debe estar en formato JSON, asociando los modulos como nombres de propiedades
	 * cnel valor de cada propiedad con la URL de acceso al recurso.
	 * 
	 * @return imports
	 **/
	@Schema(description = "Cadena de mapeo de los módulos que tiene asociada interfaz visual. La cadena debe estar en formato JSON, asociando los modulos como nombres de propiedades cnel valor de cada propiedad con la URL de acceso al recurso.")

	public Map<String, String> getImports() {
		return imports;
	}

	public void setImports(Map<String, String> imports) {
		this.imports = imports;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MappingDTO mappingDTO = (MappingDTO) o;
		return Objects.equals(this.imports, mappingDTO.imports);
	}

	@Override
	public int hashCode() {
		return Objects.hash(imports);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MappingDTO {\n");

		sb.append("    imports: ").append(toIndentedString(imports)).append("\n");
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
