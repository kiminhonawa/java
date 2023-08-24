package edu.java.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		rbPrivate = new JRadioButton("Private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("굴림", Font.BOLD, 20));
		rbPrivate.setBounds(8, 30, 105, 23);
		frame.getContentPane().add(rbPrivate);

		rbPackage = new JRadioButton("Package");
		rbPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("굴림", Font.BOLD, 20));
		rbPackage.setBounds(136, 30, 118, 23);
		frame.getContentPane().add(rbPackage);

		rbProtected = new JRadioButton("Protected");
		rbProtected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("굴림", Font.BOLD, 20));
		rbProtected.setBounds(283, 30, 133, 23);
		frame.getContentPane().add(rbProtected);

		rbPublic = new JRadioButton("Public");
		rbPublic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("굴림", Font.BOLD, 20));
		rbPublic.setBounds(440, 30, 105, 23);
		frame.getContentPane().add(rbPublic);

		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbAbstract.setFont(new Font("굴림", Font.BOLD, 20));
		cbAbstract.setBounds(8, 77, 126, 49);
		frame.getContentPane().add(cbAbstract);

		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbFinal.setFont(new Font("굴림", Font.BOLD, 20));
		cbFinal.setBounds(145, 77, 96, 49);
		frame.getContentPane().add(cbFinal);

		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbStatic.setFont(new Font("굴림", Font.BOLD, 20));
		cbStatic.setBounds(251, 77, 126, 49);
		frame.getContentPane().add(cbStatic);

		comboBox = new JComboBox<>();
		String[] items = { "naver.com", "gmail.com", "kakao.com" };
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
		comboBox.setModel(model);
		comboBox.setFont(new Font("굴림", Font.BOLD, 20));
		comboBox.setBounds(26, 164, 170, 37);
		frame.getContentPane().add(comboBox);

		btnInfo = new JButton("확인");
		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printInfo();
			}
		});
		btnInfo.setFont(new Font("굴림", Font.BOLD, 25));
		btnInfo.setBounds(392, 149, 138, 65);
		frame.getContentPane().add(btnInfo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 238, 504, 219);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("굴림", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
	}

	private void printInfo() {
		// 라디오버튼, 체크박스, 콤보박스의 상대를 JTextArea에 출력.
		StringBuffer buffer = new StringBuffer(); // textArea에 출력할 문자열을 저장하기 위해서.

		// 어떤 라디오버튼이 선택됐는 지를 체크
		if (rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		} else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if (rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		} else {
			buffer.append(rbPublic.getText());
		}
		buffer.append(" 라디오 버튼 선택됨.\n");

		// 체크박스들의 선택 여부를 확인.
		if (cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append("");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append("");
		}
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append("");
		}
		buffer.append(" 체크박스 선택됨. \n");
		
		// 콤보박스에서 선택된 아이템 찾기
		String item = (String) comboBox.getSelectedItem();
		buffer.append(item).append(" 콤보박스 선택됨.\n");
		
		// buffer의 내용을 textArea에 출력
		textArea.setText(buffer.toString());
		
		
		
	}

	private void handleCheckBoxClick(ActionEvent event) {
		JCheckBox chbox = (JCheckBox) event.getSource();

		String text = chbox.getText();

		boolean selected = chbox.isSelected();

		textArea.setText(text + " : " + selected);

	}

	private void handleRadioButtonClick(ActionEvent event) {
		// 클릭 이벤트가 발생한 이벤트 소스 (라디오버튼)를 찾음.
		JRadioButton btn = (JRadioButton) event.getSource();

		// 라디오버튼의 텍스트를 찾음.
		String btnText = btn.getText();

		// 라디오버튼의 선택(체크) 여부를 확인
		boolean selected = btn.isSelected();

		// 결과를 출력.
		textArea.setText(btnText + " : " + selected);

	}
}
