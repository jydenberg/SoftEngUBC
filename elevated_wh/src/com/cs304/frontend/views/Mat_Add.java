package com.cs304.frontend.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.cs304.data_managers.MaterialDM;
import com.cs304.frontend.Error_Pop;
import com.cs304.frontend.Success_Pop;

import net.miginfocom.swing.MigLayout;

public class Mat_Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void New_Add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mat_Add frame = new Mat_Add();
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
	public Mat_Add() {

		int pnum;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150px][grow][][][][]", "[25px][25px][][][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Material name");
		contentPane.add(lblNewLabel_3, "cell 0 2,alignx right");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 2 2 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Stock");
		contentPane.add(lblNewLabel_2, "cell 0 3,alignx right");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 3 2 1,growx");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 4 2 1,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		contentPane.add(lblNewLabel_4, "cell 0 4,alignx right");
		
		JLabel lblNewLabel_1 = new JLabel("Unit");
		contentPane.add(lblNewLabel_1, "cell 0 5,alignx right");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 5 2 1,growx");
		textField_3.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		
		
		JButton btnNewButton_8 = new JButton("Add Material");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			MaterialDM cdm = new MaterialDM();
			if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals(""))
			{
				Error_Pop ep = new Error_Pop();
				ep.New_Pop();
				
			}	
			else
			{
				final String Mname = textField.getText().toString();
				final String Stock = textField_1.getText().toString();
				final String Unit = textField_2.getText().toString();
				final String Price = textField_3.getText().toString();

				int pnum;
				MaterialDM mdm = new MaterialDM();
				mdm.insertNewMaterial(Mname , Stock, Price , Unit);
				Success_Pop sp = new Success_Pop();
				sp.New_Pop();
			}
		}});
		getContentPane().add(btnNewButton_8, "cell 1 7,growx,aligny top");
		getContentPane().add(btnNewButton_9, "cell 2 7,growx,aligny top");
		
		
		
	}

}
