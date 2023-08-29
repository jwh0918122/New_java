package new01;

public class New01 {

	public static void main(String[] args) {
		/* 홍길동 주민등록번호는 881122-1234567이다
		 * 출력 형태 : 생년월일 : 881122, 성별 : 남
		 */
		
		String pin = "881122-1234567";
		String birth = pin.substring(0,pin.indexOf("-"));
		char gender = pin.charAt(7);
		
		System.out.println("생년월일 : "+birth );
			
		if(gender=='1'||gender=='3') {
			System.out.println("성별 : 남");
		}else if(gender=='2'||gender=='4') {			
			System.out.println("성별 : 여");
		}else {
			System.out.println("주민번호를 잘 못 입력하셨습니다.");
		}
		
	}

}
