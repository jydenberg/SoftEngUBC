package com.cs304.frontend.views;

import com.cs304.data_managers.ProductDM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pro_Avg_Bel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static DefaultTableModel defaultTableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void New_Lis() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pro_Avg_Bel frame = new Pro_Avg_Bel();
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
	public Pro_Avg_Bel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{145, 0, 150, 0};
		gbl_contentPane.rowHeights = new int[]{170, 25, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		ProductDM pdm = new ProductDM();
		Object[][] results_s = pdm.getProdsCheaperAVG();
		Object finalres[][] = new Object[results_s.length - 1][results_s[0].length];
		int p = 0;
		for( int i = 0; i < results_s.length; ++i)
		{
			if ( i == 0)
				continue;


			int q = 0;
			for( int j = 0; j < results_s[0].length; ++j)
			{


				finalres [p][q] = results_s[i][j];
				++q;
			}

			++p;
		}
		Object[] sa = {"ProID", "Name", "RecID","Price"};
		//DefaultTableModel tableModel = new DefaultTableModel(sa, 0);
		table = new JTable(finalres,sa);
		//table.setModel(DefaultTableModel);
		table.setFillsViewportHeight(true);
		TableColumn column = null;
		for (int i = 0; i < finalres[0].length; i++) {
			column = table.getColumnModel().getColumn(i);

			if (i == 3) column.setPreferredWidth(150); //sport column is bigger
			else {
				column.setPreferredWidth(40);
			}
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);



		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});


/*
		boolean firstflag = true;

		for (int i = 0; i<results_s.length; i++){
			int temp = results_s.length;
			Object [] to_table = new Object[temp];
			for (int j = 0; j<results_s[i].length; j++){
				to_table [j] = results_s[i][j];
			}
			if (firstflag == true);
				else {
				firstflag = false;
				tableModel.addRow(to_table);
			}}
		//System.out.println("Number of cols = " + cols);
*/
		//stable = new JTable(tableModel);



		//System.out.println("Number of rows = " + matrix.length);
		//System.out.println("Number of columns = " + matrix[0].length);








		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_9.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_9.gridx = 1;
		gbc_btnNewButton_9.gridy = 3;
		getContentPane().add(btnNewButton_9, gbc_btnNewButton_9);


	}



}