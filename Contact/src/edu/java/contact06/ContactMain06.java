package edu.java.contact06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDaoImpl;

public class ContactMain06 {
	private static final String[] COLUMN_NAMES = { "이름", "전화번호" };

	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnUpdate;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model; // 테이블의 데이터, 컬럼 이름 등을 관리하는 객체.

	// 연락처 정보 관리하는 객체 (Controller)
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain06 window = new ContactMain06();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ContactCreateFrame에서 새 연락처 저장을 성공했을 때 호출할 메서드.
	public void notifyContactCreated() {
		// JTable을 새로 그림.
		// 데이터가 비워진 모델을 새로 생성.
		model = new DefaultTableModel(null, COLUMN_NAMES);
		// 파일에 저장된 데이트러를 다시 읽고 테이블 모델에 추가.
		loadContactData();
		// 새롭게 만들어진 테이블 모델을 테이블에 세팅.
		table.setModel(model);

		JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공");
	}

	public void notifyContactUpdated() {
		resetTableModel();
		JOptionPane.showMessageDialog(frame, "연락처 수정 완료");
	}

	private void resetTableModel() {
		model = new DefaultTableModel(null, COLUMN_NAMES); // 비워진 모델로 새로 생성
		loadContactData(); // 데이터를 다시 읽고 추가
		table.setModel(model);
	}

	/**
	 * Create the application.
	 */
	public ContactMain06() {
		initialize(); // 화면에 보여질 GUI 컴포넌트들을 생성하고 초기화.
		loadContactData(); // 파일에 저장된 연락처 데이터를 로딩(테이블 초기화).
	}

	private void loadContactData() {
		List<Contact> list = dao.read();
		for (Contact c : list) {
			Object[] row = { c.getName(), c.getPhone() };
			model.addRow(row);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 412, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("연락처 프로그램 v0.6");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnInsert = new JButton("새 연락처");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactCreateFrame.showContactCreateFrame(frame, ContactMain06.this);
				// this - ActionListener 타입의 익명 객체
				// ContactMain06.this - ContactMain06 타입의 객체
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 20));
		buttonPanel.add(btnInsert);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 20));
		buttonPanel.add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContact();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 20));
		buttonPanel.add(btnDelete);

		btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 20));
		buttonPanel.add(btnSearch);

		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable(); // 객체 생성
		table.setFont(new Font("굴림", Font.BOLD, 20));
		model = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 객체 생성
		table.setModel(model); // 테이블모델을 테이블에 세팅
		scrollPane.setViewportView(table); // 테이블을 스크롤페인에 넣음
		table.setRowHeight(30);

	}

	private void updateContact() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showConfirmDialog(frame, "수정할 행을 선택하세요", "오류", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// ContactUpdateFrame을 생성해서 업데이트 창을 띄움.
		// 새 창의 부모 컴포넌트 - 업데이트 창을 띄울 좌표를 계산하기 위해서
		// 선택된 테이블 행 인덱스 - 업데이트 창에서 수정 전의 데이터를 출력하기 위해서
		// ContactMain의 주소 전달 - 업데이트 창이 메인 창에게 알려주기 위해서
		ContactUpdateFrame.showContactUpdateFrame(frame, row, ContactMain06.this);
	}

	private void deleteContact() {
		// 테이블에서 선택된 행에 인덱스를 찾음.
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showConfirmDialog(frame, "삭제할 행을 선택하세요.", "오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			dao.delete(row);
			model.removeRow(row);

			JOptionPane.showMessageDialog(frame, "삭제 성공");
		}
	}

}
