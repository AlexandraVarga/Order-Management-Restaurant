package model;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewProduct {

    Connection dbConnection = ConnectionFactory.getConnection();

    public String[][] viewProduct() {
        PreparedStatement stmt;
        try {
            stmt = dbConnection.prepareStatement("SELECT * FROM product");
            ResultSet rs = stmt.executeQuery();

            String[][] data = new String[1000][3];
            int i = 0;

            while (rs.next()) {
                Product product = new Product();
                product.setProductName(rs.getString("productName"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getDouble("price"));


                data[i][0] = String.valueOf(product.getProductName());
                data[i][1] = String.valueOf(product.getQuantity());
                data[i][2] = String.valueOf(product.getPrice());

                i++;
            }
            return data;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new String[0][];

    }

    /*public static void main(String[] args) {
        ViewProduct v = new ViewProduct();
        v.viewProduct();
        String [][] data = v.viewProduct();
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