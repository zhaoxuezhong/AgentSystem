package com.zxz.pojo;

/**
 * AsSystemconfig entity. @author MyEclipse Persistence Tools
 */

public class AsSystemconfig implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 2336688273033134161L;
	private Integer id;
	private Integer configType;
	private String configTypeName;
	private Integer configTypeValue;
	private String configValue;
	private Integer isStart;

	// Constructors

	/** default constructor */
	public AsSystemconfig() {
	}

	/** minimal constructor */
	public AsSystemconfig(Integer configType, String configTypeName, Integer configTypeValue, Integer isStart) {
		this.configType = configType;
		this.configTypeName = configTypeName;
		this.configTypeValue = configTypeValue;
		this.isStart = isStart;
	}

	/** full constructor */
	public AsSystemconfig(Integer configType, String configTypeName, Integer configTypeValue, String configValue,
			Integer isStart) {
		this.configType = configType;
		this.configTypeName = configTypeName;
		this.configTypeValue = configTypeValue;
		this.configValue = configValue;
		this.isStart = isStart;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConfigType() {
		return this.configType;
	}

	public void setConfigType(Integer configType) {
		this.configType = configType;
	}

	public String getConfigTypeName() {
		return this.configTypeName;
	}

	public void setConfigTypeName(String configTypeName) {
		this.configTypeName = configTypeName;
	}

	public Integer getConfigTypeValue() {
		return this.configTypeValue;
	}

	public void setConfigTypeValue(Integer configTypeValue) {
		this.configTypeValue = configTypeValue;
	}

	public String getConfigValue() {
		return this.configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public Integer getIsStart() {
		return this.isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

}