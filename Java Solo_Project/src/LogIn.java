import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogIn extends JFrame implements ActionListener {
    private JLabel labelUsername, labelPassword;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JButton buttonLogin;

    public LogIn() {
        setTitle("로그인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        labelUsername = new JLabel("아이디:");
        labelPassword = new JLabel("비밀번호:");
        textUsername = new JTextField(10);
        textPassword = new JPasswordField(10);
        buttonLogin = new JButton("로그인");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(labelUsername);
        panel.add(textUsername);
        panel.add(labelPassword);
        panel.add(textPassword);
        panel.add(new JLabel());
        panel.add(buttonLogin);

        buttonLogin.addActionListener(this);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = textUsername.getText();
        String password = new String(textPassword.getPassword());

        // 로그인 처리
        if (username.equals("사용자명") && password.equals("비밀번호")) {
            JOptionPane.showMessageDialog(this, "로그인 되었습니다.");
        } else {
            JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 일치하지 않습니다.");
        }
    }

    public static void main(String[] args) {
        new LogIn();
    }
}

