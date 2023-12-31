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
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로그 객체 선언
	private static final Logger log = LoggerFactory.getLogger(memberController.class);
	// requestDespatcher 객체
	private RequestDispatcher rdp;
	// destPage : 목적지 주소 저장 변수
	String destPage;
	// isOk
	int isOk;

	private MemberService msv; // service interface

	public memberController() {
		msv = new MemberServiceImpl(); // service class 생성
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info("path>>> " + path);
		switch (path) {

		case "login":
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				// 파라미터로 받은 아이디,비번과 같은게 DB에 있는지 확인후
				// 있으면 가져오기(parameter=mvo, return=mvo)
				MemberVO mvo = new MemberVO(id, pwd); // 이거랑 같은지 확인해주세요
				log.info("Mvo >>> " + mvo);

				MemberVO loginMvo = msv.login(mvo);// 같은거 확인 후 가져 온 거
				log.info("loginMvo가져온거 >>> " + loginMvo);

				// 세션에 loginMvo저장
				// 있으면 기존거 가져오고 없으면 생성
				if (loginMvo != null) {
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);
					ses.setMaxInactiveInterval(10 * 60); // 10 * 60초 => 10분
				} else {
					request.setAttribute("login_msg", 0);
				}

				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("login error!!");
			}

			break;
		case "logout":
			try {
				// 세션에서 로그인된 id 가져오기(lastlogin 넣을 아이디를 알아야 하니까
				HttpSession ses = request.getSession();// 있으면 기존꺼 가져오고 없으면 생성 됨
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				String id = mvo.getId();
				log.info("ses에서 id추출한거 >>> " + id);
				isOk = msv.lastlogin(id);
				log.info(isOk > 0 ? "OK" : "FAIL");

				// 세션 끊기
				ses.invalidate();
				log.info("logout >> " + ((isOk > 0) ? "OK" : "FAIL"));
				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("logout error!!");
			}
			break;
		case "list":
			try {
				List<MemberVO> list = msv.list();
				request.setAttribute("list", list);
				destPage = "/member/list.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("list error");
			}

			break;
		case "join": // 회원가입 페이지로 이동해서 정보 받기
			destPage = "/member/join.jsp";

			break;
		case "register": // 회원가입
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				int age = Integer.parseInt(request.getParameter("age"));
				String email = request.getParameter("email");

				MemberVO mvo = new MemberVO(id, pwd, age, email);
				isOk = msv.add(mvo);
				log.info(isOk > 0 ? "OK" : "FAIL");

				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("register error!!");
			}

			break;
		case "modify": // 회원정보수정 페이지로 이동해서 정보 받기
			destPage = "/member/modify.jsp";

			break;
		case "update": // 회원정보 수정
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				int age = Integer.parseInt(request.getParameter("age"));
				String email = request.getParameter("email");

				MemberVO mvo = new MemberVO(id, pwd, age, email);
				isOk = msv.modify(mvo);
				log.info(isOk > 0 ? "OK" : "FAIL");
				destPage = "logout";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("update error!!");
			}

			break;
		case "remove":
			try {
				HttpSession ses = request.getSession();
				MemberVO mvo = (MemberVO) ses.getAttribute("ses");
				String id = mvo.getId();
				isOk = msv.remove(id);
				log.info(isOk > 0 ? "OK" : "FAIL");

				// 세션 끊기
				ses.invalidate();
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("remove error!!");
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
