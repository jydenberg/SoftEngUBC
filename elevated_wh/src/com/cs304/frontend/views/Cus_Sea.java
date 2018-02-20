package com.cs304.frontend.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.cs304.data_managers.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

import static javafx.scene.input.KeyCode.R;
import static oracle.net.aso.C09.i;
import static oracle.net.aso.C09.p;
import static oracle.net.aso.C09.q;

public class Cus_Sea extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField1;
	private JTable table;
	private String[][] results_q;

	/**
	 * Launch the application.
	 */
	public static void New_Sea() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cus_Sea frame = new Cus_Sea();
					frame.pack();
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
	public Cus_Sea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
		contentPane.setLayout(new MigLayout("", "[124px][140px][grow]", "[19px][grow][][19px][19px][25px,grow][][25px]"));
		

		
		JLabel lblNewLabel = new JLabel("CID");
		contentPane.add(lblNewLabel, "cell 0 2,alignx right,aligny center");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 2,alignx left,aligny top");
		textField.setColumns(20);
		
    
		
		JLabel lblNewLabel_1 = new JLabel("PHONE");
		contentPane.add(lblNewLabel_1, "cell 0 3,alignx right,aligny center");
		
		textField1 = new JTextField();
		contentPane.add(textField1, "cell 1 3,alignx left,aligny top");
		textField1.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("LAST NAME");
		contentPane.add(lblNewLabel_2, "cell 0 4,alignx right,aligny center");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 4,growx,aligny top");
		textField_1.setColumns(10);



		String[] sa = {"CID", "FNAME", "LNAME", "PHONE"};
		DefaultTableModel tableModel = new DefaultTableModel(sa, 0);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		contentPane.add(scrollPane, "cell 2 0 1 8,grow");

		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDM cdm = new CustomerDM();

				final Object [] [] results_q = cdm.findCxByIdOrPhoneNumber(textField.getText(), textField_1.getText(), textField1.getText());
				while (tableModel.getRowCount() != 0)
					tableModel.removeRow(0);
				for( int i = 1; i < results_q.length; ++i)
				{

					tableModel.addRow(results_q[i]);
				}


			}
		});
		contentPane.add(btnNewButton, "cell 1 5,alignx left,aligny top");
		
		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		getContentPane().add(btnNewButton_9, "cell 1 6,alignx left,aligny top");
		
		Object[] data = {"position", "name", "points", "wins"};





	}

}
