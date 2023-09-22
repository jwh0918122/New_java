package repository;

import java.util.List;

import domain.MemberVO;
import domain.PagingVO;

public interface MemberDAO {

	MemberVO getLoginMvo(MemberVO mvo);

	int join(MemberVO mvo);

	int logout(String id);

	int remove(String id);

	MemberVO detail(String id);

	int getMemberTotalCnt(PagingVO pgv);

	List<MemberVO> getList(PagingVO pgv);



}
