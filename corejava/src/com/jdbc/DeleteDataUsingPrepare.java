package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDataUsingPrepare {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver"); //Type IV Driver
		Connection dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");
		System.out.println("Connection established");
		PreparedStatement pstmt1=dbcon.prepareStatement("DELETE FROM newtable WHERE Id=41");
		
		int update1=pstmt1.executeUpdate();
		System.out.println("DATABASE DELETED !!");
		pstmt1.close();
		dbcon.close();
	}

}
