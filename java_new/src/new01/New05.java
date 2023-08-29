package new01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class New05 {

	public static void main(String[] args) {
		/*
		 * New04의 내용을 메서드로 분리
		 */
		// map을 받아서 출력

		HashMap<String, String> map = new HashMap<>();
		map = creatMap();

		System.out.println("==단어장==");
		for (String tmp : map.keySet()) {
			System.out.println(tmp + " : " + map.get(tmp));
		}
	}

	/* 기능 : 단어 : 의미를 입력 받아서 map을 구성 
	 * 리턴 : map
	 */
	public static HashMap<String, String> creatMap() {

		Scanner scan = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();

		System.out.println("입력할 단어의 개수를 입력하세요 >");
		int cnt = scan.nextInt();

		System.out.println("단어와 의미를 " + cnt + "개 입력하세요 >");
		for (int i = 1; i <= cnt; i++) {
			String word = scan.next();
			String mean = scan.next();

			map.put(word, mean);
		}
		return map;
	}
}
