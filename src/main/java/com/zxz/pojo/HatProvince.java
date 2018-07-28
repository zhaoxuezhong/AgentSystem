package com.zxz.pojo;

/**
 * HatProvince entity. @author MyEclipse Persistence Tools
 */

public class HatProvince implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 7334547393518352719L;
	private Integer id;
	private String provinceId;
	private String province;

	// Constructors

	/** default constructor */
	public HatProvince() {
	}

	/** full constructor */
	public HatProvince(String provinceId, String province) {
		this.provinceId = provinceId;
		this.province = province;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}