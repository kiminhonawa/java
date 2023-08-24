package com.java.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class AccBookMain {
	private final String ID = "aa";
	private final String PASS = "123";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;
	private JPanel currPanel;
	private JTextField nameInput;
	private JTextField amountInput;
	private JTextField searchInput;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccBookMain window = new AccBookMain();
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
	public AccBookMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TableData td = new TableData();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("data/images/theme.jpg").getImage());
		loginPanel.setBounds(0, 0, 120, 7);
		currPanel = loginPanel;
		ImagePanel tranPanel = new ImagePanel(new ImageIcon("data/images/Activation.jpg").getImage());
		tranPanel.setBounds(0, 0, -1, -1);
		
		frame.setSize(new Dimension(136, 924));
		frame.setPreferredSize(loginPanel.getDim());
		frame.getContentPane().setLayout(null);
		ImagePanel sumPanel = new ImagePanel(new ImageIcon("data/images/Activation.jpg").getImage());
		sumPanel.setBounds(0, 0, -1, -1);
		frame.getContentPane().add(sumPanel);
		
		
		sumPanel.setVisible(false);
		
		// Summary 
		
		JButton tranBtn = new JButton("");
		tranBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				tranPanel.setVisible(true);
				currPanel = tranPanel;
			}
		});
		tranBtn.setIcon(new ImageIcon("data/images/transaction.jpg"));
		tranBtn.setBounds(29, 182, 259, 40);
		tranBtn.setBorder(null);
		sumPanel.add(tranBtn);
		
		JLabel lblSearch = new JLabel("Search :");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSearch.setBounds(337, 76, 83, 40);
		sumPanel.add(lblSearch);
		
		searchInput = new JTextField();
		searchInput.setFont(new Font("Tahoma", Font.PLAIN, 22));
		searchInput.setBounds(432, 76, 1080, 40);
		sumPanel.add(searchInput);
		searchInput.setColumns(10);
		
		JPanel tp = new JPanel();
		tp.setBounds(337, 140, 1175, 467);
		sumPanel.add(tp);
		
		table = new JTable(td);
		table.setBounds(337, 140, 1155, 445);
		table.setRowHeight(30);
		table.setFont(new Font("Sansserif", Font.BOLD, 15));
		table.setPreferredScrollableViewportSize(new Dimension(1155,430));
		tp.add(new JScrollPane(table));
		tp.setOpaque(false);
		
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(92,179, 255));
		header.setForeground(new Color(255,255,255));
		header.setFont(new Font("Sansserif", Font.BOLD,15));
		
		searchInput.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				String search = searchInput.getText();
				TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(td);
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		
		frame.getContentPane().add(tranPanel);
		
		
		tranPanel.setVisible(false);
		frame.getContentPane().add(loginPanel);
		
		idField = new JTextField();
		idField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		idField.setBounds(1223, 311, 296, 43);
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passField.setBounds(1223, 391, 296, 43);
		passField.setBorder(null);
		loginPanel.add(passField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(1184, 440, 25, 25);
		loginPanel.add(chckbxNewCheckBox);
		
		JButton logInBtn = new JButton("");
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ID.equals(idField.getText()) && PASS.equals(passField.getText())){
					currPanel.setVisible(false);
					sumPanel.setVisible(true);
					currPanel = sumPanel;
				}else{
					JOptionPane.showMessageDialog(null,"You Failed to Log In");
				}
			}
		});
		logInBtn.setBorder(null);
		logInBtn.setBounds(1183, 467, 338, 38);
		loginPanel.add(logInBtn);
		logInBtn.setIcon(new ImageIcon("data/images/button.jpg"));
		logInBtn.setPressedIcon(new ImageIcon("data/images/btnClicked.jpg"));
		
		// Transaction
		
		JButton sumBtn = new JButton("");
		sumBtn.setIcon(new ImageIcon("data/images/summary.jpg"));
		sumBtn.setBorder(null);
		sumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				sumPanel.setVisible(true);
				currPanel = sumPanel;
			}
		});
		sumBtn.setBounds(29, 123, 259, 40);
		tranPanel.add(sumBtn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblName.setBounds(378, 123, 139, 49);
		tranPanel.add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblType.setBounds(378, 203, 139, 49);
		tranPanel.add(lblType);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblAmount.setBounds(378, 284, 139, 49);
		tranPanel.add(lblAmount);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNote.setBounds(378, 370, 139, 49);
		tranPanel.add(lblNote);
		
		nameInput = new JTextField();
		nameInput.setFont(new Font("Tahoma", Font.PLAIN, 33));
		nameInput.setBounds(527, 123, 935, 49);
		tranPanel.add(nameInput);
		nameInput.setColumns(10);
		
		String[] typeArr = new String[]{"Deposit", "Withdraw"};
		JComboBox typeInput = new JComboBox(typeArr);
		typeInput.setFont(new Font("Tahoma", Font.PLAIN, 33));
		typeInput.setBounds(527, 203, 935, 49);
		tranPanel.add(typeInput);
		typeInput.setBackground(Color.WHITE);
		
		amountInput = new JTextField();
		amountInput.setFont(new Font("Tahoma", Font.PLAIN, 33));
		amountInput.setColumns(10);
		amountInput.setBounds(527, 284, 935, 49);
		tranPanel.add(amountInput);
		
		JTextArea noteInput = new JTextArea();
		noteInput.setFont(new Font("Courier New", Font.PLAIN, 33));
		noteInput.setBounds(527, 370, 935, 161);
		tranPanel.add(noteInput);
		noteInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					
					try {
						int acc = Integer.parseInt(amountInput.getText());
						System.out.println("acc : "+acc);
					} catch (NumberFormatException e) {
						// TODO
						JOptionPane.showMessageDialog(null, "Account에 숫자를 입력해주세요.");
						return;
					}
					
					boolean fileExists = new File("data/csv/data.csv").exists();
					FileWriter fw = new FileWriter("data/csv/data.csv", true);// false 하면 전에 데이터 지우고 하는거
					if(!fileExists){
						fw.append("Name, Type, Amount, Note\n");
					}
					String name = nameInput.getText();
					String type = (String) typeInput.getSelectedItem();
					String amount = amountInput.getText();
					String note = noteInput.getText();
					fw.append(name + "," + type + "," + amount + "," + note + "\n");
					nameInput.setText("");
					amountInput.setText("");
					typeInput.setSelectedIndex(0);
					noteInput.setText("");
					JOptionPane.showMessageDialog(null, "데이터 작성에 성공 했어요");
					fw.close();
					td.refresh();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "데이터 작성 중 오류가 발생했어요");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnNewButton.setBounds(880, 554, 228, 49);
		tranPanel.add(btnNewButton);
		
		frame.pack();
	}
}
