package new01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		/* 단어장 단어 : 의미 map으로 생성 입력받을 단어의 개수를 받아서 그 만큼 map에 추가 콘솔에 찍기
		 */

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

		System.out.println("=단어장=");
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}

	}

}
