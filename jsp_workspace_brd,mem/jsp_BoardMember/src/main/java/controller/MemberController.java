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
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로그 객체 선언
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	// requestDespatcher 객체
	private RequestDispatcher rdp;
	// destPage : 목적지 주소 저장 변수
	private String destPage;
	// isOk
	private int isOk;

	private MemberService msv; // service -> interface 생성

	public MemberController() {

		msv = new MemberServiceImpl(); // service -> class 생성
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// encoding 설정, contentType 설정, 요청경로 파악
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");// jsp파일 가면 contentType 있음. 복붙해

		// jsp에서 오는 요청 주소
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info("path>>> " + path);

		switch (path) {
		case "join": // 회원가입 페이지 열기
			destPage = "/member/join.jsp";
			log.info("회원가입 페이지 열기");
			break;
		case "register": // 회원가입 DB저장
			try {
				// jsp에서 보낸 파라미터 받기
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				log.info("join check 1 " + mvo);
				isOk = msv.register(mvo);
				log.info("join check 4" + ((isOk > 0) ? "OK" : "FAIL"));
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("register error!!");
			}
			break;
		case "login": // 로그인이 일어나는 케이스
			try {
				// 파라미터가 DB의 값에 있는지 확인
				// 해당 id, pw가 일치하는 데이터를 가져오기
				// 가져온 데이터를 session에 저장(sessoin : 모든 jsp페이지에 공유되는 데이터)
				// id가 없거나 pw가 일치하지 않는다면 메세지를 보내서 alert창 띄우기
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				MemberVO mvo = new MemberVO(id, pwd);

				MemberVO loginmvo = msv.login(mvo);// 보내는 것도 mvo,받는것도 mvo
				log.info("login check 1 " + loginmvo);
				// 가져온 데이터를 세션에 저장
				// 세션 가져오기
				if (loginmvo != null) {
					// 연결된 세션이 있다면 기존의 세션을 가져오고, 없으면 새로 생성함(sington이랑 비슷)
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginmvo);
					// 세션 유지 시간(로그인 유지 시간) : 초단위로 설정
					ses.setMaxInactiveInterval(10 * 60); // 10분
				} else {
					// 로그인 객체가 없다면
					request.setAttribute("msg_login", 0);
				}
				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("login error!!");
			}
			break;
		case "logout":
			try {
				// 연결된 세션이 있다면 해당 세션을 가져오기
				HttpSession ses = request.getSession(); // 로그인한 세션
				// lastlogin 시간 기록(id가 필요.누구의 lastlogin을 기록할지 알아야 하니까)
				// 세션에서 id 가져오기(세션에서 바로 id가져올수는 없고 객체에서 가져와야함)
				// MemberVO로 형변환(세션에 있던 객체들은 자료형이 명황하게 정해져있지 않아서 꺼내 쓸 때마다 형변환해줘야한(다형성))
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				String id = mvo.getId();
				log.info("ses에서 id추출 >>> " + id);
				isOk = msv.lastLogin(id);

				ses.invalidate();// 세션 끊기
				log.info("logout >> " + ((isOk > 0) ? "OK" : "FAIL"));
				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "list":
			try {
				List<MemberVO> list = msv.getList();
				request.setAttribute("list", list);
				destPage="/member/list.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		// 목적지 주소값 세팅
		rdp = request.getRequestDispatcher(destPage);
		// 정보 실어 보내기
		rdp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}
}
