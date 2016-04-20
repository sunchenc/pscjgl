package org.model;

/**
 * TbStudent entity. @author MyEclipse Persistence Tools
 */

public class TbStudent implements java.io.Serializable {

	// Fields

	private String studentId;
	private String studentName;
	//private Integer studentClass;
	private TbClass tbclass;
	private Float totalGrade;

	// Constructors

	/** default constructor */
	public TbStudent() {
	}

	/** minimal constructor */
	public TbStudent(String studentId) {
		this.studentId = studentId;
	}

	/** full constructor */
	public TbStudent(String studentId, String studentName,
			TbClass studentClass, Float totalGrade) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.tbclass = studentClass;
		this.totalGrade = totalGrade;
	}

	// Property accessors

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public TbClass getTbclass() {
		return tbclass;
	}

	public void setTbclass(TbClass tbclass) {
		this.tbclass = tbclass;
	}


	public Float getTotalGrade() {
		return this.totalGrade;
	}

	public void setTotalGrade(Float totalGrade) {
		this.totalGrade = totalGrade;
	}

}