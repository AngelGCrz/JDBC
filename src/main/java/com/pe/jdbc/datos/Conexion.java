package com.pe.jdbc.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
																		
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_ROOT = "root";
	private static final String JDBC_PASS = "1224";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_ROOT, JDBC_PASS);
	}
	
	public void close(PreparedStatement pst) throws SQLException {
		pst.close();
	}
	public void close(Statement st) throws SQLException {
		st.close();
	}
	public void close(ResultSet rs) throws SQLException {
		rs.close();
	}
	public void close(Connection con) throws SQLException {
		con.close();
	}
}
