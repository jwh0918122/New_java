package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.Session;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;
import serivce.BoardServiceImpl;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	int isOk;
	// DB연결
	private SqlSession sql;
	private String NS = "boardMapper.";

	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();

	}

	// write
	public int write(BoardVO bvo) {
		log.info("write DAO ok");
		isOk = sql.insert(NS + "write", bvo);
		if (isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	// list
	public List<BoardVO> getList(PagingVO pgv) {
		log.info("list DAO ok");
		return sql.selectList(NS + "boardList", pgv);
	}

	// boardTotalCnt
	public int boardTotalCnt(PagingVO pgv) {
		log.info("boardTotalCnt DAO ok");
		return sql.selectOne(NS + "boardTotalCnt", pgv);
	}

	//boardDetail
	public BoardVO brdDetail(int bno) {
		log.info("boardDetail DAO ok");
		sql.update(NS+"viewCntUP",bno);
		sql.commit();
		
		return sql.selectOne(NS+"brdDetail", bno);
	}

	//getBvoForModify
	public BoardVO getBvoForModify(int bno) {
		log.info("getBvoForModify DAO ok");
		return sql.selectOne(NS+"getBvoForModify", bno);
	}

	//modify
	public int modify(BoardVO bvo) {
		log.info("modify DAO ok");
		isOk=sql.update(NS+"modify",bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	//remove
	public int delete(int bno) {
		log.info("remove DAO ok");
		isOk=sql.delete(NS+"remove",bno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

}
