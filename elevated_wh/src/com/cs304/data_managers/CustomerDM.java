package com.cs304.data_managers;

import com.cs304.data_objects.Customer;
import com.cs304.frontend.Error_Pop;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDM {

    // may need more arraylists to hold data related to customer actions
    ArrayList<Customer> mats;
    ConnectionManager cm;

    public CustomerDM() {
        mats = null;
        cm = new ConnectionManager();
    }

    public void insertCustomer(String firstName, String lastName, String phoneNumber) {
        String sqlCmd =
                "insert into Customer(custID,custFName, custLName, pnum) "+"values(customer_counter.nextval,\'"+firstName+"\',\'"+ lastName +
                "\',\'"+phoneNumber+"\')";
        int rowCount = cm.executeStatement(sqlCmd);
    }

    public String[][] findCxByIdOrPhoneNumber(String cid, String name, String pnum) {
        String sqlQuery = "";
        String[][] results = new String[1][1];
        if (!cid.equals("")) {
            sqlQuery = "SELECT custID,custFName, custLName, pnum FROM Customer WHERE custID=" + cid;
        }
        else {
            if (!pnum.equals("") && name.equals("")) {
                sqlQuery = "SELECT * FROM Customer c WHERE c.pnum = \'" + pnum.replaceAll("[\\s\\-()]", "") + "\'";
            } else if (pnum.equals("") && !name.equals("")) {
                sqlQuery = "SELECT * FROM Customer c WHERE c.custLName = \'" + name +
                        "\'";

            } else if (!pnum.equals("") && !name.equals("")) {
                //String fname = name.substring(0, name.indexOf(' '));
                //String lname = name.substring(name.indexOf(' ')+1);
                sqlQuery = "SELECT * FROM Customer c WHERE c.custLName = \'" + name +
                        "\' AND c.pnum = \'" + pnum.replaceAll("[\\s\\-()]", "") + "\'";
            } else {
                Error_Pop ep = new Error_Pop();
                ep.New_Pop();

            }
        }
            try {
                results = cm.submitQuery(sqlQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
           return results;
        }


    /**
     * delete customer by ID
     * @param custID
     * @return
     */
    public int deleteCustomerID(String custID) {
        String sqlCmd = "DELETE FROM Customer WHERE custID=" + custID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }


    /**
     * Division Query
     * Find customer(s) that has ordered all products
     * @return
     */
    public String[][] cxOrderedAllProducts() {
        String sqlQuery = "";
        String[][] results = new String[0][0];
        sqlQuery = "SELECT c.custID, c.custFName, c.custLName FROM Customer c WHERE NOT EXISTS(SELECT * FROM Product p WHERE NOT EXISTS (SELECT r.prodID FROM Reserves r, Placed_For f WHERE p.prodID = r.prodID AND f.orderID  = r.orderID AND c.custID = f.custID))";
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public String[][] listAllCustomers() {
        String sqlQuery = "";
        String[][] results = new String[1][1];
        sqlQuery = "SELECT * FROM Customer";

        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
