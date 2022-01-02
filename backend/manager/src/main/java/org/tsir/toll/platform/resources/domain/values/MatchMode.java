package org.tsir.toll.platform.resources.domain.values;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeración de los tipos de emparejamiento de las rutas (A string that must
 * be hash or history that defaults to history. This indicates whether the
 * routes should be matched against the Location pathname or hash): * `hash` -
 * Las rutas son emparejadas contra el hash. * `ACTIVO` - Las rutas son
 * emparejadas contra el pathname.
 */
public enum MatchMode {
	HASH("hash"), HISTORY("history");

	private String value;

	MatchMode(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static MatchMode fromValue(String text) {
		for (MatchMode b : MatchMode.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
