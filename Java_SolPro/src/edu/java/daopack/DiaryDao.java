package edu.java.daopack;

import java.util.List;

import edu.java.TableDiary.TableDiary;
import edu.java.post.model.Post;
import edu.java.post.model.Post;



public interface DiaryDao {
	/**
	 * 다이어리 전체 검색 기능.
	 * DB TableDiary 테이블에 저장된 연락처 정보를 검색. 
	 * @return TableDiary 타입을 원소로 갖는 List.
	 */
	List<Post> read();
	
	/**
	 * DB TableDiary 테이블에서 primary key로 연락처 정보를 검색. 
	 * @param id 검색할 primary key.
	 * @return id가 존재하면 TableDiary 타입 객체를 리턴. id가 없으면 null을 리턴.
	 */
	Post read(Integer id);
	
	/**
	 * DB TableDiary 테이블에서 검색해서 연락처 리스트를 리턴.
	 * 
	 * @param keyword 검색어
	 * @return 검색 결과 리스트.
	 */
	List<Post> read(String keyword);
	TableDiary readLostId (String email, String selectedemail, String password);
	TableDiary readTD(TableDiary tdi);
	String readTDI(String id);
	/**
	 * 연락처 정보를 DB의 contact 테이블에 insert.
	 * 
	 * @param contact 저장할 이름(name), 전화번호(phone), 이메일(email) 정보를 가지고 있는 객체.
	 * @return DB 테이블에 삽입된 행의 개수.
	 */
	int create (Post post);
	
	/**
	 * primary key에 해당하는 연락처 정보를 수정(업데이트).
	 * 
	 * @param contact 수정할 연락처의 pk(cid), 업데이트할 이름, 전화번호, 이메일 정보를 저장한 객체.
	 * @return DB 테이블에 업데이트된 행의 개수.
	 */
	int update (Post post);
	
	/**
	 * primary key(cid)에 해당하는 연락처 정보를 DB테이블에서 삭제.
	 * 
	 * @param cid 삭제할 연락처의 pk.
	 * @return 삭제된 행의 개수.
	 */
	int delete (Integer did);
	
	int create (TableDiary tablediary);

}
