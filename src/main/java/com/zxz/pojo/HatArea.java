package com.zxz.pojo;

/**
 * HatArea entity. @author MyEclipse Persistence Tools
 */

public class HatArea implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -1049136465758340794L;
	private Integer id;
	private String areaId;
	private String area;
	private String father;

	// Constructors

	/** default constructor */
	public HatArea() {
	}

	/** full constructor */
	public HatArea(String areaId, String area, String father) {
		this.areaId = areaId;
		this.area = area;
		this.father = father;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaId() {
		return this.areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFather() {
		return this.father;
	}

	public void setFather(String father) {
		this.father = father;
	}

}