package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementExecute{

	public static void main(String[] args)  throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); //Type IV Driver
		Connection dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");
		System.out.println("Connection established");
		insert(dbcon);
		delete(dbcon);
		read(dbcon);
		
			
	}
	public static void insert(Connection dbcon) throws Exception{
		PreparedStatement pstmt=dbcon.prepareStatement("INSERT INTO newtable VALUES(?,?,?)");
		pstmt.setInt(1,34);
		pstmt.setString(2,"Raj");
		pstmt.setInt(3,96850);
		int update=pstmt.executeUpdate();
		System.out.println("DATABASE UPDATED !!");
		pstmt.close();
		
	}
	public static void delete(Connection dbcon) throws Exception{
		PreparedStatement pstmt1=dbcon.prepareStatement("DELETE FROM newtable WHERE Id=92");
		int update1=pstmt1.executeUpdate();
		System.out.println("DATABASE DELETED !!");
		pstmt1.close();
		
	}
	public static void read(Connection dbcon) throws Exception{
		PreparedStatement pstmt2=dbcon.prepareStatement("SELECT * FROM newtable");
		ResultSet rs=pstmt2.executeQuery();
		
		System.out.println("DATABASE !!");
		pstmt2.close();
		while(rs.next()) {
			int id=rs.getInt("Id");
			String name=rs.getString("name");
			int salary=rs.getInt("salary");
			System.out.println(id+"-"+name+"-"+salary);
		
		}
		rs.close();
	}
}


