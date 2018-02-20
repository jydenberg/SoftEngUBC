package com.cs304.data_objects;

import java.sql.Date;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class Filled_For {

    private Date dateUpdated;
    private int prodID;
    private int orderID;
    private boolean isShipped;

    public Filled_For(Date dateUpdated, int prodID, int orderID, boolean isShipped) {
        this.dateUpdated = dateUpdated;
        this.prodID = prodID;
        this.orderID = orderID;
        this.isShipped = false;
    }

    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    public int getProdID() {
        return this.prodID;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public boolean getIsShipped() {
        return this.isShipped;
    }


    private void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    private void setProdID(int pid) {
        this.prodID = pid;
    }

    private void setOrderID(int oid) {
        this.orderID = oid;
    }

    private void setIsShipped (boolean is) {
        this.isShipped = is;
    }

}
