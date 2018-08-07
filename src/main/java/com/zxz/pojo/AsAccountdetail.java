package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsAccountdetail entity. @author MyEclipse Persistence Tools
 */

public class AsAccountdetail implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -4203940123620340430L;
	private Integer id;
	private Integer userId;
	private String userName;
	private Integer detailType;
	private String detailTypeName;
	private Double money;//账务资金
	private Double accountMoney;//账户余额
	private String memo;
	private Timestamp detailDateTime;

	// Constructors

	/** default constructor */
	public AsAccountdetail() {
	}

	/** minimal constructor */
	public AsAccountdetail(Integer userId, Integer detailType, String detailTypeName, Double money, Double accountMoney,
			Timestamp detailDateTime) {
		this.userId = userId;
		this.detailType = detailType;
		this.detailTypeName = detailTypeName;
		this.money = money;
		this.accountMoney = accountMoney;
		this.detailDateTime = detailDateTime;
	}

	/** full constructor */
	public AsAccountdetail(Integer userId, Integer detailType, String detailTypeName, Double money, Double accountMoney,
			String memo, Timestamp detailDateTime) {
		this.userId = userId;
		this.detailType = detailType;
		this.detailTypeName = detailTypeName;
		this.money = money;
		this.accountMoney = accountMoney;
		this.memo = memo;
		this.detailDateTime = detailDateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDetailType() {
		return this.detailType;
	}

	public void setDetailType(Integer detailType) {
		this.detailType = detailType;
	}

	public String getDetailTypeName() {
		return this.detailTypeName;
	}

	public void setDetailTypeName(String detailTypeName) {
		this.detailTypeName = detailTypeName;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getAccountMoney() {
		return this.accountMoney;
	}

	public void setAccountMoney(Double accountMoney) {
		this.accountMoney = accountMoney;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getDetailDateTime() {
		return this.detailDateTime;
	}

	public void setDetailDateTime(Timestamp detailDateTime) {
		this.detailDateTime = detailDateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}