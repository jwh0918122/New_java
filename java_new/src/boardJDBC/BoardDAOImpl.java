package boardJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAOImpl implements DAO {
	// DB연결
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";

	public BoardDAOImpl() {
		// DB객체 생성
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();

	}
//메서드 처리

	@Override
	// insert
	public int insert(BoardVO b) {
		System.out.println("write_DAO success!!");
		query = "insert into board(title,writer,content)values(?,?,?)";

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			return pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert Error");
		}

		return 0;
	}

	@Override
	// selectList
	public ArrayList<BoardVO> selectList() {
		System.out.println("list_DAO success!!");
		query = "select * from board order by bno desc";
		ArrayList<BoardVO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("regdate"),
						rs.getString("moddate"),
						rs.getInt("readcount")));

			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectList Error!!");
		}
		return null;
	}

	@Override
	// selectOne
	public BoardVO selectOne(int bno) {
		System.out.println("detail_DAO success!!");
		query = "select * from board where bno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				return new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("regdate"),
						rs.getString("moddate"),
						rs.getInt("readcount"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectOne Error!!");
		}
		return null;
	}

	@Override
	//update
	public int update(BoardVO b) {
		System.out.println("modify_DAO success!!");
		query="update board set title=?,writer=?,content=?,moddate=now() where bno=?";
		try {
			pst=conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			pst.setInt(4, b.getBno());
			return pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("modify Error!!");
		}
		return 0;
	}

	@Override
	//readcount
	public int readcount(int bno) {
		query="update board set readcount=readcount+1 where bno=?";
		try {
			pst=conn.prepareStatement(query);
			pst.setInt(1, bno);
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("readcount Error!!");
		}
		
		return 0;
	}

	@Override
	//delete
	public int delete(int bno) {
		System.out.println("remove_DAO success!!");
		query="delete from board where bno=?";
		try {
			pst=conn.prepareStatement(query);
			pst.setInt(1, bno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("delete Error!!");
		}
		return 0;
	}



}
