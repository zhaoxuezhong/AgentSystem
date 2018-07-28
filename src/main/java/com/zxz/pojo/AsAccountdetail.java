package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsAccountdetail entity. @author MyEclipse Persistence Tools
 */

public class AsAccountdetail implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -4203940123620340430L;
	private Long id;
	private Long userId;
	private Long detailType;
	private String detailTypeName;
	private Double money;
	private Double accountMoney;
	private String memo;
	private Timestamp detailDateTime;

	// Constructors

	/** default constructor */
	public AsAccountdetail() {
	}

	/** minimal constructor */
	public AsAccountdetail(Long userId, Long detailType, String detailTypeName, Double money, Double accountMoney,
			Timestamp detailDateTime) {
		this.userId = userId;
		this.detailType = detailType;
		this.detailTypeName = detailTypeName;
		this.money = money;
		this.accountMoney = accountMoney;
		this.detailDateTime = detailDateTime;
	}

	/** full constructor */
	public AsAccountdetail(Long userId, Long detailType, String detailTypeName, Double money, Double accountMoney,
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

	public Long getDetailType() {
		return this.detailType;
	}

	public void setDetailType(Long detailType) {
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

}