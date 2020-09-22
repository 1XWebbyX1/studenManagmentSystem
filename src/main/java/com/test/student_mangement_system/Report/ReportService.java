/**
 * 
 */
package com.test.student_mangement_system.Report;

import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * @author den
 *
 */
@Component
public interface ReportService {

	Report getReportForStudent(int id);

	Set<Report> getAllReports();

}
