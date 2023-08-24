package edu.java.Diary;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import edu.java.TableDiary.TableDiary;
import edu.java.daopack.DiaryDao;
import edu.java.daopack.DiaryDaoImp;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindAccount {
	private final DiaryDaoImp dao = DiaryDaoImp.getInstance();

	private JFrame frmFindUsername;
	private JTextField textFindEmail;
	private JTextField textFindPw;
	private Component parent;
	private  LogIn app;
	private JComboBox<String> FindcomboBox;
	/**
	 * Launch the application.
	 */
	public static void showFindAccount (Component parent, LogIn app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindAccount window = new FindAccount(parent, app);
					window.frmFindUsername.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FindAccount(Component parent, LogIn app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFindUsername = new JFrame();
		frmFindUsername.setTitle("Find Username");
		frmFindUsername.setBounds(100, 100, 401, 297);
		frmFindUsername.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFindUsername.getContentPane().setLayout(null);
		
		textFindEmail = new JTextField();
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		textFindEmail.setFont(new Font("굴림", Font.BOLD, 17));
		textFindEmail.setBounds(12, 58, 191, 36);
		frmFindUsername.getContentPane().add(textFindEmail);
		textFindEmail.setColumns(10);
		
		
		JComboBox<String> FindcomboBox = new JComboBox();
		FindcomboBox.setFont(new Font("굴림", Font.BOLD, 15));
		String[] items = { "@naver.com", "@gmail.com", "@kakao.com" };
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
		FindcomboBox.setModel(model);
		FindcomboBox.setBounds(215, 58, 127, 23);
		frmFindUsername.getContentPane().add(FindcomboBox);
		
		JLabel lblNewLabel = new JLabel("Enter your email");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 23, 286, 45);
		frmFindUsername.getContentPane().add(lblNewLabel);
		
		textFindPw = new JTextField();
		textFindPw.setBounds(12, 142, 191, 36);
		frmFindUsername.getContentPane().add(textFindPw);
		textFindPw.setFont(new Font("굴림", Font.BOLD, 17));
		textFindPw.setColumns(10);
		
		JLabel lblEnterYourPassword = new JLabel("Enter your password");
		lblEnterYourPassword.setFont(new Font("굴림", Font.BOLD, 18));
		lblEnterYourPassword.setBounds(12, 104, 286, 45);
		frmFindUsername.getContentPane().add(lblEnterYourPassword);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TableDiary tdi = dao.readLostId(textFindEmail.getText(), FindcomboBox.getSelectedItem().toString(), textFindPw.getText());
					JOptionPane.showMessageDialog(frmFindUsername, "아이디 : " + tdi.getEmail());
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frmFindUsername, "없는 아이디입니다.");
				}			
				
			
			}
		});
		btnsubmit.setFont(new Font("굴림", Font.BOLD, 15));
		btnsubmit.setBounds(227, 193, 115, 36);
		frmFindUsername.getContentPane().add(btnsubmit);
	}



	
		
	}


