package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log=LoggerFactory.getLogger(BoardDAOImpl.class);
	
	//DB와 연결
	private SqlSession sql;
	private final String NS="BoardMapper.";//namespace.id
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	//insert
	public int insert(BoardVO bvo) {
		log.info("insert bdao ok");
		int isOk=sql.insert(NS+"add",bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//selectList
	public List<BoardVO> list() {
		log.info("list bdao ok");		
		
		return sql.selectList(NS+"selectList");
	}

	@Override
	//selectOne
	public BoardVO selectOne(int bno) {
		log.info("detail bdao ok");
		return sql.selectOne(NS+"selectOne",bno);
	}

	@Override
	//modify
	public int modify(BoardVO bvo) {
		log.info("modify bdao ok");
		int isOk=sql.update(NS+"modify", bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//remove
	public int remove(int bno) {
		log.info("remove bdao ok");
		int isOk=sql.delete(NS+"remove", bno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//getTotalCount
	public int getTotalCount() {
		
		return sql.selectOne(NS+"cnt");
	}

	@Override
	//getPageList
	public List<BoardVO> getPageList(PagingVO pgvo) {
		
		return sql.selectList(NS+"page", pgvo);
	}

}
