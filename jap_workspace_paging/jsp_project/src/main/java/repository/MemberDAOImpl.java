package repository;

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

}