package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import domain.PagingVO;
import handler.PagingHandler;
import serivce.MemberServiceImpl;
import serivce.MerberService;

@WebServlet("/mem/*")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로그 객체 선언
	private static final Logger log = LoggerFactory.getLogger(memberController.class);
	// requdstDespatcher 객체
	private RequestDispatcher rdp;
	// destPage : 목적지 주소 저장 변수
	String destPage;
	// isOk
	int isOk;
	// service interface
	private MerberService msv;

	public memberController() {
		// service class
		msv = new MemberServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인코딩, 컨텐츠타입 설정
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info("path>>>>>> " + path);

		switch (path) {

		case "login": // 로그인

			try {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				MemberVO mvo = new MemberVO(id, pw);

				// 위에 받은거랑 같은거 찾고 있으면 같은 mvo리턴
				MemberVO loginMvo = msv.getLoginMvo(mvo);

				if (loginMvo != null) {
					HttpSession ses = request.getSession();// 있다면 기존꺼, 없으면 생성
					ses.setAttribute("ses", loginMvo);
					ses.setMaxInactiveInterval(10 * 60); // 10*60초 => 10분 로그인 유지
				}

				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "register": // 회원가입 페이지 이동
			destPage = "/member/register.jsp";

			break;
		case "join": // 회원가입
			try {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				int age = Integer.parseInt(request.getParameter("age"));
				String gender = request.getParameter("gender");
				MemberVO mvo = new MemberVO(id, pw, name, age, phone, gender);

				isOk = msv.join(mvo);
				log.info(isOk > 0 ? "OK" : "FAIL");
				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "logout": // 로그아웃

			try {
				// lastLogin 기록
				HttpSession ses = request.getSession();
				// session에서 가져오는거는 형변환해줘야함(다형성)
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				String id = mvo.getId();
				log.info("id>>>>>>> " + id);
				isOk = msv.logout(id);
				log.info(isOk > 0 ? "OK" : "FAIL");

				ses.invalidate();// 세션 끊기

				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "memList": // 회원리스트
			try {
				PagingVO pgv= new PagingVO();
				//페이지네이션 번호 받은게 있다면 그걸로 pgv에 set. 없다면 기본 생성자(paginaionNo=1,qty=10)
				if(request.getParameter("paginaionNo")!=null) {
					pgv.setPaginaionNo(Integer.parseInt(request.getParameter("paginaionNo")));
					pgv.setQty(Integer.parseInt(request.getParameter("qty")));
				}
				
				//검색어 받아서 pgv에 set
				pgv.setType(request.getParameter("type"));
				pgv.setKeyword(request.getParameter("keyword"));
							
				//msv한테 전체 멤버 갯수 요청
				int totalCnt = msv.getMemberTotalCnt(pgv); //pgv매개변수 주는거는 검색 때문에
				log.info("memberTotalCnt>>>> "+totalCnt);
				
				//msv한테 pgv만큼 DB에 limit한 list 요청
				List<MemberVO> list = msv.getList(pgv);				
				request.setAttribute("list", list); //list 담기
				for(MemberVO tmp : list) {
					System.out.println(tmp);
				}
				
				PagingHandler ph = new PagingHandler(pgv, totalCnt);
				request.setAttribute("ph", ph); //페이지 정보 담기
				log.info("startPagination>>>>>> "+ph.getStartPagination());
				log.info("ph.getPgv>>>>>> "+ph.getPgv());
				log.info("type>>>>>> "+pgv.getType());
				log.info("keyword>>>>>>> "+pgv.getKeyword());
				
				destPage = "/member/memberList.jsp";

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "remove": // 회원 탈퇴
			try {
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				String id = mvo.getId();
				isOk = msv.remove(id);
				log.info(isOk > 0 ? "OK" : "FAIL");

				ses.invalidate(); // 세션 끊기
				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "memDetail":
			try {
				String id=request.getParameter("id");
				MemberVO mvo =msv.getDetail(id);
				log.info("mvo>>>>>>> "+mvo);
				request.setAttribute("mvo", mvo);
				destPage="/member/memberDetail.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			break;

		}

		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// servic로 보내기
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// servic로 보내기
		service(request, response);
	}

}
