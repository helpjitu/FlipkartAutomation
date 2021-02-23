package com;

import base.Page;
import org.testng.annotations.Test;

import base.Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MySqlConTest extends Page {

	static String ConnectionUrl = "jdbc:mysql://localhost:3306/"+loadProp().getProperty("database");
	static String user = "jitu";
	static String password = "jitu@123";
	static String query = loadProp().getProperty("query");
	static String space = "          ";

	@Test
	public static void retrieveData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			LOGGER.info("Creating connection");
			Connection con = DriverManager.getConnection(ConnectionUrl, user, password);
			// here selenium is database name, jitu is username and jitu@123 is password
			System.out.println("Connection complete");
			java.sql.Statement stmt = con.createStatement();
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);

			ResultSetMetaData rsmd = rs.getMetaData();
			String column1 = rsmd.getColumnName(1);
			String column2 = rsmd.getColumnName(2);
			String column3 = rsmd.getColumnName(3);
			System.out.println(column1 + " " + column2 + " " + column3);
			while (rs.next())
				System.out.println(rs.getString(1) + space + rs.getString(2) + space + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
