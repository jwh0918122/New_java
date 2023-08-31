package boardJDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardController {

	private Scanner scan;
	private Service svc;
	private boolean flag;

	public BoardController() {
		scan = new Scanner(System.in);
		svc = new BoardServiceImpl();
		flag = true;
		printMenu();

	}

	public void printMenu() {
		while (flag) {
			System.out.println("--게시판--");
			System.out.println("1.게시글등록|2.게시글목록|3.게시글검색(게시글상세)");
			System.out.println("4.게시글수정|5.게시글삭제|6.종료");
			System.out.println("메뉴 선택 >");
			int menu = scan.nextInt();

			switch (menu) {
			case 1:// 게시글등록
				write();
				break;
			case 2:// 게시글목록
				list();
				break;
			case 3:// 게시글검색(게시글상세)
				detail();
				break;
			case 4:// 게시글수정
				modify();
				break;
			case 5:// 게시글삭제
				remove();
				break;
			default:// 종료
				flag = false;
				break;
			}
		}
	}

	// 게시글 삭제
	private void remove() {
		System.out.println("삭제하실 게시글의 번호를 입력하세요>");
		int bno=scan.nextInt();
		int isOk = svc.remove(bno);
		System.out.println("글 삭제 " + (isOk > 0 ? "성공" : "실패"));

	}
	
	// 게시글 수정
	private void modify() {
		System.out.println("수정하실 게시글의 번호를 입력하세요>");
		int bno = scan.nextInt();
		System.out.println("수정하실 작성자, 제목, 내용을 입력하세요>");
		String writer = scan.next();
		scan.nextLine();
		String title = scan.nextLine();
		String content = scan.nextLine();
		BoardVO b = new BoardVO(bno, title, writer, content);
		int isOk=svc.modify(b);
	}

	//게시글 검색
	private void detail() {
		System.out.println("검색하실 게시글의 번호를 입력하세요>");
		int bno = scan.nextInt();
		BoardVO b = svc.detail(bno);
		b.printDetail();
	
	}

	// 목록출력
	private void list() {
		ArrayList<BoardVO> list = svc.list();

		for (BoardVO b : list) {
			System.out.println(b);
		}

	}

	// 게시글등록
	private void write() {
		System.out.println("이름을 입력하세요>");
		String writer = scan.next();
		System.out.println("등록하실 제목을 입력하세요>");
		scan.nextLine();// 줄넘김
		String title = scan.nextLine();
		System.out.println("등록하실 내용을 입력하세요>");
		String content = scan.nextLine();

		BoardVO b = new BoardVO(title, writer, content);
		int isOk = svc.write(b);
		System.out.println("글 등록 " + (isOk > 0 ? "성공" : "실패"));

	}

}
