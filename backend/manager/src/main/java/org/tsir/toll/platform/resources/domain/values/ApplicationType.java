package org.tsir.toll.platform.resources.domain.values;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Constante que define el tipo de elemento aplicacion: * `aplication` -
 * Elemento tipo aplicacion.
 */
public enum ApplicationType {
	APPLICATION("application");

	private String value;

	ApplicationType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static ApplicationType fromValue(String text) {
		for (ApplicationType b : ApplicationType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
