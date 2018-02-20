package com.cs304.data_managers;

import com.cs304.data_objects.Material;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class MaterialDM {

    ArrayList<Material> mats;
    ConnectionManager cm;
    public MaterialDM() {
        mats = null;
        cm = new ConnectionManager();
    }

    public String[][] getAllMaterialTuples() {
        String sqlQuery = "SELECT * FROM Material";
        String[][] results = new String[0][];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public String[][] getNamefromID(String mid) {
        String sqlQuery = "SELECT matName FROM Material WHERE matID="+mid;
        String[][] results = new String[0][];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public int insertNewMaterial(String prodName, String stock, String unit, String price) {
        String sqlCmd = "INSERT INTO Material(matID,matName,matStock,matUnit,matPrice) "+
                "VALUES(material_counter.nextval,\'"+ prodName+ "\'," + stock+ ",\'" + unit + "\',\'"+price+"\')";
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public int updateMaterialStock(String matID, String quantity) {
        String sqlCmd = "UPDATE Material SET matStock = matStock + " + quantity + " WHERE matID="+matID;
        //return of 0 means tuple was NOT successfully added
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    /**
     * Nested Query
     * Gives material ID, Name and price for cheapest materials
     */
    public String[][] getCheapestMats() {

        String sqlQuery = "SELECT m1.matID, m1.matName, m1.matPrice FROM Material m1 WHERE m1.matPrice = (SELECT MIN(m2.matPrice) FROM Material m2)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Nested Query
     * Gives material ID, Name and price for most expensive materials
     */
    public String[][] getMostExpensiceMats() {

        String sqlQuery = "SELECT m1.matID, m1.matName, m1.matPrice FROM Material m1 WHERE m1.matPrice = (SELECT MAX(m2.matPrice) FROM Material m2)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    /**
     * Nested Query
     * Gives material ID, Name and price for materials whose price is lower than average price
     */
    public String[][] getMatssCheaperAVG() {

        String sqlQuery = "SELECT m1.matID, m1.matName, m1.matPrice FROM Material m1 WHERE m1.matPrice < (SELECT AVG(m2.matPrice) FROM Material m2)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Nested Query
     * Gives material ID, Name and price for materials whose price is higher than average price
     */
    public String[][] getMatsExpensiverAVG() {

        String sqlQuery = "SELECT m1.matID, m1.matName, m1.matPrice FROM Material m1 WHERE m1.matPrice > (SELECT AVG(m2.matPrice) FROM Material m2)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

}
