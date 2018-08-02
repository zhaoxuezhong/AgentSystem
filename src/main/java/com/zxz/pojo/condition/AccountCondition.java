package com.zxz.pojo.condition;

import java.sql.Timestamp;

/**
 * @author zhaoxuezhong
 *	AccountCondition
 */
public class AccountCondition {
	
	private Integer id;
	private String userCode;
	private Integer detailType;
	private Timestamp startTime;
	private Timestamp endTime;
	
	public AccountCondition() {
		super();
	}
	public AccountCondition(Integer id) {
		super();
		this.id = id;
	}
	public AccountCondition(Integer id, String userCode) {
		super();
		this.id = id;
		this.userCode = userCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public Integer getDetailType() {
		return detailType;
	}
	public void setDetailType(Integer detailType) {
		this.detailType = detailType;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}
