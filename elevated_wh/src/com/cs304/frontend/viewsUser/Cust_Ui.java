package com.cs304.frontend.viewsUser;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Cust_Ui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void New_Cus() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cust_Ui frame = new Cust_Ui();
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
	public Cust_Ui() {
		setTitle("Customer Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cus_Add ms = new Cus_Add();
				setVisible(false);
				dispose();
				ms.New_Add();
			}
		});
		btnNewButton.setBounds(125, 20, 200, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove Customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cus_Rem ms = new Cus_Rem();
				setVisible(false);
				dispose();
				ms.New_Rem();
			}
		});
		btnNewButton_1.setBounds(125, 70, 200, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("List Customer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cus_Lis ms = new Cus_Lis();
				setVisible(false);
				dispose();
				ms.New_Lis();
			}
		});
		btnNewButton_2.setBounds(125, 120, 200, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Get Cust Info");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cus_Inf cf = new Cus_Inf();
				setVisible(false);
				dispose();
				cf.New_Inf();
			}
		});
		btnNewButton_4.setBounds(125, 120, 200, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Back to Main");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_selections_user ms = new Main_selections_user();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		btnNewButton_3.setBounds(125, 170, 200, 25);
		contentPane.add(btnNewButton_3);
	}

}
