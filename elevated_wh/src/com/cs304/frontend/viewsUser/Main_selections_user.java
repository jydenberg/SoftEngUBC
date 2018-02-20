package com.cs304.frontend.viewsUser;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main_selections_user extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application
	 */
	public static void New_Window() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_selections_user frame = new Main_selections_user();
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
	public Main_selections_user() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("MATERIALS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mater_Ui matss = new Mater_Ui();
				setVisible(false);
				dispose();
				matss.New_Mat();
			}
		});
		btnNewButton.setBounds(145, 10, 150, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PRODUCTS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prod_Ui prodss = new Prod_Ui();
				setVisible(false);
				dispose();
				prodss.New_Pro();
			}
		});
		btnNewButton_1.setBounds(145, 55, 150, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ORDERS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order_Ui ordss = new Order_Ui();
				setVisible(false);
				dispose();
				ordss.New_Ord();
			}
		});
		btnNewButton_2.setBounds(145, 100, 150, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CUSTOMER");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cust_Ui custss = new Cust_Ui();
				setVisible(false);
				dispose();
				custss.New_Cus();
				
			}
		});
		btnNewButton_3.setBounds(145, 145, 150, 25);
		contentPane.add(btnNewButton_3);
		
	
	}
}
