package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsUser entity. @author MyEclipse Persistence Tools
 */

public class AsUser implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1449080659920949633L;
	private Long id;
	private String userCode;
	private String userName;
	private String userPassword;
	private Timestamp creationTime;
	private Timestamp lastLoginTime;
	private String createdBy;
	private Timestamp lastUpdateTime;
	private Integer isStart;
	private Long roleId;

	private String roleName;
	
	// Constructors

	/** default constructor */
	public AsUser() {
	}

	/** minimal constructor */
	public AsUser(String userCode, String userName, String userPassword, Timestamp creationTime, String createdBy,
			Long roleId) {
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.creationTime = creationTime;
		this.createdBy = createdBy;
		this.roleId = roleId;
	}

	/** full constructor */
	public AsUser(String userCode, String userName, String userPassword, Timestamp creationTime,
			Timestamp lastLoginTime, String createdBy, Timestamp lastUpdateTime, Integer isStart, Long roleId) {
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.creationTime = creationTime;
		this.lastLoginTime = lastLoginTime;
		this.createdBy = createdBy;
		this.lastUpdateTime = lastUpdateTime;
		this.isStart = isStart;
		this.roleId = roleId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}