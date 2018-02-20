package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public class Product {

    private int stockProduct;
    private int prodPrice;
    private int prodID;
    private String prodName;
    private int prodSize;
    private String prodUnit;

    public Product(){

    }

    public Product(int stockProduct, int prodPrice, int prodID, String prodName, int prodSize, String prodUnit){
        this.stockProduct = stockProduct;
        this.prodPrice = prodPrice;
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodSize = prodSize;
        this.prodUnit = prodUnit;
    }

    private int getStockProduct() {
        return this.stockProduct;
    }

    private int getProdPrice(){
        return this.prodPrice;
    }

    private int getProdID() {
        return this.prodID;
    }

    private String getProdName() {
        return this.prodName;
    }

    private int getProdSize() {
        return this.prodSize;
    }

    private String getProdUnit(){
        return this.prodUnit;
    }

    private void setStockProduct(int stock){
        this.stockProduct = stock;
    }

    private void setProdPrice(int price) {
        this.prodPrice = price;
    }

    private void setProdID(int ID){
        this.prodID = ID;
    }

    private void setProdName(String name) {
        this.prodName = name;
    }

    private void setProdSize(int size) {
        this.prodSize = size;
    }

    private void setProdUnit(String unit) {
        this.prodUnit = unit;
    }




}
