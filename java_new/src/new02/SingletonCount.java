package new02;

import java.util.Calendar;

public class SingletonCount {

	public static void main(String[] args) {
		// 객체를 2개 생성
		// 각각 객체에서 countMethod실행
		// 출력

		Counter c = Counter.getInstance();
		Counter c2 = Counter.getInstance();

		System.out.println(c.countMethod());// 1
		System.out.println(c2.countMethod());// 2
		System.out.println(c.countMethod());// 3
		System.out.println(c2.countMethod());// 4

		// Calendar도 getInstance메서드로 가져옴
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		System.out.println(year);

	}

}

class Counter {
	// 싱글톤으로 객체 만들기
	private static Counter instance;//
	private int count;

	// private 생성자(private으로 생성자 막기)
	private Counter() {
	}

	// getInstance(); (메소드로 생성자 만들기)
	public static Counter getInstance() {
		// instance객체가 없다면 생성하고, 이미 있다면 있는것을 return;
		if (instance == null) {
			instance = new Counter();
		}
		return instance;
	}

	// count() //멤버변수의 count가 1씩 증가
	public int countMethod() {
		count++;
		return count;
	}

}
