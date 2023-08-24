package edu.java.interface01;

//인터페이스를 구현하는 클래스 작성: class ClassName implements InterfaceName {...}
public class OracleDatabaseModule implements DatabaseModule{

	@Override
	public int select() {
		System.out.println("오라클 데이터 검색");
		return 1;
	}
  
	@Override
	public int insert(String strVal, int intVal) {
		System.out.println("오라클 데이터 저장");
		return 1;
}
}