package com.cs304.frontend.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pro_Avg_ui extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application
	 */
	public static void New_AVG() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pro_Avg_ui frame = new Pro_Avg_ui();
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
	public Pro_Avg_ui() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Above AVG price");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Avg_Abv matss = new Pro_Avg_Abv();
				setVisible(false);
				dispose();
				matss.New_Lis();
			}
		});
		btnNewButton.setBounds(145, 10, 150, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Below AVG Price");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Avg_Bel prodss = new Pro_Avg_Bel();
				setVisible(false);
				dispose();
				prodss.New_Lis();
			}
		});
		btnNewButton_1.setBounds(145, 55, 150, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Lowest Price");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Avg_Min ordss = new Pro_Avg_Min();
				setVisible(false);
				dispose();
				ordss.New_Lis();
			}
		});
		btnNewButton_2.setBounds(145, 100, 150, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Highest Price");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Avg_Min custss = new Pro_Avg_Min();
				setVisible(false);
				dispose();
				custss.New_Lis();
				
			}
		});

		btnNewButton_3.setBounds(145, 145, 150, 25);
		contentPane.add(btnNewButton_3);


		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});

		btnNewButton_9.setBounds(145, 190, 150, 25);
		contentPane.add(btnNewButton_3);
	
	}
}
