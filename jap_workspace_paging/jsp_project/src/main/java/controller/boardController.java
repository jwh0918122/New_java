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
import domain.PagingVO;
import handler.PagingHandler;
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
		case "register": // 글 쓰기 페이지로 이동
			destPage = "/board/register.jsp";

			break;
		case "insert": // 글 쓰기
			try {
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");

				BoardVO bvo = new BoardVO(title, writer, content);
				isOk = bsv.add(bvo);
				log.info("bvo>>>> " + bvo);
				log.info(isOk > 0 ? "OK" : "FAIL");

				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("insert error!!");
			}

			break;
			
		case "list": // 리스트
			try {
				List<BoardVO> list = bsv.getList();
				request.setAttribute("list", list);
				destPage = "/board/boardlist.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("list error!");
			}

			break;
			
		case "pageList": // 리스트
			try {
				// PagingVO
				PagingVO pgvo = new PagingVO();// 기본생성자=>PagingVO(1,10)이 기본
				//boardlist.jsp에서 파라미터 받기(없다면(null)이라면 기본 생성자로 )
				if (request.getParameter("pageNo") != null) {
					int pageNo = Integer.parseInt(request.getParameter("pageNo"));
					int qty = Integer.parseInt(request.getParameter("qty"));
					log.info("pageNo=> " + pageNo + " qty=> " + qty);
					pgvo = new PagingVO(pageNo, qty);
		
				}
				//검색어 받기
				String type = request.getParameter("type");
				String keyword = request.getParameter("keyword");
				pgvo.setType(type);
				pgvo.setKeyword(keyword);
//				pgvo.setType(request.getParameter("type"));=>이렇게 한번에 해도 됨
				
				// totalCount
				// DB에게 전체 게시글 카운트 요청
				int totalCount = bsv.getTotalCount(pgvo);
				log.info("전체 게시글 수 : " + totalCount);
				// bsv한테 매개변수로 pgvo주고, limit 적용한 리스트 10개 가져오기
				List<BoardVO> pageList = bsv.getPageList(pgvo);
				// list를 request에 담기
				request.setAttribute("pageList", pageList);
				// 페이지 정보 request에 담기(boardlist.jsp로 보내야 하니까)
				PagingHandler ph = new PagingHandler(pgvo, totalCount);
				request.setAttribute("ph", ph);				
				log.info("ph ={} ",ph);
				log.info("paging 성공~~!!");
				destPage = "/board/boardlist.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("list error!");
			}

			break;
		case "detail": // 자세히
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.detail(bno);
				
				//조회수 
				
			
				request.setAttribute("bvo", bvo);
				log.info("bvo>>> " + bvo);
				destPage = "/board/detail.jsp";

			} catch (Exception e) {
				e.printStackTrace();
				log.info("detail error!!");
			}

			break;
		case "modify": // bno에 해당하는 bvo를 가지고 수정 페이지로 이동
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.detail(bno); // 하는 기능이 detail랑 같으니까 써도 됨.
				request.setAttribute("bvo", bvo);
				destPage = "/board/modify.jsp";

			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "edit": // 글 수정
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");

				BoardVO bvo = new BoardVO(bno, title, content);
				isOk = bsv.modify(bvo);
				log.info(isOk > 0 ? "OK" : "FAIL");
				destPage = "detail?bno=" + bno;

			} catch (Exception e) {
				// TODO: handle exception
			}

			break;
		case "remove":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				isOk = bsv.remove(bno);
				log.info(isOk > 0 ? "OK" : "FAIL");
				destPage = "pageList";

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
		// service로 보내기
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// service로 보내기
		service(request, response);
	}

}
