/**
 * 
 */
package com.test.student_mangement_system.Student;

/**
 * @author den
 *
 */
public class Student {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
		
	private String email;
	
	private String schoolId;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String email, String schoolId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.schoolId = schoolId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	@Override
	public String toString() {
		return "id: " + id + " first_name: " + firstName + " last_name: " + lastName;
	}

}
