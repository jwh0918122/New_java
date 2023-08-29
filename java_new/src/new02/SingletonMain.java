package new02;

public class SingletonMain {

	public static void main(String[] args) {
		// 싱글톤의 객체 생성
		//Singleton s = new Singleton();//생성x(private으로 생성자를 막아놨기 때문에)		
		//클래스명.메서드명(); 
		Singleton s = Singleton.getInstance(); //처음 만드는 것이기 때문에 객체 생성
		Singleton s2 = Singleton.getInstance();//위에서 이미 만들었기 때문에 같은 객체 가져옴
		
		if(s==s2) {//주소가 같은지 보는 것
			System.out.println("s와 s2는 같은 객체(s==s2)");
		}else {
			System.out.println("s와 s2는 다른 객체(s!=s2)");
		}
		

	}

}
