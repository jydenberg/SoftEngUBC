package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class Build_Product {

    private int productID;
    private int orderID;

    public Build_Product(int productID, int orderID) {
        this.productID = productID;
        this.orderID = orderID;
    }

    public int getProductID() {
        return this.productID;
    }

    public int getOrderID() {
        return this.orderID;
    }

    private void setProductID(int pid) {
        this.productID = pid;
    }

    private void setOrderID(int oid) {
        this.orderID = oid;
    }

}
