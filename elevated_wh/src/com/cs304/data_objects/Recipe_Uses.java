package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class Recipe_Uses {

    private int recID;
    private int matID;
    private int quantity;
    private String recUnit;


    public Recipe_Uses(int recID, int matID, int quantity) {
        this.recID = recID;
        this.matID = matID;
        this.quantity = quantity;
    }

    public int getRecID() {
        return this.recID;
    }

    public int getMatID() {
        return this.matID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    private void setRecID(int rid) {
        this.recID = rid;
    }

    private void setMatID(int mid) {
        this.matID = mid;
    }

    private void setQuantity(int q) {
        this.quantity = q;
    }
}
