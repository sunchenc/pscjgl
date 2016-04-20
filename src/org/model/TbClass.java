package org.model;

/**
 * TbClass entity. @author MyEclipse Persistence Tools
 */

public class TbClass implements java.io.Serializable {

	// Fields

	private Integer id;
	private String className;
	private Integer number;
	private TbTeacher teacher;

	// Constructors

	/** default constructor */
	public TbClass() {
	}

	/** full constructor */
	public TbClass(String className, Integer number, TbTeacher teacher) {
		this.className = className;
		this.number = number;
		this.teacher = teacher;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public TbTeacher getTeacher() {
		return teacher;
	}

	public void setTeacher(TbTeacher teacher) {
		this.teacher = teacher;
	}
		public boolean equals(Object obj) {   
	        if (obj instanceof TbClass) {   
	        	TbClass u = (TbClass) obj;   
	            return this.id.equals(u.id);   
	        }   
	        return super.equals(obj);  
	}
	

}