package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import service.BoardServiceImpl;
import service.Service;

@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로그 객체 선언
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	// requestDespatcher 객체
	private RequestDispatcher rdp;
	// service interface
	private Service bsv;
	// destPage : 목적지 주소 저장 변수
	private String destPage;
	// isOk
	private int isOk;

	public BoardController() {
		// bsv의 객체 연결
		bsv = new BoardServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// encoding 설정, contentType 설정, 요청경로 파악
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); // jsp파일 가면 contentType 있음. 복붙해

		// jsp에서 오는 요청 주소
		String uri = request.getRequestURI();// /brd/register
		log.info("uri >>>>>>" + uri);
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info("path>>>>>>>> " + path);

		switch (path) {
		case "register":// 글쓰기 페이지(register.jsp)로 이동
			destPage = "/board/register.jsp";
			log.info("register로 글쓰기(register.jsp)이동 완료");
			break;

		case "insert":// 글 등록
			try {
				// register.jsp에서 보낸 parameter가져오기(제목,작성자,내용)
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				log.info("insert check 1");
				BoardVO bvo = new BoardVO(title, writer, content);
				log.info("bvo>>>>>>>>>> " + bvo);
				isOk = bsv.register(bvo);
				log.info(isOk > 0 ? "OK" : "FAIL");
				destPage = "/index.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("insert error!!");
			}
			break;

		case "list":// list출력
			try {
				List<BoardVO> list = bsv.getList();
				log.info("list check 1");
				request.setAttribute("list", list);
				destPage = "/board/list.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("list error!!");
			}
			break;
		case "detail":// 자세히 보기
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.detail(bno);
				log.info("detail check 1");
				log.info("bvo>>>>>>>> " + bvo);
				request.setAttribute("bvo", bvo);
				destPage = "/board/detail.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("detail error!!");
			}
			break;
		case "modify":// bno에 해당하는 bvo를 가지고 수정 페이지(modify.jsp)로 이동
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("modify check 1");
				BoardVO bvo = bsv.detail(bno);
				log.info("bvo>>>>>>> " + bvo);
				request.setAttribute("bvo", bvo);
				destPage = "/board/modify.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("modify error!!");
			}
			break;
		case "edit":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				BoardVO bvo = new BoardVO(bno, title, content);
				isOk = bsv.modify(bvo);
				log.info(isOk > 0 ? "OK" : "FAIL");
				destPage = "detail?bno=" + bno;

			} catch (Exception e) {
				e.printStackTrace();
				log.info("edit error!!");
			}
			break;
		case "remove":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("remove check 1");
				isOk = bsv.remove(bno);
				log.info(isOk > 0 ? "OK" : "FAIL");
				destPage = "list";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("remove error!!");
			}

			break;
		}
		//목적지 주소값 세팅
		rdp = request.getRequestDispatcher(destPage);
		//정보 실어 보내기
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
