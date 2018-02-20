package com.cs304.frontend.views;

import com.cs304.data_managers.FilledForDM;
import com.cs304.data_managers.MaterialDM;
import com.cs304.frontend.Error_Pop;
import com.cs304.frontend.Success_Pop;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ord_Del extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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

		int pnum;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Order ID");
		contentPane.add(lblNewLabel_3, "cell 0 0,alignx right");

		JButton ord_pop = new JButton("Find ORDERID");
		ord_pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			Pop_o_c poc = new Pop_o_c();
				poc.New_Pop();
			}
		});

		JButton res_pop = new JButton("FIND PRODUCT ID");
		res_pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Pop_Pro pp = new Pop_Pro();
				pp.New_Pop();
			}
		});
		getContentPane().add(ord_pop, "cell 1 3,alignx left,aligny top");
		getContentPane().add(res_pop, "cell 2 3,alignx left,aligny top");

		textField = new JTextField();
		contentPane.add(textField, "cell 1 0 2 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Product ID");
		contentPane.add(lblNewLabel_2, "cell 0 1,alignx right");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 1 2 1,growx");
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Quantity");
		contentPane.add(lblNewLabel_4, "cell 0 2,alignx right");

		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 2 2 1,growx");
		textField_2.setColumns(10);
		

		

		
		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		
		
		JButton btnNewButton_8 = new JButton("Fill Order");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			MaterialDM cdm = new MaterialDM();
			if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals(""))
			{
				Error_Pop ep = new Error_Pop();
				ep.New_Pop();
				
			}	
			else
			{
				final String orderID = textField.getText().toString();
				final String prodID = textField_1.getText().toString();
				final String quantity = textField_2.getText().toString();

				int pnum;
				FilledForDM ffdm = new FilledForDM();
				ffdm.insertNewFilledFor(orderID, prodID, quantity , "0");
				Success_Pop sp = new Success_Pop();
				sp.New_Pop();
			}
		}});
		getContentPane().add(btnNewButton_8, "cell 1 6,growx,aligny top");
		getContentPane().add(btnNewButton_9, "cell 2 6,growx,aligny top");
		
		
		
	}

}
