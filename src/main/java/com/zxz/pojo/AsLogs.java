package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsLogs entity. @author MyEclipse Persistence Tools
 */

public class AsLogs implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -8188798054642387742L;
	private Long id;
	private Long userId;
	private String userName;
	private String operateInfo;
	private Timestamp operateDatetime;

	// Constructors

	/** default constructor */
	public AsLogs() {
	}

	/** full constructor */
	public AsLogs(Long userId, String userName, String operateInfo, Timestamp operateDatetime) {
		this.userId = userId;
		this.userName = userName;
		this.operateInfo = operateInfo;
		this.operateDatetime = operateDatetime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperateInfo() {
		return this.operateInfo;
	}

	public void setOperateInfo(String operateInfo) {
		this.operateInfo = operateInfo;
	}

	public Timestamp getOperateDatetime() {
		return this.operateDatetime;
	}

	public void setOperateDatetime(Timestamp operateDatetime) {
		this.operateDatetime = operateDatetime;
	}

}