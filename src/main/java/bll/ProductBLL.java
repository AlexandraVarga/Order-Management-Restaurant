package bll;

import dao.OrderItemDAO;
import dao.ProductDAO;
import model.OrderItem;
import model.Product;

import java.util.List;

public class ProductBLL {

    private ProductDAO productDAO;
    private OrderItemDAO orderItemDAO;

    public ProductBLL() {
        this.productDAO = new ProductDAO();
        this.orderItemDAO = new OrderItemDAO();
    }

    /**
     * @param product Produsul care se insereaza
     */

    public void insertProduct(Product product) {
        int productID = productDAO.findID(product);
        if (productID != -1) {
            Product updatedProduct = productDAO.findById(productID);
            updatedProduct.setQuantity(updatedProduct.getQuantity() + product.getQuantity());
            productDAO.update(updatedProduct, updatedProduct.getProductName());
        } else {
            productDAO.insert(product);
            System.out.println(product.getProductName() + " " + product.getPrice() + "" + product);
        }
    }

    /**
     * @param product Produsul a carui ID va fi cautat
     * @return ID-ul produsului cautat
     */
    public int findID(Product product) {
        return productDAO.findID(product);
    }

    /**
     * @param id ID-ul produsului care se cauta
     * @return Produsul din baza de date
     */
    public Product getProduct(int id) {
        return productDAO.findById(id);
    }

    /**
     * @param product Product care va fi sters din baza de date
     */

    public void deleteProduct(Product product) {
        List<OrderItem> orderItemList = orderItemDAO.findAll();
        int productID = productDAO.findID(product);
        for (OrderItem oi : orderItemList) {
            if (oi.getProductID() == productID) {
                orderItemDAO.delete(oi);
                break;
            }
        }
        productDAO.delete(product);
    }

    /**
     * @param product                Produsul comandat
     * @param productOrderedQuantity Cantitatea produsului comandat
     * @return -1 daca cantitatea produsului nu este suficienta, 1 altfel
     */
    public int updateProduct(Product product, int productOrderedQuantity) {
        if (product.getQuantity() < productOrderedQuantity) {
            System.out.println("Insufficient quantity");
            return -1;
        } else {
            Product updatedProduct = new Product(product.getProductName(),
                    product.getQuantity() - productOrderedQuantity, product.getPrice());
            productDAO.update(updatedProduct, updatedProduct.getProductName());
            return 1;
        }
    }
}

