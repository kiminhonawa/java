package edu.java.modifier03;

public class User {
	//field
	private int userNo;
	private String userId;
	private String password;
	
	//constructor
	public User(int userNo, String userId, String password) {
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
	}
	
	//getter 메서드
	public int getUserNo () {
		return this.userNo;
	}
	
	public String getUserId () {
		return this.userId;
	}
	
	public String getPassword () {
		return this.password;
	}
	
	//setter 메서드
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public void setPassword (String password) {
		if (password.length() >= 6) {
			this.password = password;
		} else {
			System.out.println("비밀번호는 최소 6자리 이상이어야 합니다");
		}
	}
	
}
