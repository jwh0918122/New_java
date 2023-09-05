package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BoardController;
import domain.BoardVO;
import orm.DatabaseBuiler;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	// DB연결
	private SqlSession sql; // ibatis에 지원하는 sql session
	private final String NS = "BoardMapper.";// NS = NameSpace.id 인식

	public BoardDAOImpl() {
		new DatabaseBuiler();
		sql = DatabaseBuiler.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info("insert dao check 3");
		int isOk = sql.insert(NS + "add", bvo); // BoardMapper.add를 실행해라는 의미
		if (isOk > 0) { // insert, update, delete 시 commit이 필요.
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<BoardVO> selectList() {
		log.info("selectList dao check 3");

		return sql.selectList(NS + "list");
	}

	@Override
	public BoardVO selectOne(int bno) {
		log.info("detail check 3");
		return sql.selectOne(NS+"detail",bno);
	}

}