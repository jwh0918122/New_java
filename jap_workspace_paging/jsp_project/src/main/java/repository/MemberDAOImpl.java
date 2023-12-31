package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.memberController;
import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log = LoggerFactory.getLogger(memberController.class);
	
	//DB와 연결
	private SqlSession sql;
	private static String NS="MemberMapper."; //.id
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql=DatabaseBuilder.getFactory().openSession();
	}

	@Override
	//login
	public MemberVO login(MemberVO mvo) {
		log.info("login DAO ok");
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	//lastlogin
	public int lastlogin(String id) {
		log.info("lastlogin DAO ok");
		int isOk=sql.update(NS+"lastlogin", id);
		if(isOk>0) {
			sql.commit();
		}
		
		return isOk;
	}

	@Override
	//list
	public List<MemberVO> selectAll() {
		log.info("list DAO ok");
		return sql.selectList(NS+"selectAll");
	}

	@Override
	//add
	public int insert(MemberVO mvo) {
		log.info("add DAO ok");
		int isOk=sql.insert(NS+"add", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//modify
	public int update(MemberVO mvo) {
		log.info("modify DAO ok");
		int isOk=sql.update(NS+"modify", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	//remove
	public int delete(String id) {
		log.info("remove DAO ok");
		int isOk=sql.delete(NS+"remove", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

}
