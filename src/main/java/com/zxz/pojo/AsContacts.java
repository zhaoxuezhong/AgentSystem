package com.zxz.pojo;

/**
 * AsContacts entity. @author MyEclipse Persistence Tools
 */

public class AsContacts implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -2777043909047023379L;
	private Integer id;
	private Integer customId;
	private String contactName;
	private String contactTel;
	private String contactFax;
	private String contactEmail;
	private String contactRole;

	// Constructors

	/** default constructor */
	public AsContacts() {
	}

	/** minimal constructor */
	public AsContacts(Integer customId) {
		this.customId = customId;
	}

	/** full constructor */
	public AsContacts(Integer customId, String contactName, String contactTel, String contactFax, String contactEmail,
			String contactRole) {
		this.customId = customId;
		this.contactName = contactName;
		this.contactTel = contactTel;
		this.contactFax = contactFax;
		this.contactEmail = contactEmail;
		this.contactRole = contactRole;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomId() {
		return this.customId;
	}

	public void setCustomId(Integer customId) {
		this.customId = customId;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactFax() {
		return this.contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactRole() {
		return this.contactRole;
	}

	public void setContactRole(String contactRole) {
		this.contactRole = contactRole;
	}

}