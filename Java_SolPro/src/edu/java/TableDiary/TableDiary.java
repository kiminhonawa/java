package edu.java.TableDiary;

import java.io.Serializable;

public class TableDiary implements Serializable {
	
public interface Entity {
	String TBL_NAME = "USERS"; //테이블 이름
	String COL_EMAIL = "EMAIL";
	String COL_SELECTEDEMAIL = "SELECTEDEMAIL";
	String COL_ID = "ID"; // PK
	String COL_PASSWORD = "PASSWORD";
}

	private String email;
	private String selectedemail;
	private String id;
	private String password;
	
	public TableDiary(String email, String selectedemail, String id, String password) {
		this.email = email;
		this.selectedemail = selectedemail;
		this.id = id;
		this.password = password;
	}

	
	public TableDiary(String email, String selectedemail, String password) {
		this.email = email;
		this.selectedemail = selectedemail;
		this.password = password;
	}


	public TableDiary(String id, String password) {
		this.id = id;
		this.password = password;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSelectedemail() {
		return selectedemail;
	}

	public void setSelectedemail(String selectedemail) {
		this.selectedemail = selectedemail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TableDiary [email=" + email + ", selectedemail=" + selectedemail + ", id=" + id + ", password="
				+ password + "]";
	}
	
	


}
