package board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		
		BoardManager bm = new BoardManager();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		do {
			System.out.println("1.게시글등록|2.게시글조회|3.게시글수정|4.게시글삭제|5.게시글 목록|6.종료");
			System.out.println("메뉴를 입력하세요 > ");
			menu = scan.nextInt();
			String tmp = scan.nextLine();
			switch (menu) {
			case 1:// 게시글등록
				bm.addBoard(scan);
				break;
			case 2:// 게시글조회
				bm.searchBoard(scan);
				break;
			case 3:// 게시글수정
				bm.modifyBoard(scan);
				break;
			case 4:// 게시글삭제
				bm.removeBoard(scan);
				break;
			case 5:// 게시글 목록
				bm.printBoard();
				break;
			case 6:// 종료
				System.out.println("종료");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}

		} while (menu != 6);

	}

}
