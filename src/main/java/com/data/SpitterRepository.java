package com.data;

import java.sql.SQLException;

public interface SpitterRepository {
	boolean save(Spitter spitter) throws SQLException,ClassNotFoundException;
	Spitter findByUsername(String username) throws SQLException,ClassNotFoundException;
}
