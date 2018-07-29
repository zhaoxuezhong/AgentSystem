package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsRolePremission entity. @author MyEclipse Persistence Tools
 */

public class AsRolePremission implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6188413252566500901L;
	private Integer id;
	private Integer roleId;
	private Integer functionId;
	private Timestamp creationTime;
	private String createdBy;
	private Timestamp lastUpdateTime;
	private Integer isStart;

	// Constructors

	/** default constructor */
	public AsRolePremission() {
	}

	/** minimal constructor */
	public AsRolePremission(Integer roleId, Integer functionId, Timestamp creationTime, String createdBy) {
		this.roleId = roleId;
		this.functionId = functionId;
		this.creationTime = creationTime;
		this.createdBy = createdBy;
	}

	/** full constructor */
	public AsRolePremission(Integer roleId, Integer functionId, Timestamp creationTime, String createdBy,
			Timestamp lastUpdateTime, Integer isStart) {
		this.roleId = roleId;
		this.functionId = functionId;
		this.creationTime = creationTime;
		this.createdBy = createdBy;
		this.lastUpdateTime = lastUpdateTime;
		this.isStart = isStart;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
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

	public Integer getIsStart() {
		return this.isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

}