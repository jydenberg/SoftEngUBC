package com.cs304.frontend.views;

import com.cs304.data_managers.CustOrderDM;
import com.cs304.data_managers.MaterialDM;
import com.cs304.frontend.Error_Pop;
import com.cs304.frontend.Success_Pop;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ord_Shi extends JFrame {

    public Ord_Shi this_frame = this;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;


    /**
     * Launch the application.
     */
    public static void New_Shi() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ord_Shi frame = new Ord_Shi();
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
    public Ord_Shi(){

        int pnum;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[50px][][][][][grow]", "[25px][25px][][][][][][][][]"));

        JLabel lblNewLabel_3 = new JLabel("Order ID");
        contentPane.add(lblNewLabel_3, "cell 0 0,alignx left");

        textField = new JTextField();
        contentPane.add(textField, "cell 1 0 2 1,growx");
        textField.setColumns(10);


        JButton ord_sell_btn = new JButton("Find Order ID");
        ord_sell_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

               Pop_o_c po = new Pop_o_c();
                po.New_Pop();
                /*CustOrderDM cdm = new CustOrderDM();
                String[][] results_s = cdm.getAllPlacedFor();

                String finalres[][] = new String[results_s.length - 1][results_s[0].length];
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
                String[] sa = {"OID","CID"};
                po.New_Pop(this_frame);
                */



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


        JButton btnNewButton_8 = new JButton("Ship Order");
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CustOrderDM cdm = new CustOrderDM();
                if (textField.getText().equals(""))
                {
                    Error_Pop ep = new Error_Pop();
                    ep.New_Pop();

                }
                else
                {
                    final String ORID = textField.getText().toString();



                    cdm.shipOrder(ORID);

                    Success_Pop sp = new Success_Pop();

                }
            }});
        getContentPane().add(btnNewButton_8, "cell 1 4,alignx left,aligny top");
        getContentPane().add(btnNewButton_9, "cell 2 4,alignx left,aligny top");



    }




}