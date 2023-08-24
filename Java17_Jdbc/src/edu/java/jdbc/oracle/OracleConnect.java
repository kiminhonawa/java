package edu.java.jdbc.oracle;

public interface OracleConnect {
	// 인터페이스의 필드는 public static final만 가능. public static final은 생략.
	
	// 오라클 데이터 베이스 서버 접속 주소 (IP, port, SID)
	// localhost: 현재 개인 PC (ip 주소 대신)
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// 오라클 데이터베이스 서버 계정
	String USER = "scott";
	
	// 오라클 데이터베이스 서버 계정 비밀번호
	String PASSWORD = "tiger";
	
}
