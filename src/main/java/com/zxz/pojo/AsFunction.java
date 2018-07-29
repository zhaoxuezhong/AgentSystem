package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsFunction entity. @author MyEclipse Persistence Tools
 */

public class AsFunction implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 6144480946688534416L;
	private Integer id;
	private String functionCode;
	private String functionName;
	private Timestamp creationTime;
	private String createdBy;
	private Timestamp lastUpdateTime;
	private String funcUrl;
	private Integer isStart;
	private Integer parentId;

	// Constructors

	/** default constructor */
	public AsFunction() {
	}

	/** minimal constructor */
	public AsFunction(String functionCode, String functionName, Timestamp creationTime, String createdBy) {
		this.functionCode = functionCode;
		this.functionName = functionName;
		this.creationTime = creationTime;
		this.createdBy = createdBy;
	}

	/** full constructor */
	public AsFunction(String functionCode, String functionName, Timestamp creationTime, String createdBy,
			Timestamp lastUpdateTime, String funcUrl, Integer isStart, Integer parentId) {
		this.functionCode = functionCode;
		this.functionName = functionName;
		this.creationTime = creationTime;
		this.createdBy = createdBy;
		this.lastUpdateTime = lastUpdateTime;
		this.funcUrl = funcUrl;
		this.isStart = isStart;
		this.parentId = parentId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFunctionCode() {
		return this.functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getFuncUrl() {
		return this.funcUrl;
	}

	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	public Integer getIsStart() {
		return this.isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}