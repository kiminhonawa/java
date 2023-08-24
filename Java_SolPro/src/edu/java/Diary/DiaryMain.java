package edu.java.Diary;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import edu.java.post.model.Post;
import edu.java.daopack.DiaryDaoImp;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DiaryMain {
	
	private static final String[] COLUMN_NAMES = { "제목", "글쓴이", "작성일" };
	private JFrame frame;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnCreate;
	private JButton btnSearch;
	private JButton btnView;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTextField textSearchbox;
	private List<Post> postList;
	private Component parent;
	private LogIn app;
	private final DiaryDaoImp dao = DiaryDaoImp.getInstance();
	private JLabel lblNewLabel;
	private JTextField txtWelcome;
	private JLabel lblWelcome;
	private String username;
	/**
	 * Launch the application.
	 */
	public static void showDiaryMain(Component parent, String username, LogIn app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiaryMain window = new DiaryMain(parent, username, app);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void notifyPostCreated() {
	model = new DefaultTableModel(null, COLUMN_NAMES);
	loadPostData();
	table.setModel(model);
	JOptionPane.showMessageDialog(frame, "게시글 등록 성공");
	}
	
	/**
	 * Create the application.
	 */
	public DiaryMain(Component parent, String username, LogIn app) {
		this.parent = parent;
		this.app = app;
		this.username = username;
		initialize();
		loadPostData();
	}
	
	private void loadPostData() {
		postList = dao.read();
		for (Post p : postList) {
			Object[] row = { p.getTitle(), p.getAuthor(), p.getCreatedTime()};
			model.addRow(row);
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
//		TableData td = new TableData();
		
		frame = new JFrame();
		frame.setTitle("Diary");
		frame.setBounds(100, 100, 617, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 232, 601, 365);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("굴림", Font.PLAIN, 14));
		scrollPane.setColumnHeaderView(table);
		model = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 객체 생성
		table.setModel(model); // 테이블모델을 테이블에 세팅
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn titleColumn = columnModel.getColumn(0); // "제목" 컬럼
		titleColumn.setPreferredWidth(200); // 넓이 조정
		TableColumn titleColumn2 = columnModel.getColumn(2);
		titleColumn2.setPreferredWidth(120);
		scrollPane.setViewportView(table); // 테이블을 스크롤페인에 넣음
		table.setRowHeight(30);
		
		btnCreate = new JButton("Post\r\n");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PostDiary.showPostDiary(frame, lblWelcome.getText(), DiaryMain.this);
			}
		});
		btnCreate.setFont(new Font("굴림", Font.BOLD, 17));
		btnCreate.setBounds(283, 189, 94, 33);
		frame.getContentPane().add(btnCreate);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchPost();
			}
		});
		
		btnSearch.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		btnSearch.getActionMap().put("enter", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnSearch.doClick(); // 엔터키를 누른 것과 같은 효과
		    }
		});
		btnSearch.setFont(new Font("굴림", Font.BOLD, 17));
		btnSearch.setBounds(464, 139, 125, 40);
		frame.getContentPane().add(btnSearch);
		
		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPost();
				
			}
		});
		btnView.setFont(new Font("굴림", Font.BOLD, 17));
		btnView.setBounds(389, 189, 94, 33);
		frame.getContentPane().add(btnView);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePost();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 17));
		btnDelete.setBounds(495, 189, 94, 33);
		frame.getContentPane().add(btnDelete);
		
		textSearchbox = new JTextField();
		
		
		textSearchbox.setBounds(24, 142, 428, 37);
		textSearchbox.setFont(new Font("굴림", Font.BOLD, 17));
		frame.getContentPane().add(textSearchbox);
		textSearchbox.setColumns(10);
		
		
		lblWelcome = new JLabel();
		lblWelcome.setBackground(Color.LIGHT_GRAY);
		lblWelcome.setForeground(Color.BLACK);
		lblWelcome.setText("Welcome " + username + "!");
		lblWelcome.setFont(new Font("타이포_헬로피오피 테두리B", Font.PLAIN, 25));
		lblWelcome.setBounds(60, 189, 238, 33);
		frame.getContentPane().add(lblWelcome);
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("image/main.JPG"));
		lblNewLabel = new JLabel(imageicon.get(0));
		lblNewLabel.setBounds(-126, -75, 727, 307);
		frame.getContentPane().add(lblNewLabel);
		
	}

	protected void searchPost() {
		String keyword = textSearchbox.getText();
		System.out.println("keyword=" + keyword);
		if (keyword == null) {
			JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.");
			return; // 메서드 종료
		} 
		
		postList = dao.read(keyword);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		for (Post p : postList) {
			Object[] row = {p.getTitle(), p.getAuthor(), p.getCreatedTime()};
			model.addRow(row);
		}
		table.setModel(model);
		
	}


	private void ViewPost() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showConfirmDialog(frame, "확인하고 싶은 게시글을 선택하세요", "오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int did = postList.get(row).getDid();
		UpdateDiary.showUpdateDiary (frame, did, DiaryMain.this);
	}

	private void deletePost() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showConfirmDialog(frame,"삭제할 게시글을 선택하세요.", "오류", JOptionPane.WARNING_MESSAGE);	
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			int cid = postList.get(row).getDid();
			dao.delete(cid); // 리스트에서 연락처 삭제, 파일 없데이트
			model.removeRow(row);

			JOptionPane.showMessageDialog(frame, "삭제 성공");
	}
	

}
	
	
	public void notifyPostUpdated() {
		resetTableModel();
		JOptionPane.showMessageDialog(frame, "수정 완료");
	}

	private void resetTableModel() {
		model = new DefaultTableModel(null, COLUMN_NAMES); // 비워진 모델로 새로 생성
		loadPostData(); // 데이터를 다시 읽고 추가
		table.setModel(model);
	}
}
