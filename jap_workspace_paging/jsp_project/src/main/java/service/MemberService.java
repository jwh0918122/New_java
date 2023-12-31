package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO mvo);

	int lastlogin(String id);

	List<MemberVO> list();

	int add(MemberVO mvo);

	int modify(MemberVO mvo);

	int remove(String id);


}
