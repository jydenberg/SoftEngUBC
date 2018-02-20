package com.cs304.data_managers;

import com.cs304.data_objects.Placed_For;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by tyh0 on 2016-11-21.
 */
public class PlacedForDM {
    ArrayList<Placed_For> pf;
    ConnectionManager cm;

    public PlacedForDM() {
        pf = null;
        cm = new ConnectionManager();
    }

    public int insertPlacedFor(String custID, String orderID) {
        CustOrderDM codm = new CustOrderDM();

        String sqlCmd = "INSERT INTO Placed_For(orderID,custID) VALUES(" + orderID + "," + custID +")";
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public String[][] getAllPlacedFor() {
        String sqlQuery = "SELECT pf.orderID, pf.custID, c.custFName, c.custLName FROM Placed_For pf, Customer c WHERE pf.custID = c.custID";
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * for a given order ID, give customer first name, last name, ID and phone num
     * @param orderID
     * @return
     */

    public String[][] getCustInfoByOrderID(String orderID) {
        String sqlQuery = "SELECT c.custID, c.custFName, c.custLName FROM Placed_For pf, Customer c WHERE c.custID ="+ orderID;
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



    public String[][] getPlacedForByOrderID(String orderID) {
        String sqlQuery = "SELECT * FROM Placed_For WHERE orderID="+orderID;
        String[][] result = new String[1][1];
        try {
            result = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
