package org.tsir.toll.platform.resources.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RESOURCES")
public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8313515001230760403L;

	@Id
	@Column(name = "RESOURCE_ID")
	private long resourceId;

	@Column(name = "CODE")
	@NotNull
	private Integer code;

	@Column(name = "LABEL")
	@NotNull
	private String label;

	@Column(name = "PATH")
	private String path;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "TYPE")
	@NotNull
	private Integer type;

	@Column(name = "ACTIVE")
	private Integer active;

	@Column(name = "ICON")
	private String icon;

	@Column(name = "PARENT_ID")
	private Long parent;

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", code=" + code + ", label=" + label + ", path=" + path
				+ ", location=" + location + ", type=" + type + ", active=" + active + ", icon=" + icon + ", parent="
				+ parent + "]";
	}

}
