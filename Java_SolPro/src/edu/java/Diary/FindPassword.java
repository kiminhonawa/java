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

public class FindPassword {
	private final DiaryDaoImp dao = DiaryDaoImp.getInstance();

	private JFrame frmFindPassword;
	private JTextField textFindEmail;
	private JTextField textFindId;
	private Component parent;
	private  LogIn app;
	private JComboBox<String> FindcomboBox;
	/**
	 * Launch the application.
	 */
	public static void showFindPassword (Component parent, LogIn app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPassword window = new FindPassword(parent, app);
					window.frmFindPassword.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FindPassword(Component parent, LogIn app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFindPassword = new JFrame();
		frmFindPassword.setTitle("Find Password");
		frmFindPassword.setBounds(100, 100, 401, 297);
		frmFindPassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFindPassword.getContentPane().setLayout(null);
		
		textFindEmail = new JTextField();
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		textFindEmail.setBounds(12, 58, 186, 36);
		textFindEmail.setFont(new Font("굴림", Font.BOLD, 18));
		frmFindPassword.getContentPane().add(textFindEmail);
		textFindEmail.setColumns(10);
		
		
		JComboBox<String> FindcomboBox = new JComboBox();
		FindcomboBox.setFont(new Font("굴림", Font.BOLD, 15));
		String[] items = { "@naver.com", "@gmail.com", "@kakao.com" };
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
		FindcomboBox.setModel(model);
		FindcomboBox.setBounds(210, 58, 121, 23);
		frmFindPassword.getContentPane().add(FindcomboBox);
		
		JLabel lblNewLabel = new JLabel("Enter your email");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 23, 286, 45);
		frmFindPassword.getContentPane().add(lblNewLabel);
		
		textFindId = new JTextField();
		textFindId.setBounds(12, 142, 186, 36);
		textFindId.setFont(new Font("굴림", Font.BOLD, 18));
		frmFindPassword.getContentPane().add(textFindId);
		textFindId.setColumns(10);
		
		JLabel lblEnterYourPassword = new JLabel("Enter your ID");
		lblEnterYourPassword.setFont(new Font("굴림", Font.BOLD, 18));
		lblEnterYourPassword.setBounds(12, 104, 286, 45);
		frmFindPassword.getContentPane().add(lblEnterYourPassword);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					TableDiary tdi = dao.readLostPassword(textFindEmail.getText(), FindcomboBox.getSelectedItem().toString(), textFindId.getText());
					JOptionPane.showMessageDialog(frmFindPassword, "패스워드 : " + tdi.getEmail());
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frmFindPassword, "없는 아이디입니다.");
				}

				
				
			}
		});
		btnsubmit.setFont(new Font("굴림", Font.BOLD, 15));
		btnsubmit.setBounds(216, 189, 115, 36);
		frmFindPassword.getContentPane().add(btnsubmit);
	}



	
		
	}


