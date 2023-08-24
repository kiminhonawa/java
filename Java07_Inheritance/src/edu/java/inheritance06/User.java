package edu.java.inheritance06;

import java.util.Objects;

public class User {
	// field
	private String userId;
	private String password;

	// 생성자: 1. 기본 2.아규먼트 두개 갖는 생성자

	public User() {
	}

	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	// getters, setters

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString() override: "User(userId=..., password=...)"

	@Override
	public String toString() {
		String s = String.format("User(userId = %s password = %s) ", userId, password);
		return s;
	}

	// equals() override: 두 객체의 userId가 같으면 true 그렇지 않으면 false.
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof User) {
			User other = (User) obj;//캐스팅
			if (this.userId.equals(other.userId));
			return true;
		}
			return result;
	}
	// hashCode() override

	public int hashCode() {
	//	return Objects.hash(userId);
		if (this.userId == null) {
			return 0;
		} else {
			return this.userId.hashCode();
		}
	}

}
