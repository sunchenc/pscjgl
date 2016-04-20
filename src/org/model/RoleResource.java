package org.model;

/**
 * RoleResource entity. @author MyEclipse Persistence Tools
 */

public class RoleResource implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer iden;
	private String resources;

	// Constructors

	/** default constructor */
	public RoleResource() {
	}

	/** minimal constructor */
	public RoleResource(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public RoleResource(Integer id, Integer iden, String resources) {
		this.id = id;
		this.iden = iden;
		this.resources = resources;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIden() {
		return this.iden;
	}

	public void setIden(Integer iden) {
		this.iden = iden;
	}

	public String getResources() {
		return this.resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

}