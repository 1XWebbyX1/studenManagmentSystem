/**
 * 
 */
package com.test.student_mangement_system.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.test.student_mangement_system.ConnectionFactory;

/**
 * @author den
 *
 */
@Component
public class StudentServiceImpl implements StudentService {

	private static Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
		Student student = new Student();

		student.setId(rs.getInt("id"));
		student.setFirstName(rs.getString("first_name"));
		student.setLastName(rs.getString("last_name"));
		student.setEmail(rs.getString("email"));
		student.setSchoolId(rs.getString("school_id"));

		return student;
	}

	public boolean insert(Student student) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pAssignStmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "INSERT INTO students(first_name,last_name,email, school_id) " + "VALUES (?, ?, ?,?)";
			pstmt = (PreparedStatement) conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, student.getFirstName());
			pstmt.setString(2, student.getLastName());
			pstmt.setString(3, student.getEmail());
			pstmt.setString(4, student.getSchoolId());

			int rowsChanged = pstmt.executeUpdate();
			int studentId = 0;

			rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				studentId = rs.getInt(1);
				System.out.println(rs.getInt(1));
			}
			if (rowsChanged == 1) {

				String assignQuery = "INSERT INTO reports(student_id) VALUES(?)";
				pAssignStmt = (PreparedStatement) conn.prepareStatement(assignQuery);

				pAssignStmt.setInt(1, studentId);

				int rowsUpdated = pAssignStmt.executeUpdate();
				if (rowsUpdated == 1) {
					conn.commit();
					return true;
				}

			} else
				conn.rollback();

		} catch (SQLException e) {
			if (conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	}

	public Set<Student> getAllStudents() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = (Statement) conn.createStatement();
			String query = "SELECT * FROM students";
			rs = stmt.executeQuery(query);

			Set<Student> students = new HashSet<Student>();

			while (rs.next()) {
				Student student = extractStudentFromResultSet(rs);
				students.add(student);
			}

			return students;
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

	public Student getStudent(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = (Statement) conn.createStatement();
			String query = "SELECT * FROM students WHERE id=" + id;
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				Student student = extractStudentFromResultSet(rs);
				return student;
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
	

	public boolean deleteStudent(int id) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = (Statement) conn.createStatement();
			String query = "DELETE FROM students WHERE id=" + id;
			int rowsAffected = stmt.executeUpdate(query);

			if (rowsAffected == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	}


}
