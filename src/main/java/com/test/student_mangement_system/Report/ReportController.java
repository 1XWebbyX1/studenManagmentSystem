/**
 * 
 */
package com.test.student_mangement_system.Report;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author den
 *
 */

@RestController
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	private ReportService service;

	@GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
	public Report getReportForStudentId(@PathVariable("id") int id) {
		Report report = service.getReportForStudent(id);
		return report;
	}

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public Set<Report> getAllReports() {
		Set<Report> reports = service.getAllReports();
		return reports;
	}

}
