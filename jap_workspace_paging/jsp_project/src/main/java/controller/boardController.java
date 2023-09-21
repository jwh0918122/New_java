package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import handler.PagingHandler;
import handler.fileHandler;
import net.coobird.thumbnailator.Thumbnails;
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
	// 파일 경로를 저장할 변수
	private String savePath;

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
//		case "insert": // 글 쓰기
//			try {
//				String title = request.getParameter("title");
//				String writer = request.getParameter("writer");
//				String content = request.getParameter("content");
//
//				BoardVO bvo = new BoardVO(title, writer, content);
//				isOk = bsv.add(bvo);
//				log.info("bvo>>>> " + bvo);
//				log.info(isOk > 0 ? "OK" : "FAIL");
//
//				destPage = "/index.jsp";
//			} catch (Exception e) {
//				e.printStackTrace();
//				log.info("insert error!!");
//			}
//
//			break;

		case "insert":
			try {
				// 파일을 업로드할 물리적인 경로 설정(업로드할때 설정)
				// getServletContext=>톰캣 서버의 설정 정보를 저장하고 있는 것
				savePath = getServletContext().getRealPath("/_fileUpload");// 내 webapp폴더 안에 filUpload폴더 경로 설정
				File fileDir = new File(savePath);
				log.info("파일 저장 위치 : " + savePath); // 파일 객체 log하면 에러나니까

				/* 파일아이템 객체를 디스크에 쓰기 위한 설정 정보를 설정하는 객체 */
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				// 저장할 위치 set(file 객체로 지정)
				fileItemFactory.setRepository(fileDir);
				// 저장을 위한 임시메모리 용량 설정 : byte단위
				fileItemFactory.setSizeThreshold(2 * 1024 * 1024);// 2메가바이트(1024가 1개면 키로바이트, 2개면 메가바이트)
				BoardVO bvo = new BoardVO();

				// multipart/form-data 형식으로 넘어온 request 객체를 다루기 쉽게 변환해주는 객체형식으로 저장
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

				List<FileItem> itemList = fileUpload.parseRequest(request);
				// DB로 넘기기 위한 BoardVO 객체로 변환. 이미지는 저장
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "title":
						bvo.setTitle(item.getString("utf-8")); // 인코딩 형식을 담아서 변환
						break;
					case "writer":
						bvo.setWriter(item.getString("utf-8"));
						break;
					case "content":
						bvo.setContent(item.getString("utf-8"));
						break;
					case "image_file":
						// 이미지 저장 처리가 필요
						// 이미지는 필수x. 없는 경우에도 처리가 되어야 함
						// 이미지가 있는지 체크
						if (item.getSize() > 0) {// 데이터 크기가 있다면 이미지가 있는걸로 처리
							// 가끔 경로를 포함해서 들어오는 경우가 있어서 substring해서 변수에 이름 저장해줌 //~~~~/dog.jpg
							String fileName = item.getName().substring(item.getName().lastIndexOf("/") + 1); // 맵북에서 쓰면
																												// 에러남
							// 시스템의 현재 시간_파일이름.jpg
							fileName = System.currentTimeMillis() + "_" + fileName;

							// 파일 객체 생성 : D: ~/fileUpload/현재시간_cat2.jpg
							File uploadFilePath = new File(fileDir + File.separator + fileName);//file.separator=/
							log.info("파일 경로+이름 : " + uploadFilePath);

							// 저장
							try {
								item.write(uploadFilePath); // 자바 객체를 디스크에 쓰기
								bvo.setImage_File(fileName); // 시간_cat.jpg

								// 썸네일 작업 : 크래픽 과다사용 방지
								Thumbnails.of(uploadFilePath).size(30, 30) //// 가로,세로 사이즈 설정
										.toFile(new File(fileDir + File.separator + "_th_" + fileName)); // 파일 객체 새로
																											// 생성해야함

							} catch (Exception e) {
								log.info(">>>> file writer on dist error");
								e.printStackTrace();
							}
						}

						break;
					}
				}

				// DB에 bvo 저장 요청
				isOk = bsv.add(bvo);
				log.info(">>>>>>insert > " + (isOk > 0 ? "OK" : "FAIL"));
				destPage = "pageList";
			} catch (Exception e) {
				e.printStackTrace();
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
				// boardlist.jsp에서 파라미터 받기(없다면(null)이라면 기본 생성자로 )
				if (request.getParameter("pageNo") != null) {
					int pageNo = Integer.parseInt(request.getParameter("pageNo"));
					int qty = Integer.parseInt(request.getParameter("qty"));
					log.info("pageNo=> " + pageNo + " qty=> " + qty);
					pgvo = new PagingVO(pageNo, qty);

				}
				// 검색어 받기
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
				log.info("ph ={} ", ph);
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

				// 조회수

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
				// 파일 저장 경로 설정
				savePath = getServletContext().getRealPath("/_fileUpload");

				File fileDir = new File(savePath);
				
				// 디스크에 기록할 파일 정보를 setting 하는 객체 생성
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);// 저장 경로 설정
				fileItemFactory.setSizeThreshold(2 * 1024 * 1024);// 임시 저장 용량 설정 2M

				BoardVO bvo = new BoardVO();
				
				//ServletFileUpload => Servlet프로그램을 경유하고, 파일 데이터를 취득하는 클래스
				//파일 데이터는 FileItem오프젝트가 저장되었던 List콜렉션으로 반환됨.(↓다음 줄)
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				log.info(">> update 준비 >> ");
				
				
				//파일데이터(FileItem오브젝트)를 취득하고, List오브젝트로써 리턴한다.
				List<FileItem> itemList = fileUpload.parseRequest(request);
				String old_file = null; // 수정하기 전 원래 그림 파일
				/*FileItem 오브젝트에 대한 메소드*/
				// 1. String getName()=>업로드된 파일의 파일명을 돌려준다.(파일명은 path명도 포함)
				// 2. void write(File)=>업로드된 데이터를 인수로 지정된 파일에 쓴다.
				
				
				
				for (FileItem item : itemList) {
					switch (item.getFieldName()) {
					case "bno":
						bvo.setBno(Integer.parseInt(item.getString("utf-8")));
						break;
					case "title":
						bvo.setTitle(item.getString("utf-8"));
						break;
					case "content":
						bvo.setContent(item.getString("utf-8"));
						break;
					case "image_File":
						// 수정 이전 파일
						old_file = item.getString("utf-8");
						break;
					case "new_File":
						// 새로운 파일이 있는지 확인
						if (item.getSize() > 0) {
							if (old_file != null) {
								// 기존 파일 삭제 (기존 파일이 있을 경우)
								fileHandler fileHandler = new fileHandler();
								isOk = fileHandler.deleteFile(old_file, savePath);

							}
							// new 파일의 경로와 파일명 생성
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator) + 1);

							log.info("new_fileName" + fileName);

							// 실제 저장되 파일 이름
							fileName = System.currentTimeMillis() + "_" + fileName;

							File uploadFilePath = new File(fileDir + File.separator + fileName);

							// 저장
							try {
								item.write(uploadFilePath);
								bvo.setImage_File(fileName);

								// 썸네일 작업
								Thumbnails.of(uploadFilePath).size(30, 30)
										.toFile(new File(fileDir + File.separator + "_th_" + fileName));

							} catch (Exception e) {
								e.printStackTrace();
							}

						} else { // 새로운 파일이 없다면... 기존 파일을 다시 담기
							bvo.setImage_File(old_file);
						}

						break;

					}
				}

				isOk = bsv.modify(bvo);
				log.info(isOk > 0 ? "OK" : "FAIL");
				destPage = "pageList";

			} catch (Exception e) {
				e.printStackTrace();
			}

//			try {
//				int bno = Integer.parseInt(request.getParameter("bno"));
//				String title = request.getParameter("title");
//				String content = request.getParameter("content");
//
//				BoardVO bvo = new BoardVO(bno, title, content);
//				isOk = bsv.modify(bvo);
//				log.info(isOk > 0 ? "OK" : "FAIL");
//				destPage = "detail?bno=" + bno;
//
//			} catch (Exception e) {
//				// TODO: handle exception
//			}

			break;
		case "remove":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				//삭제할 bno의 image_file Name을 불러오기
				String fileName=bsv.getFileName(bno);
				
				//savePath 생성
				savePath =getServletContext().getRealPath("/_fileUpload");
				//파일 핸들러에 삭제 요청
				fileHandler fileHandler=new fileHandler();
				isOk=fileHandler.deleteFile(fileName, savePath);
				log.info((isOk>0)? "file remove Ok":"file remove fail");
				
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
