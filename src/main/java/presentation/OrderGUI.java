package presentation;

import bll.OrderBLL;
import model.Client;
import model.Product;
import start.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderGUI {

    private JTextField jcomp1;//nume
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JTextField jcomp4;//adresa
    private JButton jcomp5;
    private JButton jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JTextField jcomp10;//nume produs
    private JTextField jcomp11;//pret
    private JTextField jcomp12;//cantitate
    private JLabel jcomp13;
    private JFrame frame;

    //    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    OrderGUI orderGUI = new OrderGUI();
//                    orderGUI.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
    public OrderGUI() {
        initialize();
    }

    public void initialize() {

        frame = new JFrame("OrderGUI");
        frame.setBounds(100, 100, 600, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        //construct components
        jcomp1 = new JTextField(5);
        jcomp2 = new JLabel("Nume Client");
        jcomp3 = new JLabel("Adresa");
        jcomp4 = new JTextField(5);
        jcomp5 = new JButton("Comanda acum!");
        jcomp6 = new JButton("Inapoi la Meniu");
        jcomp7 = new JLabel("Nume Produs");
        jcomp8 = new JLabel("Cantitate");
        jcomp9 = new JLabel("Pret");
        jcomp10 = new JTextField(5);
        jcomp11 = new JTextField(5);
        jcomp12 = new JTextField(5);
        jcomp13 = new JLabel("COMANDA");

        jcomp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jcomp1.getText() != "" && jcomp4.getText() != "" && jcomp10.getText() != "" && jcomp11.getText() != "" && jcomp12.getText() != "") {
                    OrderBLL orderBLL = new OrderBLL();
                    Client client = new Client(jcomp1.getText(), jcomp4.getText());
                    Product product = new Product(jcomp10.getText(), Integer.parseInt(jcomp12.getText()), Double.parseDouble(jcomp11.getText()));
                    orderBLL.insertOrder(client, product, Integer.parseInt(jcomp12.getText()));
                }
            }
        });

        jcomp6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu menu = new Menu(true);
            }
        });

        //adjust size and set layout
        frame.setPreferredSize(new Dimension(621, 299));
        frame.setLayout(null);

        //add components
        frame.add(jcomp1);
        frame.add(jcomp2);
        frame.add(jcomp3);
        frame.add(jcomp4);
        frame.add(jcomp5);
        frame.add(jcomp6);
        frame.add(jcomp7);
        frame.add(jcomp8);
        frame.add(jcomp9);
        frame.add(jcomp10);
        frame.add(jcomp11);
        frame.add(jcomp12);
        frame.add(jcomp13);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(110, 95, 120, 25);
        jcomp2.setBounds(25, 95, 100, 25);
        jcomp3.setBounds(25, 135, 100, 25);
        jcomp4.setBounds(110, 135, 120, 25);
        jcomp5.setBounds(210, 200, 160, 25);
        jcomp6.setBounds(210, 245, 160, 25);
        jcomp7.setBounds(275, 90, 100, 25);
        jcomp8.setBounds(520, 85, 100, 25);
        jcomp9.setBounds(315, 130, 100, 25);
        jcomp10.setBounds(380, 95, 100, 25);
        jcomp11.setBounds(380, 135, 100, 25);
        jcomp12.setBounds(525, 125, 45, 35);
        jcomp13.setBounds(260, 20, 100, 25);
    }

}
