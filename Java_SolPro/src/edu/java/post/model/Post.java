package edu.java.post.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Post implements Serializable {
	

public interface Entity {
	String TBL_NAME = "POST";
	String COl_DID = "DID" ;
	String COL_TITLE = "TITLE";
	String COL_POST1 = "POST1";
	String COL_AUTHOR = "AUTHOR";
	String COL_TIME_CREATED = "CREATEDATE";
}

	private int did;
	private String title;
	private String post1;
	private String author;
	private LocalDateTime createdTime;
	
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public Post() {}

	
// select 전체검색
	public Post(int did, String title, String post1, String author, LocalDateTime createdTime) {
		this.did = did;
		this.title = title;
		this.post1 = post1;
		this.author = author;
		this.createdTime = createdTime;
	}
	
	


	// insert
	public Post(String title, String post1, String author) {
		this.title = title;
		this.post1 = post1;
		this.author = author;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPost1() {
		return post1;
	}

	public void setPost1(String post1) {
		this.post1 = post1;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [did=" + did + ", title=" + title + ", post1=" + post1 + ", author=" + author + "]";
	}

}