package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	MemberVO login(MemberVO mvo);

	int lastlogin(String id);

	List<MemberVO> selectAll();

	int insert(MemberVO mvo);

	int update(MemberVO mvo);

	int delete(String id);

}
