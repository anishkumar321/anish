package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMySqlMain {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); //Type IV Driver
		Connection dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");
		System.out.println("Connection established");
		Statement stmt=dbcon.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM newtable");
		while(rs.next()) {
			int id=rs.getInt("Id");
			String name=rs.getString("name");
			int salary=rs.getInt("salary");
			System.out.println(id+"-"+name+"-"+salary);
		}
		System.out.println("After update");
		stmt.executeUpdate("INSERT INTO newtable VALUES(38,'Zuneth',85000)");
		while(rs.next()) {
			int id=rs.getInt("Id");
			String name=rs.getString("name");
			int salary=rs.getInt("salary");
			System.out.println(id+"-"+name+"-"+salary);
		}
		rs.close();
		stmt.close();
		dbcon.close();

	}

}
