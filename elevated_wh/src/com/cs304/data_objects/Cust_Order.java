package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class Cust_Order {

        private String orderID;


        public Cust_Order (String orderID) {
            this.orderID = orderID;
        }

        public String getOrderID() {
            return this.orderID;
        }

        private void setOrderID(String ID) {
            this.orderID = ID;
        }

}
