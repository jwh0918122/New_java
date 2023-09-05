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
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/brd/*") //brd 뒤의 모든 객체를 받아줌
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L; // 인식표 같은거
	// 로그기록 객체 생성
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	// jsp에서 받은 요청을 처리하고, 그 결과를 다른 jsp로(주소는 밑에 destPage) 보내는 역할
	private RequestDispatcher rdp;
	private String destPage; // 목적지 주소 기록 변수
	private int isOk; // DB의 구문 체크 값 저장
	// controller <-> service, service <-> dao
	private BoardService bsv;// 아직 미구현 상태(service => interface로 생성)

	public BoardController() {
		bsv = new BoardServiceImpl();// bsv를 구현할 객체 생성(service=>class로 생성)

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 모든 처리가 이루어지는 부분 */
		// 각 객체의 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 보내는 객체의 타입을 설정
		response.setContentType("text/html; charset=UTF-8");
		// jsp에서 오는 요청 주소
		String uri = request.getRequestURI();
		log.info("uri >>>>>>" + uri);// => /brd/register
		System.out.println("uri >>>>>>" + uri);

		// register
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		System.out.println("실 요청 경로 >>>> " + path);

		switch (path) {
		case "register":
			// 글쓰기 페이지로 이동해서 페이지가 나오도록 설정
			// 목적지 주소 설정
			destPage = "/register.jsp"; // 그냥"/"로 하면 webapp으로 됨
			System.out.println("이동 완료~!!");
			break;
			
		case "insert" :
			try {
				//여기까지 온거는 jsp에서 데이터를 입력 후 -> 전송버튼 클릭하여 데이터를 가지고 왔다
				//이제 데이터를 db에 등록 한 후 -> index.jsp로 이동 해야 함 
				String title = request.getParameter("title"); //getParameter는 모든 데이터를 String로 가져옴(다른게 필요하면 형변환해야함)
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				log.info(">>>>> insert check 1");
				BoardVO bvo = new BoardVO(title,writer,content);
				log.info("bvo>>>>>"+bvo);
				isOk = bsv.register(bvo);
				//request.setAttribute("isOk", isOk);
				log.info((isOk>0)?"OK":"Fail");
				//목적지 주소 설정
				destPage="/index.jsp";
				
			} catch (Exception e) {
				log.info("insert error!!");
				e.printStackTrace();
			}
			break;
		case "list" :
			try {
				log.info("list check 1");
				List<BoardVO>list = bsv.getList();
				log.info("list check 4");
				log.info(list.get(0).toString()); //list의 첫 값을 출력
				//list를 화면으로 보내기 request 객체에 실어 보내기
				request.setAttribute("list", list);
				destPage="/list.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info("list error!!");
			}
			break;
			
		case "detail":
			try {
				//jsp에서 보낸 bno 받기
//				int bno = request.getParameter("bno");//String
				int bno = Integer.parseInt(request.getParameter("bno"));//형변환(String->int)
				log.info("detail check 1");
				BoardVO bvo = bsv.getDetail(bno);//bno줄테니까 이거에 해당하는 객체 1개 가져와라
				log.info("detail check 4");
				log.info("bvo>>>>>> "+bvo);
				request.setAttribute("bvo", bvo);
				destPage="/detail.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("detail error!!");
			}
			break;
		case "modify":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("modify check 1");
				BoardVO bvo = bsv.getDetail(bno); //detail이랑 같으니까 이렇게 해줘도 됨
				request.setAttribute("bvo", bvo);
				destPage="/modify.jsp";
				
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info("modify error!!");
			}
			
			break;
		
		}
		
		//목적지 데이터 경로로 전달해주는 객체(requestDispatcher)
		rdp = request.getRequestDispatcher(destPage); // 등록 한 후 그 결과를 destPage(목적지)로 보내는 역할
		rdp.forward(request, response); // 요청에 필요한 객체를 가지고, 경로로 이동

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}