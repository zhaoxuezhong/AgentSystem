package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsRole entity. @author MyEclipse Persistence Tools
 */

public class AsRole implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -838928086019053165L;
	private Long id;
	private String roleName;
	private Timestamp creationTime;
	private String createdBy;
	private Timestamp lastUpdateTime;
	private Integer isStart;

	// Constructors

	/** default constructor */
	public AsRole() {
	}

	/** minimal constructor */
	public AsRole(String roleName, Timestamp creationTime, String createdBy) {
		this.roleName = roleName;
		this.creationTime = creationTime;
		this.createdBy = createdBy;
	}

	/** full constructor */
	public AsRole(String roleName, Timestamp creationTime, String createdBy, Timestamp lastUpdateTime,
			Integer isStart) {
		this.roleName = roleName;
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

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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