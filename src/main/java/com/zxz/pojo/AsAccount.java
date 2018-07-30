package com.zxz.pojo;

/**
 * AsAccount entity. @author MyEclipse Persistence Tools
 */

public class AsAccount implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -1286548958241553185L;
	private Integer id;
	private Integer userId;
	private String userName;
	private Double money;
	private Double moneyBak;
	private AsAccountdetail accountDetail;

	// Constructors

	/** default constructor */
	public AsAccount() {
	}

	/** full constructor */
	public AsAccount(Integer userId, Double money, Double moneyBak) {
		this.userId = userId;
		this.money = money;
		this.moneyBak = moneyBak;
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

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getMoneyBak() {
		return this.moneyBak;
	}

	public void setMoneyBak(Double moneyBak) {
		this.moneyBak = moneyBak;
	}

	public AsAccountdetail getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(AsAccountdetail accountDetail) {
		this.accountDetail = accountDetail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}