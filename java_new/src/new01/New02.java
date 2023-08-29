package new01;

import java.util.Scanner;

public class New02 {

	public static void main(String[] args) {
		/*
		 * for문을 이용하여 1~10까지 중 짝수만 출력
		 * 
		 * 1부터 내가 입력한 수까지 5의 배수를 출력
		 */

		// for문을 이용하여 1~10까지 중 짝수만 출력
		System.out.println("--for문을 이용하여 1~10까지 중 짝수만 출력--");

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

		// 1부터 내가 입력한 수까지 5의 배수를 출력
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("--1부터 내가 입력한 수까지 5의 배수를 출력--");

		while (true) {

			System.out.println("정수를 입력하세요 > ");
			int num = scan.nextInt();

			if (num < 1) {
				System.out.println("양수를 입력하세요");
			} else {
				for (int i = 1; i <= num; i++) {
					if (i % 5 == 0) {
						System.out.print(i + " ");
					}
				}
				break;
			}
		}

	}

}
