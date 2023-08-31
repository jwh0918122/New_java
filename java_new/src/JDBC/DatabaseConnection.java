package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	// DB 접속
	// DB Driver, Url, user, password
	// Driver => com.mysql.cj.jdbc.Driver
	// Url => jdbc:mysql://localhost:3306/productdb (정해져있는거. 뒤에 db명만 바꾸면 됨...?)

	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null; // Connection import(연결정보 넣을 곳)
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/productdb"; //mysql고정된url.뒤에 db이름만 바꾸면 됨

	// 생성자를 private으로 생성
	private DatabaseConnection() {
		// DB연결 시 반드시 try~catch를 사용해야 함(연결이 안될 수 있으니까)
		try {
			Class.forName(jdbcDriver); // Driver를 로드하기 위해 사용되는 메서드
			conn = DriverManager.getConnection(jdbcUrl, "mysqluser", "mysql");// url 연결 메서드 url, user, password필요

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결정보가 정확하지 않습니다(url, user, password중에 문제있음)");
			e.printStackTrace();
		}
	}

	public static DatabaseConnection getInstance() {
		return dbc;
	}

	public Connection getConnection() {
		return conn;
	}

}
