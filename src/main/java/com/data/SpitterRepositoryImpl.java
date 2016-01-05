package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.MysqlConnection;

public class SpitterRepositoryImpl implements SpitterRepository {

	@Override
	public boolean save(Spitter spitter) throws SQLException {
		Connection conn = MysqlConnection.getConnection();
		String query = "insert into spitter(username,password,firstName,lastName) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, spitter.getUsername());
		ps.setString(2, spitter.getPassword());
		ps.setString(3, spitter.getFirstName());
		ps.setString(4, spitter.getLastName());
		int i = ps.executeUpdate();
		conn.close();
		if(i<0) return false;
		return true;

	}

	@Override
	public Spitter findByUsername(String username) throws SQLException {
		Connection conn = MysqlConnection.getConnection();
		String query = "select * from spitter where username = "+username;
		PreparedStatement ps = conn.prepareStatement(query);
		boolean status = ps.execute(query);
		if(status) {
			ResultSet rs = ps.getResultSet();
			Spitter sp = new Spitter();
			while(rs.next()) {
				sp.setId(rs.getLong(1));
				sp.setUsername(rs.getString(2));
				sp.setPassword(rs.getString(3));
				sp.setFirstName(rs.getString(4));
				sp.setLastName(rs.getString(5));
			}
			return sp;
		}
		return null;
	}
	public static void main(String[] args) throws SQLException {
		SpitterRepository sr = new SpitterRepositoryImpl();
		Spitter spitter = new Spitter("saurabh123","saurabh123","saurabh","sharma");
		boolean status = sr.save(spitter);
		System.out.println(status);
		spitter = sr.findByUsername("siddhant");
		System.out.println(spitter.getUsername()+" "+spitter.getPassword());
	}
}
