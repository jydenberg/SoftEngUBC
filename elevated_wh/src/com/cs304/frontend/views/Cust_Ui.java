package com.cs304.frontend.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import static oracle.net.aso.C05.e;

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
		
		JButton btnNewButton_1 = new JButton("Search For Customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cus_Sea ms = new Cus_Sea();
				setVisible(false);
				dispose();
				ms.New_Sea();
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

		JButton allprodbutt = new JButton("List All Prod Customers");
		allprodbutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cus_Lis_Div ms = new Cus_Lis_Div();
				setVisible(false);
				dispose();
				ms.New_Lis();
			}
		});
		allprodbutt.setBounds(125, 170, 200, 25);
		contentPane.add(allprodbutt);

		
	
		
		JButton btnNewButton_3 = new JButton("Back to Main");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		btnNewButton_3.setBounds(125, 220, 200, 25);
		contentPane.add(btnNewButton_3);
	}

}
