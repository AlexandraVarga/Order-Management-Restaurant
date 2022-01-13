package model;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewClient {

    Connection dbConnection = ConnectionFactory.getConnection();

    public String[][] viewClient() {
        PreparedStatement stmt;
        try {
            stmt = dbConnection.prepareStatement("SELECT * FROM client");
            ResultSet rs = stmt.executeQuery();

            String[][] data = new String[1000][2];
            int i = 0;

            while (rs.next()) {
                Client client = new Client();
                client.setName(rs.getString("name"));
                client.setAddress(rs.getString("address"));

                data[i][0] = String.valueOf(client.getName());
                data[i][1] = String.valueOf(client.getAddress());

                i++;
            }
            return data;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new String[0][];

    }

    /*public static void main(String[] args) {
        ViewClient v = new ViewClient();
        v.viewClient();
        String [][] data = v.viewClient();
        int ok=0;
        for(int i=0;i<1000;i++)
        {
            for (int j=0;j<2;j++)
            {
                if(data[i][j]!=null)
                {
                    System.out.print(data[i][j]+" ");
                }
                else {
                    ok=1;
                    break;
                }
            }
            if(ok==1)
                break;
            System.out.print("\n");
        }
    }*/
}