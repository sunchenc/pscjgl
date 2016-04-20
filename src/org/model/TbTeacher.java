package org.model;

/**
 * TbTeacher entity. @author MyEclipse Persistence Tools
 */

public class TbTeacher implements java.io.Serializable {

	// Fields

	private String teacherId;
	private String teacherName;

	// Constructors

	/** default constructor */
	public TbTeacher() {
	}

	/** full constructor */
	public TbTeacher(String teacherId, String teacherName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	// Property accessors

	public String getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}