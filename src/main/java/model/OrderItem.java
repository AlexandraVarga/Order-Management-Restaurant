package model;

public class OrderItem {

    int productID;
    int productQuantity;
    int orderID;

    /**
     * Constructorul default al clasei OrderItem
     */
    public OrderItem() {

    }

    /**
     * Construcotrul clasei OrderItem
     *
     * @param productID       ID-ul produsului comandat
     * @param productQuantity Cantitatea comandata
     * @param orderID         Numarul comenzii din care face parte produsul
     */
    public OrderItem(int productID, int productQuantity, int orderID) {
        this.productID = productID;
        this.productQuantity = productQuantity;
        this.orderID = orderID;
    }

    /**
     * Getter pentru ID-ul produsului
     *
     * @return ID-ul produsului
     */
    public int getProductID() {
        return this.productID;
    }

    /**
     * Setter pentru ID-ul produsului
     *
     * @param productID ID-ul produsului
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Getter pentru cantitatea produsului
     *
     * @return Cantitatea produsului
     */
    public int getProductQuantity() {
        return this.productQuantity;
    }

    /**
     * Setter pentru cantitatea produsului
     *
     * @param productQuantity Cantitatea produsului
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * Getter pentru numarul comenzii
     *
     * @return Numarul comenzii
     */
    public int getOrderID() {
        return this.orderID;
    }

    /**
     * Setter pentru numarul comenzii
     *
     * @param orderID Numarul comenzii
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
