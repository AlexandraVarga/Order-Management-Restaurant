package bll;

import dao.ClientDAO;
import dao.OrderDAO;
import dao.OrderItemDAO;
import model.Client;
import model.OrderItem;
import model.Orders;

import java.util.List;

public class ClientBLL {

    private ClientDAO clientDAO;
    private OrderItemDAO orderItemDAO;
    private OrderDAO orderDAO;

    public ClientBLL() {
        clientDAO = new ClientDAO();
        orderItemDAO = new OrderItemDAO();
        orderDAO = new OrderDAO();
    }

    /**
     * @param client Clientul care se insereaza
     */
    public void insertClient(Client client) {
        clientDAO.insert(client);
        //System.out.println(client.getName() + " " + client.getAddress());//date client
    }

    public void selectClients() {
        clientDAO.select();
    }

    /**
     * @param client Clientul a carui ID va fi cautat
     * @return ID-ul clientului cautat
     */
    public int findID(Client client) {
        return clientDAO.findID(client);
    }

    /**
     * @param client Clientul care va fi sters din baza de date
     */

    public void deleteClient(Client client) {
        List<OrderItem> orderItemList = orderItemDAO.findAll();
        List<Orders> orderList = orderDAO.findAll();
        Orders toBeDeleted = null;
        int clientID = clientDAO.findID(client);
        int orderID = -1;
        for (Orders o : orderList) {
            if (o.getClientID() == clientID) {
                orderID = orderDAO.findID(o);
                toBeDeleted = o;
                break;
            }
        }
        if (orderID != -1) {
            for (OrderItem oi : orderItemList) {
                if (oi.getOrderID() == orderID)
                    orderItemDAO.delete(oi);
            }
            orderDAO.delete(toBeDeleted);
        }
        clientDAO.delete(client);
    }
}
