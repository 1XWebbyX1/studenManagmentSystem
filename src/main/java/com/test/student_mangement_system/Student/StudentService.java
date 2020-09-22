/**
 * 
 */
package com.test.student_mangement_system.Student;

import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * @author den
 *
 */
@Component
public interface StudentService {

	Student getStudent(int id);

	Set<Student> getAllStudents();

	boolean deleteStudent(int id);

	boolean insert(Student resource);

}
