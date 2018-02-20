package com.cs304.frontend.viewsUser;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Mater_Ui extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void New_Mat() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mater_Ui frame = new Mater_Ui();
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
	public Mater_Ui() {
		setTitle("Material Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Material");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mat_Add ma = new Mat_Add();
				setVisible(false);
				dispose();
				ma.New_Add();
			}
		});
		btnNewButton.setBounds(145, 20, 150, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rem Material");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mat_Rem mr = new Mat_Rem();
				setVisible(false);
				dispose();
				mr.New_Rem();
			}
		});
		btnNewButton_1.setBounds(145, 70, 150, 25);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back to Main");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_selections_user ms = new Main_selections_user();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		btnNewButton_2.setBounds(145, 170, 150,25);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("List Materials");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mat_Lis ms = new Mat_Lis();
				setVisible(false);
				dispose();
				ms.New_Lis();
			}
		});
		btnNewButton_3.setBounds(145, 120, 150, 25);
		getContentPane().add(btnNewButton_3);
	}

}
