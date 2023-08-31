package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl implements DAO {
	// (DAO : data exccess object)
	// MVC패턴 : 커트롤러->서비스->다오->DB || 커트롤러<-서비스<-다오<-DB

	// DB연결
	private Connection conn; // Connection import

	// sql 구문을 실행시키는 기능을 갖는 객체
	private PreparedStatement pst;
	private String query = "";// 쿼리 구문 저장

	public ProductDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();

		conn = dbc.getConnection();
	}

	@Override
	// insert
	public int insert(Product p) {
		System.out.println("insert DAO success!!");
		query = "insert into product (pname, price, madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);// query구문을 가져가서 db에다가 입력해라
			pst.setString(1, p.getPname()); // 1번 물음표
			pst.setInt(2, p.getPrice()); // 2번 물음표
			pst.setString(3, p.getMadeby()); // 3번 물음표
			// insert, update, delete => executeUpdate() return int
			return pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	// selectList
	public ArrayList<Product> selectList() {
		System.out.println("list DAO success!!");
		query = "select * from product order by pno desc"; // 최신데이터가 위로 오게 pno 내림차순 조회
		ArrayList<Product> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(); // ResultSet import해줘.(pst.executeQuery는 select의 결과를 ResultSet형태로 리턴해줌)
			while (rs.next()) {// rs의 다음값이 있으면(조회되는 것이 여러개일 수 있으니까)
				list.add(new Product(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("selectList Error!!");
			e.printStackTrace();

		}
		return null;
	}

	@Override
	// selectOne
	public Product selectOne(int pno) {
		System.out.println("detail DAO success!!");
		query = "select * from product where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);// 1번 물음표에 pno넣기
			ResultSet rs = pst.executeQuery();// select의 결과값
			if (rs.next()) {
				return new Product(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price"), rs.getString("regdate"),
						rs.getString("madeby"));
			}
		} catch (SQLException e) {
			System.out.println("selectOne Error!!");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	// update
	public int update(Product p) {

		System.out.println("update DAO success!!");
		query = "update product set pname=?,price=?,madeby=?,regdate=now() where pno=?";
		try {
			// query 구문을 DB에 실행
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			return pst.executeUpdate();// 잘되면 1 안되면0 리턴하는 애

		} catch (SQLException e) {
			// SQL구문 오류
			System.out.println("update Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	// delete
	public int delete(int pno) {
		System.out.println("delete DAO success!!");
		query = "delete from product where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete Error!!");
			e.printStackTrace();
		}
		return 0;
	}

}
