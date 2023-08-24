package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {
	// JTable에서 사용할 컬럼 이름들
	private static final String[] COLUMN_NAMES = { "국어", "영어", "수학", "총점", "평균" };

	private DefaultTableModel model;
	private JFrame frame;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JLabel lblKorean;
	private JLabel lblEnglish;
	private JLabel lblMath;
	private JButton btnInsert;
	private JButton btnDelete;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 409, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("굴림", Font.PLAIN, 25));
		lblKorean.setBounds(12, 22, 137, 69);
		frame.getContentPane().add(lblKorean);

		lblEnglish = new JLabel("영어");
		lblEnglish.setFont(new Font("굴림", Font.PLAIN, 25));
		lblEnglish.setBounds(12, 101, 137, 69);
		frame.getContentPane().add(lblEnglish);

		lblMath = new JLabel("수학");
		lblMath.setFont(new Font("굴림", Font.PLAIN, 25));
		lblMath.setBounds(12, 180, 97, 69);
		frame.getContentPane().add(lblMath);

		textKorean = new JTextField();
		textKorean.setFont(new Font("굴림", Font.BOLD, 18));
		textKorean.setBounds(76, 25, 305, 69);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);

		textEnglish = new JTextField();
		textEnglish.setFont(new Font("굴림", Font.BOLD, 18));
		textEnglish.setColumns(10);
		textEnglish.setBounds(76, 101, 305, 69);
		frame.getContentPane().add(textEnglish);

		textMath = new JTextField();
		textMath.setFont(new Font("굴림", Font.BOLD, 18));
		textMath.setColumns(10);
		textMath.setBounds(76, 180, 305, 69);
		frame.getContentPane().add(textMath);

		btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertScoreToTable();

			}
		});
		btnInsert.setFont(new Font("굴림", Font.PLAIN, 25));
		btnInsert.setBounds(12, 259, 123, 61);
		frame.getContentPane().add(btnInsert);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRowFromTable();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 25));
		btnDelete.setBounds(147, 259, 123, 61);

		frame.getContentPane().add(btnDelete);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 330, 369, 193);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("굴림", Font.BOLD, 19));
		Object[][] data = {}; // 테이블에 사용할 데이터
		model = new DefaultTableModel(data, COLUMN_NAMES);
		table.setModel(model);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
	}

	private void deleteRowFromTable() {
		int index = table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(frame, "삭제할 행을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(frame, index + "인덱스 행을 정말 삭제할까요?", "삭제 확인",
				JOptionPane.YES_NO_CANCEL_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			model.removeRow(index);
		}

	}

	private void insertScoreToTable() {
		int korean = 0;
		int english = 0;
		int math = 0;
		try {
			korean = Integer.parseInt(textKorean.getText());
			english = Integer.parseInt(textEnglish.getText());
			math = Integer.parseInt(textMath.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "점수를 입력해주세요.", "입력 에러", JOptionPane.ERROR_MESSAGE);

			return;
		}

		Score score = new Score(korean, english, math);

		Object[] data = { score.getKorean(), score.getEnglish(), score.getMath(), score.getTotal(), score.getMean() };

		model.addRow(data);

		clearAllTextFields();
	}

	private void clearAllTextFields() {
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");
	}

}
