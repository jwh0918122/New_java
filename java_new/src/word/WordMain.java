package word;

import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		WordManager wm = new WordManager();
		
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		do {
			System.out.println("1.단어등록|2.단어검색|3.단어수정|4.단어출력|5.파일출력|6.종료");
			System.out.println("메뉴를 입력하세요 > ");
			menu = scan.nextInt();
			try {
				switch (menu) {
				case 1://단어등록
					wm.addList();
					break;
				case 2://단어검색
					wm.searchList();
					break;
				case 3://단어수정
					wm.updateList();
					break;
				case 4://단어출력
					wm.printList();
					break;
				case 5://파일 출력
					wm.filePrint();
					break;
				case 6://종료
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
				}
			}catch(Exception e) {
				
			}
			

		} while (menu != 6);

	}

}
