/**
 * 
 */
package com.test.student_mangement_system.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.test.student_mangement_system.ConnectionFactory;
import com.test.student_mangement_system.Student.Student;

/**
 * @author den
 *
 */
@Component
public class ReportServiceImpl  implements ReportService {

	private static Report extractReportFromResultSet(ResultSet rs) throws SQLException {
		Report report = new Report();

		report.setStudentId(rs.getInt("student_id"));
		report.setEnglish(rs.getInt("english"));
		report.setMaths(rs.getInt("maths"));
		report.setScience(rs.getInt("science"));

		return report;
	}

	
	public Report getReportForStudent(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = (Statement) conn.createStatement();
			String query = "SELECT * FROM reports WHERE student_id=" + id;
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				Report report = extractReportFromResultSet(rs);
				return report;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public Set<Report> getAllReports() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = (Statement) conn.createStatement();
			String query = "SELECT * FROM reports";
			rs = stmt.executeQuery(query);

			Set<Report> reports = new HashSet<Report>();

			while (rs.next()) {
				Report report = extractReportFromResultSet(rs);
				reports.add(report);
			}

			return reports;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

}
