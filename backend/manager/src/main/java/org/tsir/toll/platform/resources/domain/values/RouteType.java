package org.tsir.toll.platform.resources.domain.values;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Constante que define el tipo de elemento aplicacion: * `route` - Elemento
 * tipo ruta.
 */
public enum RouteType {
	ROUTE("route");

	private String value;

	RouteType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static RouteType fromValue(String text) {
		for (RouteType b : RouteType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
