package com.cs304.frontend.views;

import com.cs304.data_managers.CustOrderDM;
import com.cs304.data_managers.ProductDM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.*;

public class Pop_Pro extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void New_Pop() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pop_Pro frame = new Pop_Pro();
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
    public Pop_Pro() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 450, 350);
        setResizable(false);
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
        Object[][] results_s = pdm.listAllProducts();

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
        Object[] sa = {"Stock", "Price", "PID", "Name", "Size", "Unit"};
        //DefaultTableModel tableModel = new DefaultTableModel(sa, 0);
        table = new JTable(finalres, sa);
        TableColumn column = null;
        for (int i = 0; i < finalres[0].length; i++) {
            column = table.getColumnModel().getColumn(i);

            if (i == 3) column.setPreferredWidth(150); //sport column is bigger
             else {
                column.setPreferredWidth(40);
            }
        }
        //table.setModel(DefaultTableModel);
        table.setFillsViewportHeight(true);
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


        JButton btnNewButton_9 = new JButton("Close List");
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                setVisible(false);
                dispose();

            }
        });




        GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
        gbc_btnNewButton_9.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_9.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_9.gridx = 1;
        gbc_btnNewButton_9.gridy = 3;
        getContentPane().add(btnNewButton_9, gbc_btnNewButton_9);


    }


}