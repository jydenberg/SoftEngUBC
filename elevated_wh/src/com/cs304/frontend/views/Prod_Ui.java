package com.cs304.frontend.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import static oracle.net.aso.C05.e;

public class Prod_Ui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void New_Pro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prod_Ui frame = new Prod_Ui();
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
	public Prod_Ui() {
		setTitle("Product Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Recipe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Add ms = new Pro_Add();
				setVisible(false);
				dispose();
				ms.New_Add();
			}
		});
		btnNewButton.setBounds(125, 10, 200, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Product Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Inf ms = new Pro_Inf();
				setVisible(false);
				dispose();
				ms.New_Inf();
			}
		});
		btnNewButton_1.setBounds(125, 55, 200, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Stock Product");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Sto ms = new Pro_Sto();
				setVisible(false);
				dispose();
				ms.New_Sto();
			}
		});
		btnNewButton_2.setBounds(125, 100, 200, 25);
		contentPane.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_4 = new JButton("List Products");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Lis ms = new Pro_Lis();
				setVisible(false);
				dispose();
				ms.New_Lis();
			}
		});
		btnNewButton_4.setBounds(125, 145, 200, 25);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_avg = new JButton("Product AVGS");
		btnNewButton_avg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pro_Avg_ui ms = new Pro_Avg_ui();
				setVisible(false);
				dispose();
				ms.New_AVG();
			}
		});
		btnNewButton_avg.setBounds(125, 190, 200, 25);
		contentPane.add(btnNewButton_avg);

		
		JButton btnNewButton_5 = new JButton("Back to Main");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		btnNewButton_5.setBounds(125, 235, 200, 25);
		contentPane.add(btnNewButton_5);
	}

}
