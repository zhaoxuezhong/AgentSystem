package com.zxz.pojo;

/**
 * AsAdmin entity. @author MyEclipse Persistence Tools
 */

public class AsAdmin implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 6350513037998069085L;
	private Integer id;
	private String username;

	// Constructors

	/** default constructor */
	public AsAdmin() {
	}

	/** full constructor */
	public AsAdmin(String username) {
		this.username = username;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}