package new01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class New03 {

	public static void main(String[] args) {
		/*
		 * 컬렉션 프레임워크 - List : 순서를 보장, 중복 저장 가능 - Set : 순서 보장X, 중복X - Map : 2가지 데이터를 쌍으로
		 * 저장, 순서 보장X -key(중복 불가능), value(중복 가능)
		 */
		Scanner scan = new Scanner(System.in);

		// 리스트 생성하고, 1~10까지 등록한 후 출력
//		ArrayList<Integer> list = new ArrayList<>();
//		for(int i=1;i<=10;i++) {
//			list.add(i);
//		}
//	System.out.println(list); //[1,2,3,4,5,6,7,8,9,10]
//	for(Integer tmp : list) { 
//		System.out.print(tmp+" "); //1 2 3 4 5 6 7 8 9 10
//	}

		// 정수를 입력받아서 입력받은 만큼 오늘의 할일을 입력하고 출력
//	System.out.println();
//	
//	ArrayList<String> listStr = new ArrayList<>();
//	
//	System.out.println("정수를 입력하세요 >");
//	int num = scan.nextInt();
//	
//	System.out.println("오늘의 할일을 "+num+"개 입력하세요 >");
//	for(int i=1;i<=num;i++) {	
//	String str = scan.next();
//	listStr.add(str);
//	}	
//	
//	System.out.println("==오늘 할일("+num+"가지)==");
//	for(String tmp : listStr) {
//		System.out.println(tmp);
//	}

		/*
		 * map을 이용하여 이름 : 점수 형태로 3명만 입력 출력
		 */

		HashMap<String, Integer> map = new HashMap<>();

		System.out.println("이름과 점수를 입력하세요(3명)");

		for (int i = 1; i <= 3; i++) {
			String name = scan.next();
			int score = scan.nextInt();
			map.put(name, score);
		}

		System.out.println("==이름,점수 출력==");
		//Iterator 사용하여 출력
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String tmp = it.next();
			System.out.println(tmp + " : " + map.get(tmp));
		}
		//향상된 for문 사용하여 출력
		for(String tmp : map.keySet()) {
			System.out.println(tmp+" : "+map.get(tmp));
		}

	}

}
