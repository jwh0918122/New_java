package controller;

import java.io.IOException;

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

		switch (path) {

		case "login":
			try {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				// 파라미터로 받은 아이디,비번과 같은게 DB에 있는지 확인후
				// 있으면 가져오기(parameter=mvo, return=mvo)
				MemberVO mvo = new MemberVO(id, pw); // 이거랑 같은지 확인해주세요
				MemberVO loginMvo = msv.login(mvo);// 같은거 확인 후 가져 온 거
				log.info("loginMvo가져온거 >>> "+loginMvo);
				
				//세션에 loginMvo저장
				//있으면 기존거 가져오고 없으면 생성
				if(loginMvo!=null) {
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo); 
					ses.setMaxInactiveInterval(10*60); //10 * 60초 => 10분					
				}else {
					request.setAttribute("login_msg", 0);
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info("login error!!");
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