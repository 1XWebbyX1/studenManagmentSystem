/**
 * 
 */
package com.test.student_mangement_system.Student;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author den
 *
 */

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
	public Student getStudentById(@PathVariable("id") int id) {
		Student student = service.getStudent(id);
		return student;
	}

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public Set<Student> getAllStudents() {
		Set<Student> students = service.getAllStudents();
		return students;
	}

	@DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
	public boolean delete(@PathVariable("id") int id) {
		return service.deleteStudent(id);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Student resource) {
        return service.insert(resource);
    }

}
