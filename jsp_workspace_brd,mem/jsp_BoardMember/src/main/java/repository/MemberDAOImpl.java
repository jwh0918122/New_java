package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;
import service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log =LoggerFactory.getLogger(MemberDAOImpl.class);

	//DB와 연결
	private SqlSession sql;
	private final String NS="MemberMapper."; //namespace.id
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
		
	}

	@Override
	//insert
	public int insert(MemberVO mvo) {
		log.info("join check 3");
		int isOk = sql.insert(NS+"add", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//login
	public MemberVO login(MemberVO mvo) {
		log.info("login check 3");
		
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	//lastlogin
	public int lastLogin(String id) {
		log.info("lastlogin check 3");
		int isOk = sql.update(NS+"last", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//list
	public List<MemberVO> list() {
		log.info("list check 3");
		
		return sql.selectList(NS+"list");
	}
	
	
	
	
	
	
	
	
	
	
}