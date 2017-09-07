package cn.javayuan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 李明元
 *
 * @email:limingyuan1996@outlook.com
 *
 */
public class DBHelper {
	private String dbUrl = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
	private String dbUser = "root";
	private String dbPassword = "1371271347";
	private String jdbcName = "com.mysql.jdbc.Driver";

	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(jdbcName);
		} catch (Exception e) {
		}
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException ex) {
		}
		return conn;
	}
}
