package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/brd/*")
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로그 객체 선언
	private static final Logger log = LoggerFactory.getLogger(boardController.class);
	// requestDepatcher 객체
	private RequestDispatcher rdp;
	// service interface
	private BoardService bsv;
	// destPage : 목적지 주소 저장 변수
	private String destPage;
	// isOk
	private int isOk;

	public boardController() {
		// bsv의 객체 연결
		bsv = new BoardServiceImpl(); // service class 생성
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// encoding 설정, contentType 설정, 요청경로 파악
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// jsp에서 오는 요청 주소
		String uri = request.getRequestURI();// => ex : /brd/register
		log.info("uri >>>>>> " + uri);
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info("path >>>>>> " + path);

		switch (path) {

		}

		// 목적지 주소값 세팅
		rdp = request.getRequestDispatcher(destPage);
		// 정보 실어 보내기
		rdp.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// service로 보내기
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// service로 보내기
		service(request, response);
	}

}