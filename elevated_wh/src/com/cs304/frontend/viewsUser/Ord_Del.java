package com.cs304.frontend.viewsUser;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ord_Del extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void New_Del() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ord_Del frame = new Ord_Del();
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
	public Ord_Del() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_selections_user ms = new Main_selections_user();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		btnNewButton_9.setBounds(145, 170, 150,25);
		getContentPane().add(btnNewButton_9);
		
		textField = new JTextField();
		textField.setBounds(220, 47, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(81, 49, 70, 15);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 106, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
