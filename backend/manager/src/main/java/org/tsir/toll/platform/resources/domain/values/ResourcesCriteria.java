package org.tsir.toll.platform.resources.domain.values;

import org.tsir.common.api.exceptions.NotSupportCriteriaException;

public enum ResourcesCriteria {

	ID_KEY("ID"),
	
	CODE_KEY("CODE"),

	LABEL_KEY("LABEL"),

	STATE_KEY("STATE"),

	PARENT_KEY("PARENT"),

	TYPE_KEY("TYPE"),

	LOCATION_KEY("LOCATION"),
	
	PATH_KEY("PATH");

	private ResourcesCriteria(String key) {
		this.key = key;
	}

	private String key;

	public String getKey() {
		return key;
	}

	public static ResourcesCriteria fromKey(String criteria) {
		for (ResourcesCriteria uc : ResourcesCriteria.values()) {
			if (uc.getKey().equals(criteria)) {
				return uc;
			}
		}
		throw new NotSupportCriteriaException("Recurso", criteria);
	}

}
