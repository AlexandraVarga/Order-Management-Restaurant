package presentation;

import connection.ConnectionFactory;
import model.ViewClient;

import javax.swing.*;
import java.sql.Connection;

public class RaportClient {
    Connection dbConnection = ConnectionFactory.getConnection();
    // frame
    private JFrame frame;
    // Table
    private JTable table;

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RaportClient window = new RaportClient();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
    public RaportClient() {
        initialize();
    }

    private void initialize() {
        // Frame initiallization
        frame = new JFrame();
        frame.setLocationRelativeTo(null);

        // Frame Title
        frame.setTitle("Raport Clienti");

        // Data to be displayed in the JTable

        ViewClient v = new ViewClient();
        //v.viewClient();
        String[][] data = v.viewClient();

        // Column Names
        String[] columnNames = {"Nume", "Adresa"};

        // Initializing the JTable
        table = new JTable(data, columnNames);
        table.setBounds(100, 100, 500, 500);


        // adding it to JScrollPane
        JScrollPane jScrollPane = new JScrollPane(table);
        frame.add(jScrollPane);
        // Frame Size
        frame.setSize(847, 600);
        // Frame Visible = true
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
