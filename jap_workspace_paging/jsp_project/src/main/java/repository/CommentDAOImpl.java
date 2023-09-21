package repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;
import service.CommentSerivceImpl;

public class CommentDAOImpl implements CommentDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);

	// DB연결
	private SqlSession sql;
	private final String NS = "CommentMapper.";
	private int isOk;

	public CommentDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		isOk = sql.insert(NS + "add", cvo);
		if (isOk > 0) {
			sql.commit();
		}
		return isOk;

	}

	@Override
	public List<CommentVO> getList(int bno) {

		return sql.selectList(NS+"list", bno);
	}

	@Override
	public int update(CommentVO cvo) {
		int isOk=sql.update(NS+"modify", cvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(int cno) {
		int isOk=sql.delete(NS+"remove",cno);
		if(isOk>0) {
			sql.commit();
		}
		
		return isOk;
	}

	@Override
	public int cmtDeleteAll(int bno) {
		isOk=sql.delete(NS+"cmtDeleteAll", bno);
		if(isOk>0) {
			sql.commit();
		}
	
		return isOk;
	}

	@Override
	public int commentCount(int bno) {
		
		return sql.selectOne(NS+"commentCount", bno);
	}
}