/**
 * 
 */
package com.test.student_mangement_system;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author den
 *
 */
public class ConnectionFactory {
	private static String url;
	private static String password;
	private static String user;

	static {
		try {
			Properties pros = new Properties();
			InputStream file = ConnectionFactory.class.getResourceAsStream("/properties/db.properties");
			pros.load(file);
			
			ConnectionFactory.url = pros.getProperty("url");
			ConnectionFactory.password = pros.getProperty("password");
			ConnectionFactory.user = pros.getProperty("user");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	private ConnectionFactory() {

	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		System.out.println(url + password + user);
		conn = DriverManager.getConnection(url, user, password);

		return conn;
	}

}
