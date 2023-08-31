package boardJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl="jdbc:mysql://localhost:3306/productdb";
	
	private DatabaseConnection() {
		try {
			Class.forName(jdbcDriver);
			conn=DriverManager.getConnection(jdbcUrl,"mysqluser","mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("url정보가 정확하지 않습니다.");
		}
	}
	
	public static DatabaseConnection getInstance() {
		return dbc;
	}
	public Connection getConnection() {
		return conn;
	}
}
