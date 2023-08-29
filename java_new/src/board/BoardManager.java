package board;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class BoardManager implements BoardInter {
	ArrayList<Board> list = new ArrayList<>();
	Calendar now = Calendar.getInstance();

// 게시글 등록
	public void addBoard(Scanner scan) {

		int num = list.size() + 1;// 번호
		// 날짜 구하기
		int year = now.get(Calendar.YEAR);//년
		int month = now.get(Calendar.MONTH) + 1;//월
		int day = now.get(Calendar.DAY_OF_MONTH);//일
		int week = now.get(Calendar.DAY_OF_WEEK);//요일(숫자)
		String weekStr = "";//요일(문자)

		switch (week) {
		case 1:
			weekStr = "(일)";
			break;
		case 2:
			weekStr = "(월)";
			break;
		case 3:
			weekStr = "(화)";
			break;
		case 4:
			weekStr = "(수)";
			break;
		case 5:
			weekStr = "(목)";
			break;
		case 6:
			weekStr = "(금)";
			break;
		case 7:
			weekStr = "(토)";
			break;

		}
		// date에 년도,월,일,요일 넣기
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(year));
		sb.append("-");
		sb.append(String.valueOf(month));
		sb.append("-");
		sb.append(String.valueOf(day));
		sb.append(String.valueOf(weekStr));
		String date = sb.toString();

		System.out.println("이름을 입력하세요 >");
		String name = scan.next();
		scan.nextLine();//nextLine줄넘김
		System.out.println("제목을 입력하세요 >");
		String title = scan.nextLine();
		System.out.println("내용을 입력하세요 >");
		String content = scan.nextLine();

		list.add(new Board(num, title, content, name, date));

	}

//게시글 조회
	public void searchBoard(Scanner scan) {
		System.out.println("조회할 게시글의 번호를 입력하세요 >");
		int num = scan.nextInt();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum() == num) {
				System.out.println(list.get(i).getTitle() + "\n" + list.get(i).getContent() + "\n"
						+ list.get(i).getName() + " | " + list.get(i).getDate());
				return;
			}
		}
		System.out.println("해당 번호의 게시글이 없습니다.");

	}

//게시글 수정
	public void modifyBoard(Scanner scan) {
		System.out.println("수정할 게시글의 번호를 입력하세요 >");
		int num = scan.nextInt();

		while (true) {
			System.out.println("제목을 수정할 경우 1, 내용을 수정할 경우 2, 모두 수정할 경우 3을 입력하세요 >");
			int zz = scan.nextInt();
			String title = "";
			String content = "";
	
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNum() == num) {
					switch (zz) {
					case 1:
						System.out.println("수정할 제목을 입력하세요 >");
						scan.nextLine(); //줄넘김
						title = scan.nextLine();
						list.get(i).setTitle(title);
						return;
					case 2:
						System.out.println("수정할 내용을 입력하세요 >");
						scan.nextLine();
						content = scan.nextLine();
						list.get(i).setContent(content);
						return;
					case 3:
						System.out.println("수정할 제목과 내용을 입력하세요 >");
						scan.nextLine();
						title = scan.nextLine();
						content = scan.nextLine();
						list.get(i).setTitle(title);
						list.get(i).setContent(content);
						return;
					default:
						System.out.println("잘못 입력하셨습니다.");
					}

				}
			}

		}

	}

//게시글 삭제
	public void removeBoard(Scanner scan) {
		System.out.println("삭제할 게시글의 번호를 입력하세요 >");
		int num = scan.nextInt();
		// 삭제
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum() == num) {
				list.remove(i);	
			}
		}
		// num 다시 주기
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setNum(i + 1);
		}

	}

//게시글 목록
	public void printBoard() {

		for (Board tmp : list) {
			System.out.println(tmp);
		}

	}

}
