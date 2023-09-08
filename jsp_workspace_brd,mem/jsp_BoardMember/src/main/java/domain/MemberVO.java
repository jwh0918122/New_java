package domain;

public class MemberVO {
	private String id;
	private String pwd;
	private String email;
	private int age;
	private String regdate;
	private String lastlogin;
	
	public MemberVO() {}
	
	//로그인용 생성자
	public MemberVO(String id,String pwd) {
		this.id=id;
		this.pwd=pwd;
		
	}
	
	//회원 등록, 수정용 생성자(join,modify)
	public MemberVO(String id, String pwd, String email, int age) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.age = age;
	}

	//회원리스트 출력용 생성자
	public MemberVO(String id, String pwd, String email, int age, String regdate, String lastlogin) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.age = age;
		this.regdate = regdate;
		this.lastlogin = lastlogin;
		
	}

	//getter, setter
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	//toString
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", age=" + age + ", regdate=" + regdate
				+ ", lastlogin=" + lastlogin + "]";
	}

}


