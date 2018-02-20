package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class Placed_For {

    private int orderID;
    private int custID;

    public Placed_For(int orderID, int custID) {
        this.orderID = orderID;
        this.custID = custID;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public int getCustID() {
        return this.custID;
    }

    private void setOrderID(int oID) {
        this.orderID = oID;
    }

    private void setCustID(int cID) {
        this.custID = cID;
    }

}
