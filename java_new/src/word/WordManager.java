package word;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordManager {
	Scanner scan = new Scanner(System.in);
	ArrayList<Word> list = new ArrayList<>();

	public WordManager() {
	}

//단어 등록
	public void addList() {

		System.out.println("등록하실 단어와 의미를 입력하세요 >");
		String word = scan.next();
		String mean = scan.next();

		list.add(new Word(word, mean));
	}

//단어 검색
	public void searchList() {
		System.out.println("검색하실 단어를 입력하세요 >");
		String word = scan.next();

		for (Word tmp : list) {
			if (tmp.getWord().equals(word)) {
				System.out.println(tmp.getWord() + " : " + tmp.getMean());
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
	}

//단어 수정
	public void updateList() {
		System.out.println("수정하실 단어를 입력하세요 >");
		String word = scan.next();
		System.out.println("수정하실 단어의 의미를 입력하세요 >");
		String mean = scan.next();

		for (Word tmp : list) {
			if (tmp.getWord().equals(word)) {
				tmp.setMean(mean);
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");

	}

//단어 출력
	public void printList() {
		System.out.println("==단어장==");
		for (Word tmp : list) {
			System.out.println(tmp.getWord() + " : " + tmp.getMean());
			// System.out.println(tmp); // toString있으면 이렇게 해도 됨
		}
	}

//파일 출력

	public void filePrint() throws IOException {
		FileWriter fw = new FileWriter("word.txt");
//		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sb = new StringBuffer();

		String data = "";
		int cnt = 0;

		while (cnt < list.size()) { // 리스가 모두 소진될때까지
			sb.append(list.get(cnt).toString());
			sb.append("\n");// 줄바꿈(하나 넣고 줄바꿈 해줘야 함)
			data = sb.toString();
			cnt++;
		}
		System.out.println(data);
		System.out.println(cnt);
		fw.write(data);
		fw.close();

	}

}
