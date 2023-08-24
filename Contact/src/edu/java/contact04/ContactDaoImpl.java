package edu.java.contact04;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;

// MVC(Model-View-Controller) 아키텍쳐 컨트롤러 구현 클래스.
// singleton 디자인 패턴을 적용.

public class ContactDaoImpl implements ContactDao {
	// singleton step 1
	private static ContactDaoImpl instance = null;

	// signleton step 2
	private ContactDaoImpl() {
	};

	// singleton step 3
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}

		return instance;
	}

	// field

	private List<Contact> contacts = new ArrayList<>();

	/*
	 * 어떤 인덱스가 검색, 수정, 삭제할 때 사용 가능한 범위 안에 있는 인덱스인 지를 리턴.
	 * 
	 * @param index 유효한 인덱스인 지 검사할 인덱스.
	 * 
	 * @return 사용가능한 인덱스는 true, 그렇지 않으면 false.
	 */
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());
	}

	// CRUD (Creat, Read, Update, Delete) 기능 메서드들.
	@Override
	public int create(Contact c) {
		contacts.add(c);

		return 1;
	}

	@Override
	public List<Contact> read() {

		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (isValidIndex(index)) {
			return contacts.get(index);
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index)) {
//			contacts.get(index).setName(contact.getName());
//			contacts.get(index).setPhone(contact.getPhone());
//			contacts.get(index).setEmail(contact.getEmail());
			contacts.set(index, contact);

			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public int delete(int index) {
		if (!isValidIndex(index)) {
			return 0;
		} else {
			contacts.remove(index);
			return 1;
		}
	}
}