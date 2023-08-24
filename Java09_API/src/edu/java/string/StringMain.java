package edu.java.string;

public class StringMain {

	public static void main(String[] args) {
		// EX 1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
		String ssn = "991231-1234567";
		char gender = ssn.charAt(7);
		System.out.println(gender);

		String[] array = ssn.split("-");
		System.out.println(array[1].charAt(0));
		System.out.println("--------------------------------------------");
		// EX 2. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
		// 만약에 "홍길동" 문자열이 배열에 없으면 -1을 출력.
		String[] names = { "오쌤", "John", "Jane", "홍길동", "허균", "홍길동" };
		int index = -1;
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동")) {
				index = i;
				break;
			}
		}

		System.out.println("홍길동 첫 배열: " + index);

		// EX 3. 아래의 문자열 배열에서 5글자 이상인 문자열들을 찾아서 출력.
		String[] languages = { "Java", "SQL", "HTML", "CSS", "JavaScript", "Python" };
		for (String language : languages) {
			if (language.length() >= 5) {
				System.out.print(language + "  ");

			}
		}

		System.out.println();

		// EX 4. 아래의 문자열 배열에서 대소문자 구별 없이 "est"가 포함된 문자열들을 찾아서 출력.
		String[] tests = { "TEST", "test", "TeSt", "tEST", "테스트" };
		for (String test1 : tests) {
			if (test1.toLowerCase().contains("est")) {
				System.out.print(test1 + " ");
			}
		}
		System.out.println();
		// EX 5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 연/월/일 정보를 int타입 변수에 저장하고 출력.
		String date = "2023-03-22";
		String[] dateStrings = date.split("-");
		int year = Integer.parseInt(dateStrings[0]);
		int month = Integer.parseInt(dateStrings[1]);
		int day = Integer.parseInt(dateStrings[2]);
		System.out.printf("%d년 %d월 %d일", year, month, day);

	}
}
