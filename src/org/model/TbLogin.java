package org.model;

/**
 * TbLogin entity. @author MyEclipse Persistence Tools
 */

public class TbLogin implements java.io.Serializable {

	// Fields

	private String id;
	private String password;
	private Integer iden;

	// Constructors

	/** default constructor */
	public TbLogin() {
	}

	/** full constructor */
	public TbLogin(String password, Integer iden) {
		this.password = password;
		this.iden = iden;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIden() {
		return this.iden;
	}

	public void setIden(Integer iden) {
		this.iden = iden;
	}

}