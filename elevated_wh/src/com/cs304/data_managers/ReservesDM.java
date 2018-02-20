package com.cs304.data_managers;
import com.cs304.data_objects.Reserves;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by tyh0 on 2016-11-21.
 */
public class ReservesDM {
    ArrayList<Reserves> res;
    ConnectionManager cm;


    public ReservesDM () {
        res = null;
        cm = new ConnectionManager();
    }

    public int insertNewReserves(String prodID, String orderID, String numProd) {
        String getNumProdQuery = "SELECT numProd FROM Reserves WHERE orderID = "+ orderID;
        String[][] numProdArray = new String[0][];
        int result;

        try {
            numProdArray = cm.submitQuery(getNumProdQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String numProdStr = numProdArray[1][2];
        int numProdInt = Integer.parseInt(numProdStr);
        int numfilledInt = Integer.parseInt(numProd);
        String sqlCmd = "insert into Reserves(prodID, orderID, numProd)" + "values(" +prodID + "," +
                orderID + "," +
                numProd + "," + ")";
        result = cm.executeStatement(sqlCmd);
        return result;

//        else {
//            // TODO: implement the exception that triggers an error popup in the UI
//            int error = -1;
//            return error;
//        }
        }


}
