package start;

import presentation.ClientGUI;
import presentation.OrderGUI;
import presentation.ProdusGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    private JFrame frame;
    public static boolean b;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu menu = new Menu();
                    menu.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Menu(Boolean b) {
        initialize();
        frame.setVisible(b);
    }

    public Menu() {
        initialize();
    }


    public void initialize() {

        frame = new JFrame("Menu");
        frame.setBounds(100, 100, 400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JButton jcomp1;
        JButton jcomp2;
        JButton jcomp3;

        //construct components
        jcomp1 = new JButton("Client");
        jcomp2 = new JButton("Produs");
        jcomp3 = new JButton("Comanda");

        jcomp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ClientGUI clientGUI = new ClientGUI();
            }

        });

        jcomp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ProdusGUI produsGUI = new ProdusGUI();
            }
        });

        jcomp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                OrderGUI orderGUI = new OrderGUI();
            }
        });

        //adjust size and set layout
        frame.setPreferredSize(new Dimension(375, 266));
        frame.setLayout(null);

        //add components
        frame.add(jcomp1);
        frame.add(jcomp2);
        frame.add(jcomp3);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(125, 45, 130, 30);
        jcomp2.setBounds(125, 100, 130, 30);
        jcomp3.setBounds(125, 160, 130, 30);

    }
}