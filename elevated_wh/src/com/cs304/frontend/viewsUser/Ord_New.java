package com.cs304.frontend.viewsUser;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ord_New extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void New_New() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ord_New frame = new Ord_New();
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
	public Ord_New() {
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
	}

}
