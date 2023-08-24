package edu.java.contact06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
	
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JButton btnCreated;
	private JButton btnCancel;

	private Component parent; //부모 컴퍼런트 (JFrame)를 저장하기 위한 필드.
	private ContactMain06 app; //notifyContactCreated 메서드를 가지고 있는 객체. 
	
	/**
	 * Launch the application.
	 */
	
	
	public static void showContactCreateFrame(Component parent, ContactMain06 app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactCreateFrame(Component parent, ContactMain06 app) {
		this.parent = parent;
		this.app = app;
		initialize(); //컴포넌트들을 생성하고 초기화.
	}
	
	
	public void initialize() {
		setTitle("새 연락처 저장");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재창만 닫기-> DISPOSE로 설정
	
		//JFrame이 화면에 보이는 좌표
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 357, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.BOLD, 23));
		lblName.setBounds(12, 20, 91, 39);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.BOLD, 20));
		textName.setBounds(114, 14, 205, 45);
		panel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("굴림", Font.BOLD, 22));
		lblPhone.setBounds(12, 69, 103, 45);
		panel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.BOLD, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(114, 71, 205, 45);
		panel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("굴림", Font.BOLD, 23));
		lblEmail.setBounds(12, 124, 91, 45);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("굴림", Font.BOLD, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(114, 124, 205, 45);
		panel.add(textEmail);
		
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		
		btnCreated = new JButton("저장");
		btnCreated.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewContact();
			}
		});
		btnCreated.setFont(new Font("굴림", Font.BOLD, 23));
		btnPanel.add(btnCreated);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("굴림", Font.BOLD, 23));
		btnPanel.add(btnCancel);
	}

	private void createNewContact() {
		// JTextField에서 이름/전화번호/이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// Contact 타입 객체 생성.
		Contact contact = new Contact(0, name, phone, email);
		
		// 리스트에 추가. 파일 업데이트 -> DAO
		dao.create(contact);
		
		// ContactMain에게 새 연락처가 저장됐다고 알려줌.
		app.notifyContactCreated();
		
		// 현재 창 닫기
		dispose();
	}
}
