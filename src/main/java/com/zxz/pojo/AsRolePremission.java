package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsRolePremission entity. @author MyEclipse Persistence Tools
 */

public class AsRolePremission implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6188413252566500901L;
	private Long id;
	private Long roleId;
	private Long functionId;
	private Timestamp creationTime;
	private String createdBy;
	private Timestamp lastUpdateTime;
	private Integer isStart;

	// Constructors

	/** default constructor */
	public AsRolePremission() {
	}

	/** minimal constructor */
	public AsRolePremission(Long roleId, Long functionId, Timestamp creationTime, String createdBy) {
		this.roleId = roleId;
		this.functionId = functionId;
		this.creationTime = creationTime;
		this.createdBy = createdBy;
	}

	/** full constructor */
	public AsRolePremission(Long roleId, Long functionId, Timestamp creationTime, String createdBy,
			Timestamp lastUpdateTime, Integer isStart) {
		this.roleId = roleId;
		this.functionId = functionId;
		this.creationTime = creationTime;
		this.createdBy = createdBy;
		this.lastUpdateTime = lastUpdateTime;
		this.isStart = isStart;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(Long functionId) {
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