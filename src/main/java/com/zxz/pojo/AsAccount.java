package com.zxz.pojo;

/**
 * AsAccount entity. @author MyEclipse Persistence Tools
 */

public class AsAccount implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 5631657155705866265L;
	private Long id;
	private Long userId;
	private Double money;
	private Double moneyBak;

	// Constructors

	/** default constructor */
	public AsAccount() {
	}

	/** full constructor */
	public AsAccount(Long userId, Double money, Double moneyBak) {
		this.userId = userId;
		this.money = money;
		this.moneyBak = moneyBak;
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

}