package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import service.CommentSerivceImpl;
import service.CommentService;

@WebServlet("/cmt/*")
public class commentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(commentController.class);

	// 비동기 방식(페이지 이동 방식X) => destPage, requestdispacher 필요x
	private CommentService csv;
	private int isOk;

	public commentController() {
		csv = new CommentSerivceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		비동기 방식이기 때문에 필요 없음(html페이지를 띄우는게 아니고 html요소에 데이터만 넣을것이기 때문에)
//		response.setContentType("text/html; charset=UTF-8"); 

		String uri = request.getRequestURI();
		// 동기방식
		// 주소 체계 => /brd/detail?bnp=1;
		// get/post(파라미터를 주소창에 보여주느냐 안보여주냐 차이)

		// 비동기 방식
		// 주소 체계 => /cmt/list/10 , /cmt/post , /cmt/update => RestAPI 방식(비동기)
		// get=>리스트 보여줄때, post=>등록할때, put=>update할때, delete=> delete할때

		String pathUri = uri.substring("/cmt/".length()); // "/cmt/"뒤부터 모두 => post, list/10
		String path = pathUri;
		String pathVar = ""; // 없으면 공백처리
		if (pathUri.contains("/")) { // "/"를 포함하고 있다는 것은 패스값을 달고왔다라는 것 (ex: list/10)
			path = pathUri.substring(0, pathUri.lastIndexOf("/")); // list
			pathVar = pathUri.substring(pathUri.lastIndexOf("/") + 1); // 10
		}

		log.info(">>>> uri >>> " + uri);
		log.info(">>>> pathUri >>> " + pathUri);
		log.info(">>>> path >>> " + path);
		log.info(">>>> pathVar >>> " + pathVar);

		switch (path) {

		case "post":
			try {
				// JSON 방식으로 화면에서 보낸 데이터를 받을 준비
				// String 형태로 값을 받아 객체로 변환 JSON
				// json-simple-1.1.1라이브러리를 사용하여
				// json 형태의 String을 객체 형태로 변환
				log.info("zzzzzzzzzzzzzzzzzzzzzzzzzz");
				StringBuffer sb = new StringBuffer();
				// append
				String line = "";
				BufferedReader br = request.getReader();// cmtData를 받아오는 객체(String받아옴

				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(">>>>>> sb : " + sb.toString());

				// 객체로 변환
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());

				//jsonObj는 map형태로 되어있음
				// CommentVO 형태로 변환(CommentVO형태여야 DB에 넣을 수 있음)
				int bno = Integer.parseInt(jsonObj.get("bno").toString());
				String writer = jsonObj.get("writer").toString();
				String content = jsonObj.get("content").toString();

				// csv DB로 저장
				CommentVO cvo = new CommentVO(bno, writer, content);
				log.info(">>>cvo " + cvo);
				isOk = csv.post(cvo); //cvo파라미터로 주고, 댓글 등록하기
				log.info(isOk > 0 ? "OK" : "FAIL");

				// 화면에 출력
				PrintWriter pw = response.getWriter();
				pw.print(isOk); // 화면으로 데이터를 보내주세요

			} catch (Exception e) {
				e.printStackTrace();
				log.info(">> Comment > post > error");

			}
			break;

		}

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
