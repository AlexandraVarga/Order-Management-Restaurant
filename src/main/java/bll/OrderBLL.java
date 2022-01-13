package bll;

import dao.ClientDAO;
import dao.OrderDAO;
import dao.OrderItemDAO;
import model.Client;
import model.OrderItem;
import model.Orders;
import model.Product;

import java.io.FileWriter;
import java.io.IOException;

public class OrderBLL {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private ClientDAO clientDAO;
    private ProductBLL productBLL;
    private ClientBLL clientBLL;

    public OrderBLL() {
        orderDAO = new OrderDAO();
        orderItemDAO = new OrderItemDAO();
        clientDAO = new ClientDAO();
        productBLL = new ProductBLL();
        clientBLL = new ClientBLL();
    }

    /**
     * @param client          Clientul care face o comanda
     * @param product         Produsul pe care un client il comanda
     * @param productQuantity Cantitatea de produs comandata
     */

    public void insertOrder(Client client, Product product, int productQuantity) {
        try {
            FileWriter myWriter = new FileWriter("BILL.txt");

            Orders order = new Orders(clientDAO.findID(client));
            int orderID = orderDAO.findID(order);
            int productID = productBLL.findID(product);
            if (productID != -1) {
                Product existingProduct = productBLL.getProduct(productID);
                if (orderID == -1) {
                    if (existingProduct.getQuantity() > productQuantity) {
                        orderDAO.insert(order);
                        orderID = orderDAO.findID(order);
                        OrderItem orderItem = new OrderItem(productID, productQuantity, orderID);
                        orderItemDAO.insert(orderItem);
                        productBLL.updateProduct(existingProduct, productQuantity);
                        ///BILL
                        myWriter.write("Client: "+ client.getName() + "\n" +"Adresa: "+ client.getAddress() + "\n" + "Produs: "+ product.getProductName() + "\n" +"Pret: "+ product.getPrice() + "\n" +"Cantitate: "+ product.getQuantity() + "\n");
                        myWriter.write("Pret total: " + product.getPrice() * (double) product.getQuantity());
                    }
                } else {
                    OrderItem orderItem = new OrderItem(productID, productQuantity, orderID);
                    if (productBLL.updateProduct(existingProduct, productQuantity) == 1) {
                        int orderItemID = orderItemDAO.findID(orderItem);
                        if (orderItemID == -1) {
                            {
                                orderItemDAO.insert(orderItem);
                                ///BILL
                                //myWriter.write(client.getName() + " " + client.getAddress() + " " + product.getProductName() + " " + product.getPrice() + " " + product.getQuantity() + "\n");
                                myWriter.write("Client: "+ client.getName() + "\n" +"Adresa: "+ client.getAddress() + "\n" + "Produs: "+ product.getProductName() + "\n" +"Pret: "+ product.getPrice() + "\n" +"Cantitate: "+ product.getQuantity() + "\n");
                                myWriter.write("Pret total: " + product.getPrice() * (double) product.getQuantity());
                            }
                        } else {
                            OrderItem existingOrderItem = orderItemDAO.findById(orderItemID);
                            existingOrderItem.setProductQuantity(productQuantity + existingOrderItem.getProductQuantity());
                            orderItemDAO.update(existingOrderItem, String.valueOf(orderItemID));
                            ///BILL
                            //myWriter.write(client.getName() + " " + client.getAddress() + " " + product.getProductName() + " " + product.getPrice() + " " + product.getQuantity() + "\n");
                            myWriter.write("Client: "+ client.getName() + "\n" +"Adresa: "+ client.getAddress() + "\n" + "Produs: "+ product.getProductName() + "\n" +"Pret: "+ product.getPrice() + "\n" +"Cantitate: "+ product.getQuantity() + "\n");
                            myWriter.write("Pret total: " + product.getPrice() * (double) product.getQuantity());
                        }
                    }
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * @param client Clientul a carui numar de comanda se gaseste
     * @return Numarul comenzii
     */
    public int findOrderID(Client client) {
        return orderDAO.findID(new Orders(clientDAO.findID(client)));
    }
}
