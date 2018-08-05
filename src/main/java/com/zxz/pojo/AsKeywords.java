package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AsKeywords entity. @author MyEclipse Persistence Tools
 */

public class AsKeywords implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 8150510879056144053L;
	private Integer id;
	private String keywords;
	private Integer agentId;
	private String agentName;
	private Integer customId;
	private String customName;
	private Double preRegFrozenMoney;
	private Double price;
	private Integer productType;
	private String serviceName;
	private Integer serviceYears;
	private Integer openApp;
	private String appUserName;
	private String appPassword;
	private String loginUrl;
	private String iosDownloadUrl;
	private String androidDownloadUrl;
	private String codeIosUrl;
	private String codeAndroidUrl;
	private Timestamp preRegDatetime;
	private Timestamp preRegPassDatetime;
	private Timestamp regDatetime;
	private Timestamp regPassDatetime;
	private Integer isPass;
	private Integer checkStatus;
	private Integer isUse;

	// Constructors

	/** default constructor */
	public AsKeywords() {
	}


	public AsKeywords(Timestamp regDatetime, Timestamp regPassDatetime) {
		super();
		this.regDatetime = regDatetime;
		this.regPassDatetime = regPassDatetime;
	}


	public AsKeywords(String keywords, Integer isUse) {
		super();
		this.keywords = keywords;
		this.isUse = isUse;
	}



	/** minimal constructor */
	public AsKeywords(String keywords, Integer agentId, String agentName, Integer customId, String customName,
			Double preRegFrozenMoney, Double price) {
		this.keywords = keywords;
		this.agentId = agentId;
		this.agentName = agentName;
		this.customId = customId;
		this.customName = customName;
		this.preRegFrozenMoney = preRegFrozenMoney;
		this.price = price;
	}

	/** full constructor */
	public AsKeywords(String keywords, Integer agentId, String agentName, Integer customId, String customName,
			Double preRegFrozenMoney, Double price, Integer productType, Integer serviceYears, Integer openApp,
			String appUserName, String appPassword, String loginUrl, String iosDownloadUrl, String androidDownloadUrl,
			String codeIosUrl, String codeAndroidUrl, Timestamp preRegDatetime, Timestamp preRegPassDatetime,
			Timestamp regDatetime, Timestamp regPassDatetime, Integer isPass, Integer checkStatus, Integer isUse) {
		this.keywords = keywords;
		this.agentId = agentId;
		this.agentName = agentName;
		this.customId = customId;
		this.customName = customName;
		this.preRegFrozenMoney = preRegFrozenMoney;
		this.price = price;
		this.productType = productType;
		this.serviceYears = serviceYears;
		this.openApp = openApp;
		this.appUserName = appUserName;
		this.appPassword = appPassword;
		this.loginUrl = loginUrl;
		this.iosDownloadUrl = iosDownloadUrl;
		this.androidDownloadUrl = androidDownloadUrl;
		this.codeIosUrl = codeIosUrl;
		this.codeAndroidUrl = codeAndroidUrl;
		this.preRegDatetime = preRegDatetime;
		this.preRegPassDatetime = preRegPassDatetime;
		this.regDatetime = regDatetime;
		this.regPassDatetime = regPassDatetime;
		this.isPass = isPass;
		this.checkStatus = checkStatus;
		this.isUse = isUse;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getAgentId() {
		return this.agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Integer getCustomId() {
		return this.customId;
	}

	public void setCustomId(Integer customId) {
		this.customId = customId;
	}

	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public Double getPreRegFrozenMoney() {
		return this.preRegFrozenMoney;
	}

	public void setPreRegFrozenMoney(Double preRegFrozenMoney) {
		this.preRegFrozenMoney = preRegFrozenMoney;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getProductType() {
		return this.productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getServiceYears() {
		return this.serviceYears;
	}

	public void setServiceYears(Integer serviceYears) {
		this.serviceYears = serviceYears;
	}

	public Integer getOpenApp() {
		return this.openApp;
	}

	public void setOpenApp(Integer openApp) {
		this.openApp = openApp;
	}

	public String getAppUserName() {
		return this.appUserName;
	}

	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}

	public String getAppPassword() {
		return this.appPassword;
	}

	public void setAppPassword(String appPassword) {
		this.appPassword = appPassword;
	}

	public String getLoginUrl() {
		return this.loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getIosDownloadUrl() {
		return this.iosDownloadUrl;
	}

	public void setIosDownloadUrl(String iosDownloadUrl) {
		this.iosDownloadUrl = iosDownloadUrl;
	}

	public String getAndroidDownloadUrl() {
		return this.androidDownloadUrl;
	}

	public void setAndroidDownloadUrl(String androidDownloadUrl) {
		this.androidDownloadUrl = androidDownloadUrl;
	}

	public String getCodeIosUrl() {
		return this.codeIosUrl;
	}

	public void setCodeIosUrl(String codeIosUrl) {
		this.codeIosUrl = codeIosUrl;
	}

	public String getCodeAndroidUrl() {
		return this.codeAndroidUrl;
	}

	public void setCodeAndroidUrl(String codeAndroidUrl) {
		this.codeAndroidUrl = codeAndroidUrl;
	}

	public Timestamp getPreRegDatetime() {
		return this.preRegDatetime;
	}

	public void setPreRegDatetime(Timestamp preRegDatetime) {
		this.preRegDatetime = preRegDatetime;
	}

	public Timestamp getPreRegPassDatetime() {
		return this.preRegPassDatetime;
	}

	public void setPreRegPassDatetime(Timestamp preRegPassDatetime) {
		this.preRegPassDatetime = preRegPassDatetime;
	}

	public Timestamp getRegDatetime() {
		return this.regDatetime;
	}

	public void setRegDatetime(Timestamp regDatetime) {
		this.regDatetime = regDatetime;
	}

	public Timestamp getRegPassDatetime() {
		return this.regPassDatetime;
	}

	public void setRegPassDatetime(Timestamp regPassDatetime) {
		this.regPassDatetime = regPassDatetime;
	}

	public Integer getIsPass() {
		return this.isPass;
	}

	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}