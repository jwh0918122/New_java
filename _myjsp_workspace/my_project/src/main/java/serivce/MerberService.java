package serivce;

import java.util.List;

import domain.MemberVO;
import domain.PagingVO;

public interface MerberService {

	MemberVO getLoginMvo(MemberVO mvo);

	int join(MemberVO mvo);

	int logout(String id);

	int remove(String id);

	MemberVO getDetail(String id);

	int getMemberTotalCnt(PagingVO pgv);

	List<MemberVO> getList(PagingVO pgv);

}
