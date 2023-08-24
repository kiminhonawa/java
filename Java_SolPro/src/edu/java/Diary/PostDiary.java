package edu.java.Diary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.post.model.Post;
import edu.java.daopack.DiaryDaoImp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class PostDiary extends JFrame {

	private final DiaryDaoImp dao = DiaryDaoImp.getInstance();
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblTitle;
	private JTextField textTitle;

	private Component parent; // 부모 컴퍼런트 (JFrame)를 저장하기 위한 필드.
	private DiaryMain app; // notifyContactCreated 메서드를 가지고 있는 객체.
	private JTextArea textPost;
	private JButton btnCancel;
	private JButton btnSave;
	private JTextField textAuthor;
	private JLabel lblNewLabel_1;
	private String username;
	/**
	 * Launch the application.
	 */

	public static void showPostDiary(Component parent, String username, DiaryMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostDiary frame = new PostDiary(parent, username, app);
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
	public PostDiary(Component parent, String username, DiaryMain app) {
		this.parent = parent;
		this.app = app;
		this.username = username;
		initialize(); // 컴포넌트들을 생성하고 초기화.
	}

	public void initialize() {
		setTitle("글 쓰기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재창만 닫기-> DISPOSE로 설정

		// JFrame이 화면에 보이는 좌표
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 495, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 479, 644);
		contentPane.add(panel);
		panel.setLayout(null);

		lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 18));
		lblTitle.setBounds(83, 67, 91, 27);
		panel.add(lblTitle);

		textTitle = new JTextField();
		textTitle.setFont(new Font("굴림", Font.BOLD, 20));
		textTitle.setBounds(121, 66, 346, 27);
		Font gainFont = new Font("굴림", Font.PLAIN, 19);
		Font lostFont = new Font("굴림", Font.ITALIC, 19);

		textTitle.setText("제목을 입력해 주세요."); // 텍스트 필드 힌트의 기본 문자
		textTitle.setFont(lostFont); // 텍스트 필드 힌트의 기본 폰트
		textTitle.setForeground(Color.GRAY); // 텍스트 필드 힌트의 기본 색상
		textTitle.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) { // 포커스를 잃었을 때,
				if (textTitle.getText().equals("")) {
					textTitle.setText("제목을 입력해 주세요.");
					textTitle.setFont(lostFont);
					textTitle.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) { // 포커스를 얻었을 때,
				if (textTitle.getText().equals("제목을 입력해 주세요.")) {
					textTitle.setText("");
					textTitle.setFont(gainFont);
					textTitle.setForeground(Color.BLACK);
				}
			}
		});
		panel.add(textTitle);
		textTitle.setColumns(10);
		
		textPost = new JTextArea();
		textPost.setBounds(11, 103, 456, 340);
		panel.add(textPost);
		Font gainFont1 = new Font("굴림", Font.PLAIN, 19);
		Font lostFont1 = new Font("굴림", Font.ITALIC, 19);

		textPost.setText("내용을 입력하세요."); // 텍스트 필드 힌트의 기본 문자
		textPost.setFont(lostFont); // 텍스트 필드 힌트의 기본 폰트
		textPost.setForeground(Color.GRAY); // 텍스트 필드 힌트의 기본 색상
		textPost.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) { // 포커스를 잃었을 때,
				if (textPost.getText().equals("")) {
					textPost.setText("내용을 입력하세요.");
					textPost.setFont(lostFont1);
					textPost.setForeground(Color.GRAY);
					
				}
			}

			@Override
			public void focusGained(FocusEvent e) { // 포커스를 얻었을 때,
				if (textPost.getText().equals("내용을 입력하세요.")) {
					textPost.setText("");
					textPost.setFont(gainFont1);
					textPost.setForeground(Color.BLACK);
				}
			}
		});

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("굴림", Font.BOLD, 18));
		btnCancel.setBounds(348, 579, 109, 45);
		panel.add(btnCancel);

		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String title = textTitle.getText();
				String postinfo = textPost.getText();
				String author = textAuthor.getText();
				if (title.length() == 0 && postinfo.length() == 0 && author.length() == 0) {
					JOptionPane.showMessageDialog(parent, "제목과 내용을 적어주세요.");
				} else if ((title.equals("제목을 입력해 주세요.")) || postinfo.equals("내용을 입력하세요."))
				{ JOptionPane.showMessageDialog(parent, "제목과 내용을 적어주세요.");
				} else {
					createNewPost();
				}
			}
		});
		
		btnSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		btnSave.getActionMap().put("enter", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnSave.doClick(); // 엔터키를 누른 것과 같은 효과
		    }
		});
		btnSave.setFont(new Font("굴림", Font.BOLD, 18));
		btnSave.setBounds(227, 579, 109, 45);
		panel.add(btnSave);

		textAuthor = new JTextField(username.split("Welcome ")[1].split("!")[0]);
		textAuthor.setFont(new Font("굴림", Font.BOLD, 15));
		textAuthor.setEditable(false);
		
		textAuthor.setBounds(345, 35, 122, 21);
		panel.add(textAuthor);
		textAuthor.setColumns(10);
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("image/post.JPG"));
		lblNewLabel_1 = new JLabel(imageicon.get(0));
		lblNewLabel_1.setBounds(0, -81, 602, 725);
		panel.add(lblNewLabel_1);

	}

	private void createNewPost() {
		String title = textTitle.getText();
		String postinfo = textPost.getText();
		String author = textAuthor.getText();
		Post post = new Post(title, postinfo, author);

		dao.create(post);

		app.notifyPostCreated();
		dispose();
	}
}
