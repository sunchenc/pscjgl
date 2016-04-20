package org.model;

import java.util.Date;

/**
 * TbWork entity. @author MyEclipse Persistence Tools
 */

public class TbWork implements java.io.Serializable {

	// Fields

	private Integer id;
	private String studentId;
	private Integer cishu;
	private String path;
	private String gradeDetail;
	private Float grade;
	private Date time;
	private String liuyan;

	// Constructors

	/** default constructor */
	public TbWork() {
	}

	/** full constructor */
	public TbWork(String studentId, Integer cishu, String path,
			String gradeDetail, Float grade, Date time, String liuyan) {
		this.studentId = studentId;
		this.cishu = cishu;
		this.path = path;
		this.gradeDetail = gradeDetail;
		this.grade = grade;
		this.time = time;
		this.liuyan = liuyan;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getCishu() {
		return this.cishu;
	}

	public void setCishu(Integer cishu) {
		this.cishu = cishu;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getGradeDetail() {
		return this.gradeDetail;
	}

	public void setGradeDetail(String gradeDetail) {
		this.gradeDetail = gradeDetail;
	}

	public Float getGrade() {
		return this.grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getLiuyan() {
		return this.liuyan;
	}

	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}

}