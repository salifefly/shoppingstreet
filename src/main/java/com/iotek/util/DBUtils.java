package com.iotek.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String pwd;
	static {
		InputStream is = DBUtils.class.getResourceAsStream("/db.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
			driver = prop.getProperty("mysql.driver");
			url = prop.getProperty("mysql.url");
			username = prop.getProperty("mysql.username");
			pwd = prop.getProperty("mysql.pwd");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

//		1. 注册驱动 com.mysql.jdbc.Driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
//		2. 获取连接
		return DriverManager.getConnection(url, username, pwd);
	}

	public static void close(Statement stmt, Connection conn) {
		close(null, stmt, conn);
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
//		5. 关闭资源
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
