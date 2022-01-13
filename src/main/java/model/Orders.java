package model;

public class Orders {
    int clientID;

    public Orders() {
    }

    /**
     * Constructorul clasei Orders
     *
     * @param id ID-ul comenzii
     */
    public Orders(int id) {
        this.clientID = id;
    }

    /**
     * Getter pentru ID-ul clientului
     *
     * @return ID-ul clientului
     */
    public int getClientID() {
        return this.clientID;
    }

    /**
     * Setter pentru ID-ul clientului
     *
     * @param clientID ID-ul clientului
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

}
