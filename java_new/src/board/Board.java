package board;

import java.util.Objects;

//import java.text.SimpleDateFormat;
//import java.util.Date;

public class Board {
	private int num;// 번호
	private String title;// 제목
	private String content;// 내용
	private String name;// 작성자
	private String date;// 날짜

	public Board(int num, String title, String content, String name, String date) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.name = name;
		this.date = date;
//		Date nowDate = new Date();

		// 날짜를 문자열로 변환
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
//		this.date = sf.format(nowDate);//String형식으로 date에 저장됨
	}

	// getter setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String user) {
		this.name = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	// toString
	@Override
	public String toString() {
		return num + " 제목 : " + title + " | 내용 : " + content + " | 작성자 : " + name + " | 날짜 : " + date;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(content, date, name, num, title);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Board other = (Board) obj;
//		return Objects.equals(content, other.content) && Objects.equals(date, other.date)
//				&& Objects.equals(name, other.name) && num == other.num && Objects.equals(title, other.title);
//	}

}
