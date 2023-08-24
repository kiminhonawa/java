package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnOptionDlg;
	private JButton btnInputDlg;
	private JButton btnCustomFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "안녕하세요?");
				JOptionPane.showMessageDialog(
						frame, // 메시지 다이얼로그가 실행될 부모 컴포넌트
						"안녕하냐고요.", // 다이얼로그에 표시될 메시지
						"메시지", // 다이얼로그 타이틀(제목)
						JOptionPane.ERROR_MESSAGE // 메시지 타입
						);
			}
		});
		btnMsgDlg.setForeground(new Color(0, 0, 0));
		btnMsgDlg.setFont(new Font("굴림", Font.BOLD, 32));
		btnMsgDlg.setBackground(new Color(255, 0, 0));
		btnMsgDlg.setBounds(12, 10, 486, 75);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(
						frame, // 부모 컴포넌트
						"정말 삭제할까요?", // 메시지
						"삭제 확인", // 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, // 확인 옵션 (yes-no, yes-no-cancel)
						JOptionPane.QUESTION_MESSAGE // 메시지 타입
						);
				btnConfirmDlg.setText("Confirm = " + result);
			
			}
		
		});
		btnConfirmDlg.setForeground(Color.BLACK);
		btnConfirmDlg.setFont(new Font("굴림", Font.BOLD, 32));
		btnConfirmDlg.setBackground(new Color(255, 128, 64));
		btnConfirmDlg.setBounds(12, 95, 486, 75);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnOptionDlg = new JButton("Option Dialog");
		btnOptionDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"네", "아니요", "오이시쿠나레", "모에모에뀽"};
				int result = JOptionPane.showOptionDialog (
						frame, // 부모 컴포넌트	
						"다나카를 지명하시겠습니까?", // 메시지
						"다나카 No.1 호스트", // 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, // 옵션 타임
						JOptionPane.QUESTION_MESSAGE, // 메시지 타입
						null, // 아이콘
						options, // 옵션들의 배열
						options[2]  // 옵션 초깃값
						
						);
				btnOptionDlg.setText("Option result =" + result);
			}
		});
		btnOptionDlg.setForeground(Color.BLACK);
		btnOptionDlg.setFont(new Font("굴림", Font.BOLD, 32));
		btnOptionDlg.setBackground(new Color(255, 255, 0));
		btnOptionDlg.setBounds(12, 180, 486, 75);
		frame.getContentPane().add(btnOptionDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//String input = JOptionPane.showInputDialog(frame, "이름을 입력하세요.");
				Object[] selectionValues = {"모무모무모무매", "숙녀의", "몸무게는", "비밀"};
				Object input = JOptionPane.showInputDialog(
						frame, // 부모 컴포넌트
						"몸무게", // 메시지
						"화긘", // 타이틀 
						JOptionPane.QUESTION_MESSAGE, //메시지 타입
						null, //아이콘
						selectionValues, // 입력으로 사용할 수 있는 선택지들의 배열
						e
						);
				btnInputDlg.setText("Input =" + input);
			}
		});
		btnInputDlg.setForeground(Color.BLACK);
		btnInputDlg.setFont(new Font("굴림", Font.BOLD, 32));
		btnInputDlg.setBackground(new Color(0, 255, 128));
		btnInputDlg.setBounds(12, 265, 486, 75);
		frame.getContentPane().add(btnInputDlg);
		
		JButton btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDialog.showMyDialog(frame);
			}
		});
		btnCustomDlg.setForeground(Color.BLACK);
		btnCustomDlg.setFont(new Font("굴림", Font.BOLD, 32));
		btnCustomDlg.setBackground(new Color(0, 0, 255));
		btnCustomDlg.setBounds(12, 350, 486, 75);
		frame.getContentPane().add(btnCustomDlg);
		
		btnCustomFrame = new JButton("Custom Frame");
		btnCustomFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFrame.ShowMyFrame();
			}
		});
		btnCustomFrame.setForeground(Color.BLACK);
		btnCustomFrame.setFont(new Font("굴림", Font.BOLD, 32));
		btnCustomFrame.setBackground(new Color(128, 0, 255));
		btnCustomFrame.setBounds(12, 435, 486, 75);
		frame.getContentPane().add(btnCustomFrame);
	}
	
}
