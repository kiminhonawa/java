package edu.java.Diary;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import edu.java.TableDiary.TableDiary;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.java.daopack.DiaryDaoImp;
import javax.swing.JComboBox;

public class SignIn extends JFrame {
	private final DiaryDaoImp dao = DiaryDaoImp.getInstance();
	private JFrame frmSignUp;
	private JTextField textId;
	private JTextField textPassword;
	private JTextField textConfirmPassword;
	private JButton btnNewButton;
	private Component parent;
	private  LogIn app;
	private JTextField textEmail;
	private JComboBox<String> comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void showSignIn(Component parent, LogIn app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn(parent, app);
					window.frmSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn(Component parent, LogIn app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.setTitle("Sign Up");

		//JFrame이 화면에 보이는 좌표
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		
		frmSignUp.setBounds(x, y, 410, 490);
		frmSignUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSignUp.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(12, 20, 98, 38);
		frmSignUp.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.BOLD, 20));
		lblId.setBounds(12, 148, 98, 24);
		frmSignUp.getContentPane().add(lblId);
		
		textId = new JTextField();
		textId.setBounds(12, 182, 261, 38);
		textId.setFont(new Font("굴림", Font.BOLD, 17));
		frmSignUp.getContentPane().add(textId);
		textId.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setFont(new Font("굴림", Font.BOLD, 17));
		textPassword.setBounds(12, 264, 261, 38);
		frmSignUp.getContentPane().add(textPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("굴림", Font.BOLD, 20));
		lblPassword.setBounds(12, 230, 98, 24);
		frmSignUp.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPw = new JLabel("Confirm Password");
		lblConfirmPw.setFont(new Font("굴림", Font.BOLD, 20));
		lblConfirmPw.setBounds(12, 312, 199, 24);
		frmSignUp.getContentPane().add(lblConfirmPw);
		
		textConfirmPassword = new JTextField();
		textConfirmPassword.setColumns(10);
		textConfirmPassword.setFont(new Font("굴림", Font.BOLD, 17));
		textConfirmPassword.setBounds(12, 346, 261, 38);
		frmSignUp.getContentPane().add(textConfirmPassword);
		
		btnNewButton = new JButton("Sign Up\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//데이터들을 DB에 저장.
				//1. 어느하나라도 빈칸일 경우.
				//2. 비밀번호가 일치하지 않을 경우. Confirm pw
				//3. 중복 아이디일 경우.
				StringBuffer buffer = new StringBuffer();
				
				String idx = dao.readTDI(textId.getText());
				if (textEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(frmSignUp, "이메일을 입력해주세요.");
					return;
				}
				if (textId.getText().equals(idx)) {
					JOptionPane.showMessageDialog(frmSignUp, "중복된 아이디입니다.");
					return;
				}
				if (textId.getText().equals("") || textPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(frmSignUp, "아이디/비밀번호를 입력해주세요.");
					return;
				}
				if (textPassword.getText().equals(textConfirmPassword.getText())) {
					createNewUser();
				} else {
					JOptionPane.showMessageDialog(frmSignUp, "비밀번호가 일치하지 않습니다");
				} 
				
				String item = (String) comboBox.getSelectedItem();
				buffer.append(item).append(" 콤보박스 선택됨.\n");
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setBounds(273, 394, 109, 47);
		frmSignUp.getContentPane().add(btnNewButton);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setFont(new Font("굴림", Font.BOLD, 17));
		textEmail.setBounds(12, 100, 199, 38);
		frmSignUp.getContentPane().add(textEmail);
		
		JLabel lblNewLabel_2_2 = new JLabel("EMAIL");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(12, 66, 98, 24);
		frmSignUp.getContentPane().add(lblNewLabel_2_2);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.BOLD, 15));
		String[] items = { "@naver.com", "@gmail.com", "@kakao.com" };
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
		comboBox.setModel(model);
		comboBox.setBounds(215, 100, 127, 24);
		frmSignUp.getContentPane().add(comboBox);
	}
	

	private void createNewUser() {
		String email = textEmail.getText();
		String selectedEmail = (String) comboBox.getSelectedItem();
		String id = textId.getText();
		String password = textPassword.getText();

		TableDiary user = new TableDiary(email, selectedEmail, id, password);
		
		dao.create(user);
		
		JOptionPane.showMessageDialog(frmSignUp, "회원가입에 성공하셨습니다.");
		
		frmSignUp.dispose();
	}
}
