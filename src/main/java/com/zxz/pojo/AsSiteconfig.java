package com.zxz.pojo;

/**
 * AsSiteconfig entity. @author MyEclipse Persistence Tools
 */

public class AsSiteconfig implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1819205973531770966L;
	private String siteName;

	// Constructors

	/** default constructor */
	public AsSiteconfig() {
	}

	/** full constructor */
	public AsSiteconfig(String siteName) {
		this.siteName = siteName;
	}

	// Property accessors

	public String getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

}