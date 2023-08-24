package edu.java.swing04;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {
	// 이미지 파일의 경로들을 저장하는 배열.
	private static final String[] IMAGES = { "images/img1.jpg", "images/img2.jpg", "images/img3.jpg", "images/img4.jpg",
			"images/img5.jpg", };

	private int curIndex; // 현재 화면에 보여지는 이미지 파일의 인덱스
	private JFrame frame;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnPrev = new JButton("이전");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼이 클릭됐을 때 할 일을 작성.
				showPrevImage();
			}
		});
		btnPrev.setFont(new Font("굴림", Font.BOLD, 25));
		btnPrev.setBounds(12, 420, 114, 55);
		frame.getContentPane().add(btnPrev);

		JButton btnNext = new JButton(IMAGES[curIndex] +"다음");
		btnNext.addActionListener((e) -> showNextImage()); // 람다 표현식
		btnNext.setFont(new Font("굴림", Font.BOLD, 25));
		btnNext.setBounds(325, 420, 114, 55);
		frame.getContentPane().add(btnNext);

		lblImage = new JLabel(new ImageIcon(IMAGES[curIndex]));
		// new ImageIcon("imgaes/img1.jpg")
		lblImage.setBounds(12, 10, 427, 400);
		frame.getContentPane().add(lblImage);
	}

	private void showNextImage() {
		if (curIndex < IMAGES.length - 1) {
			curIndex++;
		} else {
			curIndex = 0;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
	}

	private void showPrevImage() {
		if (curIndex > 0) {
			curIndex--;
		} else {
			curIndex = IMAGES.length - 1;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
	}
}
