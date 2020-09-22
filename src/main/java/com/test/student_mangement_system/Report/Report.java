/**
 * 
 */
package com.test.student_mangement_system.Report;

/**
 * @author den
 *
 */
public class Report {
	
	private int studentId;
	
	private int english;
	
	private int maths;
	
	private int science;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}
	
	public String toString() {
		return "id: " + studentId + " maths: " + maths + " english: " + english;
	}
	

}
