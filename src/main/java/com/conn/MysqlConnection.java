package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnection {
	public static Connection getConnection() throws SQLException,ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/spittr";
		String username = "root";
		String password = "root";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection(url,username,password);
		return conn;
	}
/*public static void main(String[] args) throws Exception {
	Connection conn = getConnection();
	Statement stmt = conn.createStatement();
	String query = "select * from spitter";
	ResultSet rs = stmt.executeQuery(query);
	while (rs.next()){
		System.out.print(rs.getInt(1)+" ");
		System.out.print(rs.getString(2)+" ");
		System.out.print(rs.getString(3)+" ");
		System.out.print(rs.getString(4)+" ");
		System.out.println(rs.getString(5)+" ");
	}
	con.close();
}*/
}
