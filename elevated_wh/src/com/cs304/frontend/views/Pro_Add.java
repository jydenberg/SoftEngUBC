package com.cs304.frontend.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cs304.data_managers.MaterialDM;
import com.cs304.data_managers.ProductDM;
import com.cs304.data_managers.RecipeDM;
import com.cs304.data_managers.RecipeUsesDM;

import com.cs304.data_objects.Recipe;
import com.cs304.frontend.Error_Pop;
import net.miginfocom.swing.MigLayout;

import static javafx.scene.input.KeyCode.R;
import static oracle.net.aso.C09.i;
import static oracle.net.aso.C09.t;

public class Pro_Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JLabel lblRecipe;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;


	/**
	 * @wbp.nonvisual location=462,17
	 */
	private JPanel popup_panel;


	/**
	 * Launch the application.
	 */
	public static void New_Add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pro_Add frame = new Pro_Add();
					frame.setVisible(true);
					frame.setTitle("New Recipe");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pro_Add() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		setResizable(false);
		popup_panel = new JPanel();
		popup_panel.setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[70px][114px][][138px][][][][]", "[][19px][][19px][19px][19px][][][][164px][][][][][][][][]"));



		JLabel lblNewLabel = new JLabel("Name");
		contentPane.add(lblNewLabel, "cell 0 1,alignx right,aligny center");

		textField = new JTextField();
		contentPane.add(textField, "flowx,cell 1 1 3 1,alignx left,aligny center");
		textField.setColumns(10);

		JTextField textField13 = new JTextField();
		textField13.setColumns(10);
		contentPane.add(textField13, "cell 3 1 3 1,alignx left,aligny center");

		JTextField textField14 = new JTextField();
		textField14.setColumns(10);
		contentPane.add(textField14, "cell 3 3 3 1,alignx left,aligny center");

/*
		JTextField textField15 = new JTextField();
		textField15.setColumns(10);
		contentPane.add(textField15, "cell 3 5 3 1,alignx left,aligny center");
*/
		JLabel lblNewLabel_3 = new JLabel("Procedure");
		contentPane.add(lblNewLabel_3, "cell 0 3,alignx center,aligny center");

		textField_2 = new JTextField();
		contentPane.add(textField_2, "flowx,cell 1 3 3 1,alignx left,growy");
		textField_2.setColumns(10);

		String[] sa = {"MAT ID", "MAT NAME", "QUANTITY"};
		DefaultTableModel tableModel = new DefaultTableModel(sa, 0);

		JLabel lblNewLabel_1 = new JLabel("Size");
		contentPane.add(lblNewLabel_1, "cell 0 5,alignx right,aligny center");

		JTextField priceField = new JTextField();
		contentPane.add(priceField, "flowx,cell 1 0 3 1,alignx left,aligny center");
		priceField.setColumns(10);

		JLabel pricelbl = new JLabel("price");
		contentPane.add(pricelbl, "cell 0 0,alignx right,aligny center");

		textField_1 = new JTextField();
		contentPane.add(textField_1, "flowx,cell 1 5 3 1,alignx left,aligny center");
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("unit");
		contentPane.add(lblNewLabel_2, "cell 0 6,alignx right,aligny center");

		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 6 3 1,alignx left,aligny center");
		textField_3.setColumns(10);

		JButton btnNewButton_3 = new JButton("Materials List");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pop_Pro pm = new Pop_Pro();
				Pop_Pro.New_Pop();

			}
		});
		contentPane.add(btnNewButton_3, "cell 3 6,alignx left,growy");

		JButton btnNewButton_2 = new JButton("Add Material");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField13.getText() == "" || textField14.getText() == "") {
					Error_Pop ep = new Error_Pop();
					ep.New_Pop();
				} else {
					final String a1 = textField13.getText();
					final String a2 = textField14.getText();
					//final String a3 = textField15.getText();
					MaterialDM mdm = new MaterialDM();
					String [][] results_s = mdm.getNamefromID(textField13.getText());
					// code to add material to list
					final String nameres = results_s[1][0];
					tableModel.addRow(new Object[] {a1,nameres,a2});

				}
			}
		});

		JButton btnNewButton_1 = new JButton("Submit Product");
		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});


		contentPane.add(btnNewButton_1, "cell 1 7,alignx left");
		contentPane.add(btnNewButton_2, "cell 3 7,alignx left,growy");
		contentPane.add(btnNewButton_9, "cell 2 7,alignx left,growy");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		//textField = name
		//
		table = new JTable(tableModel);

		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, "cell 0 9 5 9,grow");


		JLabel lblNewLabel_5_1 = new JLabel("Quantity");
		contentPane.add(lblNewLabel_5_1, "cell 2 3");

		lblNewLabel_4 = new JLabel("MatID");
		contentPane.add(lblNewLabel_4, "cell 2 1");

/*
		JLabel lblNewLabel_11 = new JLabel("Unit");
		contentPane.add(lblNewLabel_11, "cell 2 5");
*/
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rows = table.getRowCount();
				int cols = table.getColumnCount();
				ProductDM pdm = new ProductDM();

					//pdm.addNewProductToWarehouse(textField.getText(),textField_1.getText(), textField_2.getText(),textField_3.getText());
				String [][] results = new String[rows][cols];
				/*} catch (InvalidFormEntryExeption e) {
					// Totally hypothetical query
					//TODO: actually implement this
					errorbox.pop(e.message);
				}*/

				// need product - recipe join querry here
				for (int i=0; i < rows;i++)
				{
					String a = tableModel.getValueAt(i,0).toString();
					String b = tableModel.getValueAt(i,1).toString();
					String c = tableModel.getValueAt(i,2).toString();
					//String d = tableModel.getValueAt(i,3).toString();
					results[i][0] = a;
					results[i][1] = b;
					results[i][2] = c;
					//results[i][3] = d;
					// add to recipe uses here
				}

				pdm.addNewProductToWarehouse(textField.getText(), textField_1.getText(), textField_3.getText(),priceField.getText(), textField.getText() , textField_2.getText(),results);
				}
		});
	}
}
			


			
		

		
