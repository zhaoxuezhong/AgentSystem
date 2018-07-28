package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsCustoms entity. @author MyEclipse Persistence Tools
 */

public class AsCustoms implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -5259017670045804847L;
	private Long id;
	private Long agentId;
	private String agentName;
	private String customName;
	private Integer customType;
	private String customTypeName;
	private String siteUrl;
	private Integer customStatus;
	private String bossName;
	private Integer cardType;
	private String cardTypeName;
	private String cardNum;
	private String companyTel;
	private String companyFax;
	private Timestamp regDatetime;
	private String country;
	private String province;
	private String city;
	private String area;
	private String companyAddress;
	private String memo;
	private String agentCode;

	// Constructors

	/** default constructor */
	public AsCustoms() {
	}

	/** minimal constructor */
	public AsCustoms(Long agentId) {
		this.agentId = agentId;
	}

	/** full constructor */
	public AsCustoms(Long agentId, String agentName, String customName, Integer customType, String customTypeName,
			String siteUrl, Integer customStatus, String bossName, Integer cardType, String cardTypeName,
			String cardNum, String companyTel, String companyFax, Timestamp regDatetime, String country,
			String province, String city, String area, String companyAddress, String memo, String agentCode) {
		this.agentId = agentId;
		this.agentName = agentName;
		this.customName = customName;
		this.customType = customType;
		this.customTypeName = customTypeName;
		this.siteUrl = siteUrl;
		this.customStatus = customStatus;
		this.bossName = bossName;
		this.cardType = cardType;
		this.cardTypeName = cardTypeName;
		this.cardNum = cardNum;
		this.companyTel = companyTel;
		this.companyFax = companyFax;
		this.regDatetime = regDatetime;
		this.country = country;
		this.province = province;
		this.city = city;
		this.area = area;
		this.companyAddress = companyAddress;
		this.memo = memo;
		this.agentCode = agentCode;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgentId() {
		return this.agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public Integer getCustomType() {
		return this.customType;
	}

	public void setCustomType(Integer customType) {
		this.customType = customType;
	}

	public String getCustomTypeName() {
		return this.customTypeName;
	}

	public void setCustomTypeName(String customTypeName) {
		this.customTypeName = customTypeName;
	}

	public String getSiteUrl() {
		return this.siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public Integer getCustomStatus() {
		return this.customStatus;
	}

	public void setCustomStatus(Integer customStatus) {
		this.customStatus = customStatus;
	}

	public String getBossName() {
		return this.bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public Integer getCardType() {
		return this.cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCardTypeName() {
		return this.cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCompanyTel() {
		return this.companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getCompanyFax() {
		return this.companyFax;
	}

	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}

	public Timestamp getRegDatetime() {
		return this.regDatetime;
	}

	public void setRegDatetime(Timestamp regDatetime) {
		this.regDatetime = regDatetime;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAgentCode() {
		return this.agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

}