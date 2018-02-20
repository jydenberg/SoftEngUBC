package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class Reserves {


    private int prodID;
    private int orderID;
    private int numProd;

    public Reserves(int prodID, int orderID, int numProd) {
        this.prodID = prodID;
        this.orderID = orderID;
        this.numProd = numProd;
    }

    public int getProdID() {
        return this.prodID;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public int getNumProd() {
        return this.numProd;
    }

    private void setProdID(int pid) {
        this.prodID = pid;
    }

    private void setOrderID(int oid) {
        this.orderID = oid;
    }

    private void setNumProd(int numProd) {
        this.numProd = numProd;
    }

}
