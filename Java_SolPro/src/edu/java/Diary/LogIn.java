package edu.java.Diary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import edu.java.TableDiary.TableDiary;
import edu.java.daopack.DiaryDaoImp;
import oracle.jdbc.logging.annotations.Log;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LogIn {
	private final DiaryDaoImp dao = DiaryDaoImp.getInstance();
	private JFrame frame;
	private JTextField textusername;
	private JTextField textloginpw;
	private JButton btnLogIn;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Log In");
		frame.setBounds(100, 100, 666, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textusername = new JTextField();
		textusername.setOpaque(true);
		textusername.setHorizontalAlignment(SwingConstants.CENTER);
		textusername.requestFocusInWindow(); // 포커스 초기에 받지 않도록 설정
		textusername.setBounds(420, 246, 218, 36);
		frame.getContentPane().add(textusername);
		textusername.setColumns(10);
		Font gainFont = new Font("굴림", Font.BOLD, 20);
		Font lostFont = new Font("굴림", Font.ITALIC, 19);
		textusername.setEditable(true);
		
		textusername.setText("아이디를 입력해 주세요."); // 텍스트 필드 힌트의 기본 문자
		textusername.setFont(new Font("굴림", Font.ITALIC, 18)); // 텍스트 필드 힌트의 기본 폰트
		textusername.setForeground(Color.GRAY); // 텍스트 필드 힌트의 기본 색상
		textusername.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) { // 포커스를 잃었을 때,
				 
				if (textusername.getText().equals("")) {
					textusername.setText("아이디를 입력해 주세요.");
					textusername.setFont(lostFont);
					textusername.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) { // 포커스를 얻었을 때,
				
				if (textusername.getText().equals("아이디를 입력해 주세요.")) {
					textusername.setText("");
					textusername.setFont(gainFont);
					textusername.setForeground(Color.BLACK);
				}
			}
		});
	     
		
	    
	   
		textloginpw = new JTextField();
		textloginpw.setHorizontalAlignment(SwingConstants.CENTER);
		textloginpw.setColumns(10);
		textloginpw.setBounds(420, 292, 218, 36);
		frame.getContentPane().add(textloginpw);
		Font gainFont1 = new Font("굴림", Font.BOLD, 20);
		Font lostFont1 = new Font("굴림", Font.ITALIC, 19);
		textloginpw.setEditable(true);
		
		textloginpw.setText("비밀번호를 입력해 주세요."); // 텍스트 필드 힌트의 기본 문자
		textloginpw.setFont(new Font("굴림", Font.ITALIC, 17)); // 텍스트 필드 힌트의 기본 폰트
		textloginpw.setForeground(Color.GRAY); // 텍스트 필드 힌트의 기본 색상
		textloginpw.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) { // 포커스를 잃었을 때,
				 
				if (textloginpw.getText().equals("")) {
					textloginpw.setText("비밀번호를 입력해 주세요.");
					textloginpw.setFont(lostFont1);
					textloginpw.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) { // 포커스를 얻었을 때,
				
				if (textloginpw.getText().equals("비밀번호를 입력해 주세요.")) {
					textloginpw.setText("");
					textloginpw.setFont(gainFont1);
					textloginpw.setForeground(Color.BLACK);
				}
			}
		});
		
		btnNewButton = new JButton("Sign In\r\n");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignIn.showSignIn(frame, LogIn.this);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton.setBounds(420, 338, 97, 36);
		frame.getContentPane().add(btnNewButton);
		
		btnLogIn = new JButton("Log In\r\n");
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TableDiary td = new TableDiary(textusername.getText(), textloginpw.getText());

				TableDiary tdi = dao.readTD(td);
				

				if (tdi != null && tdi.getId().equals(textusername.getText())&& tdi.getPassword().equals(textloginpw.getText())) 
				{
					
					DiaryMain.showDiaryMain(frame, textusername.getText(), LogIn.this);
					frame.dispose();
					
					
				} else {
					JOptionPane.showMessageDialog(frame, "아이디/비밀번호가 일치하지 않습니다");
				}
				
			}
		});
		btnLogIn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		btnLogIn.getActionMap().put("enter", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnLogIn.doClick(); // 엔터키를 누른 것과 같은 효과
		    }
		});
		btnLogIn.setFont(new Font("굴림", Font.BOLD, 18));
		btnLogIn.setBounds(541, 338, 97, 36);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnNewButton_1 = new JButton("Forgot Username?");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindAccount.showFindAccount(frame, LogIn.this);
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton_1.setBounds(22, 305, 146, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(0, 0, 0, 10);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton_2 = new JButton("Forgot Password?");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindPassword.showFindPassword(frame, LogIn.this);
			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton_2.setBounds(22, 353, 146, 42);
		frame.getContentPane().add(btnNewButton_2);
		
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("image/login.JPG"));
		lblNewLabel = new JLabel(imageicon.get(0));
		lblNewLabel.setBounds(0, -20, 650, 437);
		frame.getContentPane().add(lblNewLabel);
	}

	protected void Login() {
		
		
	}
}
