package domain;

public class MemberVO {
	private String id;
	private String pwd;
	private int age;
	private String email;
	private String regdate;
	private String lastlogin;
	
	public MemberVO() {}
	
	//로그인용 생성자
	public MemberVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	//회원 등록, 수정용 생성자(join, modify)
	public MemberVO(String id, String pwd, int age, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.age = age;
		this.email = email;
	}
	
	//회원리스트 출력용 생성자
	public MemberVO(String id, String pwd, int age, String email, String regdate, String lastlogin) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.age = age;
		this.email = email;
		this.regdate = regdate;
		this.lastlogin = lastlogin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getlastlogin() {
		return lastlogin;
	}

	public void setlastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	@Override
	public String toString() {
		return "id=" + id + ", pwd=" + pwd + ", age=" + age + ", email=" + email + ", regdate=" + regdate
				+ ", lastlogin=" + lastlogin ;
	}
	
	
	
	
	

}
