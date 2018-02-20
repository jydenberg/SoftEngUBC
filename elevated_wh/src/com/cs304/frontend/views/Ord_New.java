package com.cs304.frontend.views;

import com.cs304.data_managers.MaterialDM;
import com.cs304.frontend.Error_Pop;
import com.cs304.frontend.Success_Pop;
import net.miginfocom.swing.MigLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ord_New extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


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
	public Ord_New(){

		int pnum;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[50px][][][][][grow]", "[25px][25px][][][][][][][][]"));

		JLabel lblNewLabel_3 = new JLabel("Customer ID");
		contentPane.add(lblNewLabel_3, "cell 0 0,alignx left");

		textField = new JTextField();
		contentPane.add(textField, "cell 1 0 2 1,growx");
		textField.setColumns(10);


		JButton ord_sell_btn = new JButton("Find CustID");
		ord_sell_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Pop_Cus pc = new Pop_Cus();
				pc.New_Pop();
			}
		});
		getContentPane().add(ord_sell_btn, "cell 1 1,alignx left,aligny top");

		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});


		JButton btnNewButton_8 = new JButton("Create Order");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MaterialDM cdm = new MaterialDM();
				if (textField.getText().equals(""))
				{
					Error_Pop ep = new Error_Pop();
					ep.New_Pop();

				}
				else
				{
					final String ORID = textField.getText().toString();



					// ADD CODE HERE THAT ACTUALY ENTERS ORDERS INTO ORDER AND CUSTOMER***

					Success_Pop sp = new Success_Pop();
					sp.New_Pop();
				}
			}});
		getContentPane().add(btnNewButton_8, "cell 1 4,alignx left,aligny top");
		getContentPane().add(btnNewButton_9, "cell 2 4,alignx left,aligny top");



	}

}