package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	//DB 연결
	private SqlSession sql;
	private final String NS="BoardMapper."; //.id
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql=DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info("add DAO ok");
		int isOk=sql.insert(NS+"add", bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//list
	public List<BoardVO> selectAll() {
		log.info("list DAO ok");
		return sql.selectList(NS+"selectAll");
	}

	@Override
	//detail
	public BoardVO selectOne(int bno) {
		log.info("detail DAO ok");
		sql.update(NS+"detailcnt", bno);
		sql.commit();
		return sql.selectOne(NS+"selectOne", bno);
	}

	@Override
	//modify
	public int update(BoardVO bvo) {
		log.info("modify DAO ok");
		int isOk=sql.update(NS+"modify", bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//remove
	public int delete(int bno) {
		log.info("remove DAO ok");
		int isOk=sql.delete(NS+"remove", bno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//getTotalCount
	public int totalCount(PagingVO pgvo) {
		log.info("regetTotalCountmove DAO ok");
		return sql.selectOne(NS+"cnt", pgvo);
	}

	@Override
	//pageList
	public List<BoardVO> pageList(PagingVO pgvo) {
		log.info("pageList DAO ok");
		return sql.selectList(NS+"pageList", pgvo);
	}

	@Override
	//getFileName
	public String getFileName(int bno) {
		
		return sql.selectOne(NS+"fileName", bno);
	}


	
	
	
	
	
	
	
	
}
