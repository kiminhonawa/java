package edu.java.Diary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import edu.java.daopack.DiaryDaoImp;
import edu.java.post.model.Post;

public class UpdateDiary extends JFrame {
	private final DiaryDaoImp dao = DiaryDaoImp.getInstance();
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblTitle;
	private JTextField textTitle;

	private Component parent; 
	private DiaryMain app; 
	private JTextArea textPost;
	private JLabel lblNewLabel;
	private JButton btnCancel;
	private JButton btnSave;
	private JTextField textAuthor;
	private JLabel lblNewLabel_2;
	private int did;
	
	public UpdateDiary() {
	}
	public static void showUpdateDiary(Component parent, int did, DiaryMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDiary frame = new UpdateDiary(parent, did, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UpdateDiary(Component parent, int did, DiaryMain app) {
		this.parent = parent;
		this.did = did;
		this.app = app;
		initialize(); // 컴포넌트들을 생성하고 초기화.
		readPost();
	}

	private void readPost() {
		Post post = dao.read(did);
		textTitle.setText(post.getTitle());
		textPost.setText(post.getPost1());
		textAuthor.setText(post.getAuthor());
	}
	
	public void initialize() {
		setTitle("게시물 수정");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	//JFrame이 화면에 보이는 좌표
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
			contentPane.setLayout(new BorderLayout(0, 0));
			
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			lblTitle = new JLabel("제목");
			lblTitle.setFont(new Font("굴림", Font.BOLD, 18));
			lblTitle.setBounds(82, 58, 91, 27);
			panel.add(lblTitle);
			
			textTitle = new JTextField();
			textTitle.setFont(new Font("굴림", Font.BOLD, 20));
			textTitle.setBounds(122, 56, 335, 27);
		
			panel.add(textTitle);
			textTitle.setColumns(10);
			
			textPost = new JTextArea();
			textPost.setBounds(12, 95, 445, 340);
			panel.add(textPost);
	
			lblNewLabel = new JLabel("글 쓰기");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel.setBounds(12, 16, 286, 38);
			panel.add(lblNewLabel);
			
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancel.setFont(new Font("굴림", Font.BOLD, 18));
			btnCancel.setBounds(348, 445, 109, 45);
			panel.add(btnCancel);
			
			btnSave = new JButton("수정하기");
			btnSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					UpdatePost();
					
				}
			});
			btnSave.setFont(new Font("굴림", Font.BOLD, 18));
			btnSave.setBounds(227, 445, 109, 45);
			panel.add(btnSave);
			
			textAuthor = new JTextField();
			textAuthor.setText("123");
			textAuthor.setBounds (341, 28,116, 21);
			panel.add(textAuthor);
			textAuthor.setColumns(10);
			
		}

	protected void UpdatePost() {
		String title = textTitle.getText();
		String postinfo = textPost.getText();
		String author = textAuthor.getText();
		Post post = new Post(title, postinfo, author);
		int confirm = JOptionPane.showConfirmDialog(this, "정말 수정할까요?", "수정 확인", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			dao.update(post);
			app.notifyPostUpdated();
			dispose();
		}
	}
	
	
}
