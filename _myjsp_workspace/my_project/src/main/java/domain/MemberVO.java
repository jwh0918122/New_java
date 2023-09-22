package domain;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private int age;
	private String phone;
	private String regDate;
	private String lastLogin;
	private String gender;

	// 로그인용
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// 회원가입용
	public MemberVO(String id, String pw, String name, int age, String phone,String gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.gender=gender;
	}

	// 회원 리스트
	public MemberVO(String id, String name, int age,String gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender=gender;
	}

	// 회원 상세정보
	public MemberVO(String id, String pw, String name, int age,String gender, String phone, String regDate, String lastLogin) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.gender=gender;
		this.phone = phone;
		this.regDate = regDate;
		this.lastLogin = lastLogin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", phone=" + phone
				+ ", regDate=" + regDate + ", lastLogin=" + lastLogin + ", gender=" + gender + "]";
	}



}
