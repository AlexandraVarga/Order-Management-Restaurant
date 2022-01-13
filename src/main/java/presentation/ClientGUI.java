package presentation;

import bll.ClientBLL;
import model.Client;
import start.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JPanel {

    private JTextField jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JTextField jcomp5;
    private JButton jcomp6;
    private JButton jcomp7;
    private JButton jcomp8;
    private JButton jcomp9;
    private JButton jcomp10;
    private JFrame frame = new JFrame("ClientGUI");

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ClientGUI clientGUI = new ClientGUI();
//                    clientGUI.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    public ClientGUI() {
        initialize();
    }

    public void initialize() {

        frame = new JFrame("ClientGUI");
        frame.setBounds(100, 100, 300, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        //construct components
        jcomp1 = new JTextField(5);//nume
        jcomp2 = new JLabel("CLIENT");
        jcomp3 = new JLabel("Nume");
        jcomp4 = new JLabel("Adresa");
        jcomp5 = new JTextField(5);//adresa
        jcomp6 = new JButton("Adaugare Client");
        jcomp7 = new JButton("Stergere Client");
        jcomp8 = new JButton("Vizualizare Clienti");
        jcomp9 = new JButton("Editare Client");
        jcomp10 = new JButton("Inapoi la Meniu");

        ///BUTON ADAUGARE CLIENT BAZA DE DATE
        jcomp6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (jcomp1.getText() != " " && jcomp5.getText() != "") {
                    ClientBLL clientBLL = new ClientBLL();
                    Client client = new Client(jcomp1.getText(), jcomp5.getText());
                    clientBLL.insertClient(client);
                }
            }
        });
        ///BUTON STERGERE CLIENT
        jcomp7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (jcomp1.getText() != "" && jcomp5.getText() != "") {
                    ClientBLL clientBLL = new ClientBLL();
                    Client client = new Client(jcomp1.getText(), jcomp5.getText());
                    clientBLL.deleteClient(client);
                }
            }
        });
        ///BUTON BACK MENIU
        jcomp10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu menu = new Menu(true);
            }
        });

        ///VIZUALIZARE CLIENTI
        jcomp8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                RaportClient raportClient = new RaportClient();
            }
        });


        //adjust size and set layout
        frame.setPreferredSize(new Dimension(285, 372));
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

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(105, 90, 130, 20);
        jcomp2.setBounds(110, 30, 115, 35);
        jcomp3.setBounds(35, 90, 100, 25);
        jcomp4.setBounds(35, 115, 100, 25);
        jcomp5.setBounds(105, 120, 130, 20);
        jcomp6.setBounds(60, 180, 160, 25);
        jcomp7.setBounds(60, 255, 160, 25);
        jcomp8.setBounds(60, 290, 160, 25);
        jcomp9.setBounds(60, 215, 160, 25);
        jcomp10.setBounds(60, 325, 160, 25);
    }

}
