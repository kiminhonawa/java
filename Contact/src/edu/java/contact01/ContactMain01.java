package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	// 상수 (constant)
	private static final int MAX_LENGTH = 1; // 연락처 배열의 최대 길이(원소 개수)

	// 필드
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장할 배열.
	private int count = 0; // 연락처 배열에 현재까지 저장된 연락처의 개수. 배열에 저장될 때마다 값 증가.
	private Scanner scanner = new Scanner(System.in); // 입력 도구.

	public static void main(String[] args) {
		System.out.println("***** 연락처 프로그램 v0.1 *****");

		ContactMain01 app = new ContactMain01();
		// -> static이 아닌 메서드들을 사용하기 위해서 참조 변수를 생성.

		boolean run = true;
		while (run) {

			int menu = app.showMainMenu();
			switch (menu) {
			case 0: // 프로그램 종료
				run = false;
				break;
			case 1: // 새 연락처 저장
				app.insertNewContact();
				break;
			case 2: // 전체 목록
				app.selectAllContact();
				break;
			case 3: // 배열의 인덱스로 검색
				app.selectContactByIndex();
				break;
			case 4: // 수정하기
				app.updateContactByIndex();
				break;
			case 5: // 삭제하기
				app.deleteContactByIndex();
				break;
			default:
				System.out.println("메인 메뉴 번호를 확인하세요...");
			}
			System.out.println("***** 프로그램 종료 *****");
		}

	}

	public void deleteContactByIndex() {
		System.out.println();
		System.out.println(" --- 연락처 삭제 ---");
		System.out.println("삭제할 연락처 인덱스 입력>");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (index < 0 || index >= count) {
			System.out.println("해당 인덱스에는 연락처 정보 없음.");
			return;
		}
		
		for (int i = index; i < count - 1; i++) {
			contacts[i] = contacts[i + 1]; // 뒷쪽 연락처 정보를 한칸 앞으로
		}
		contacts[count - 1] = null; // 삭제 전 배열의 마지막 원소를 null
		count--; // 배열 원소 개수를 1 줄임

		System.out.println("삭제 성공");
	}

	public void updateContactByIndex() {
		System.out.println();
		System.out.println("--- 연락처 수정 ---");
		System.out.println("수정할 연락처 인덱스 입력>");
		int index = Integer.parseInt(scanner.nextLine());
		System.out.print("수정 전: ");
		contacts[index].printInfo();
		System.out.println("수정할 이름 입력>");
		String name = scanner.nextLine();
		System.out.println("수정할 전화번호 입력>");
		String phone = scanner.nextLine();
		System.out.println("수정할 이메일 입력>");
		String email = scanner.nextLine();

		// 수정할 인덱스의 정보를 업데이트
		contacts[index].setName(name);
		contacts[index].setPhone(phone);
		contacts[index].setEmail(email);

		System.out.print("수정 후:");
		contacts[index].printInfo();
	}

	public void selectContactByIndex() {
		System.out.println();
		System.out.println("--- 인덱스 검색 ---");
		System.out.println("검색할 인덱스 입력> ");
		int index = Integer.parseInt(scanner.nextLine());
	
		if (index >= 0 && index < count) {
			contacts[index].printInfo();
		} else {
			System.out.println("해당 인덱스에는 연락처 정보가 없음.");
		}
		
	
	}

	public void insertNewContact() {
		System.out.println();
		System.out.println("--- 새 연락처 저장 ---");
		
		if (count == MAX_LENGTH) {
			System.out.println("메모리 부족!");
			return;
		} 
			
		
		System.out.print("이름 입력> ");
		String name = scanner.nextLine();
		System.out.print("전화번호 입력> ");
		String phone = scanner.nextLine(); // 공백을 포함해서 엔터가 입력될 때까지 모든 문자열.
		System.out.print("이메일 입력>");
		String email = scanner.nextLine();

		// 입력받은 정보들로 Contact 타입의 객체를 생성.
		Contact c = new Contact(0, name, phone, email);
		

			// 생성된 Contact 타입의 객체를 배열에 저장.
			contacts[count] = c;

			// 배열의 저장된 원소(연락처) 객수를 1 증가.
			count++;

			System.out.println("새 연락처 저장 성공");
		
	}

	public void selectAllContact() {
		System.out.println();
		System.out.println("--- 연락처 목록 ---");
		for (int i = 0; i < count; i++) {
			contacts[i].printInfo();
		}
	}

	public int showMainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
		System.out.println("---------------------------------------------------------");
		System.out.println("선택>");

		// 콘솔 창에서 입력된 문자열 1개 라인을 정수(int)로 변환.
		int result = Integer.parseInt(scanner.nextLine());

		return result;
	}
}
