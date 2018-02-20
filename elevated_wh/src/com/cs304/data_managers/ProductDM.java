package com.cs304.data_managers;
import com.cs304.data_objects.*;
import com.cs304.data_objects.Recipe_Uses;

import java.sql.SQLException;
import java.util.ArrayList;


public class ProductDM {
    ArrayList<Product> prods;
    ConnectionManager cm;
    private BuildProductDM build_product;
    private FilledForDM filledForDM;

    public ProductDM() {
        prods = null;
        cm = new ConnectionManager();
    }

    public int addNewProductToWarehouse(String name, String size, String unit, String price, String recName, String procedure, String[][] materials) {
        String getIDsQuery = "SELECT product_counter.NEXTVAL, recipe_counter.NEXTVAL FROM dual";
        String[][] idsArray = new String[0][];
        try {
            idsArray = cm.submitQuery(getIDsQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String prodID = idsArray[1][0];
        String recID = idsArray[1][1];

        String sqlCmd = "insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) " +
                "values("+ prodID + ",\' "+ name + "\'," + size + ",\'" + unit + "\'," + price + ", 0)";
        int result = cm.executeStatement(sqlCmd);
        RecipeDM rdm = new RecipeDM();
        int result2 = rdm.addNewRecipe(recName, recID, procedure);
        BuildProductDM bpdm = new BuildProductDM();
        int result3 = bpdm.insertNewBuildProductTuple(prodID, recID);
        int numMats = materials.length;
        int result4 = -1;
        for (int i = 0; i < numMats; i++) {
            result4 = rdm.addNewRecipeUses(recID, materials[i][0], materials[i][2]);
            if (result4==0 || result4 ==-1) {
                // TODO: break and throw an error
            }
        }
        return result4;
    }

    public int addProductStock(String prodID, String quantity) {
        int result = 0;
        boolean canProduce = true;

        String sqlQuery = "select ru.recID, ru.matID, ru.quantity, m.matName, m.matStock, m.matPrice, m.matUnit " +
                        "from recipe_uses ru, build_product bp, material m " +
                        "where ru.recID=bp.recID AND m.matID=ru.matID AND bp.prodID=" + prodID;
        String[][] res = new String[0][];
        try {
            res = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Material> mats = new ArrayList<Material>();
        ArrayList<Recipe_Uses> rus = new ArrayList<Recipe_Uses>();
        int numTuples = res.length;
        for (int i = 1; i < numTuples; i++) {
            String[] tuple = res[i];
            Recipe_Uses ru = new Recipe_Uses(
                    Integer.parseInt(tuple[0]),
                    Integer.parseInt(tuple[1]),
                    Integer.parseInt(tuple[2]));
            rus.add(ru);
            Material mat = new Material(
                    Integer.parseInt(tuple[1]),
                    tuple[4],
                    Float.parseFloat(tuple[4]),
                    Integer.parseInt(tuple[5]),
                    tuple[6]);
            mats.add(mat);
        }

        // now we have a list of the materials and material used
        for (int j = 0; j < mats.size(); j++) {
            float matStock = mats.get(j).getMatStock();
            float recMatRequired = rus.get(j).getQuantity();
            if (recMatRequired <= matStock) {
                mats.get(j).setMatStock(matStock-recMatRequired);
            } else {
                canProduce = false;
                break;
            }
        }
        if (canProduce) {
            String sqlCmd = "";
            for (int k = 0; k < mats.size(); k++) {
                sqlCmd = "update material set matStock = " + mats.get(k).getMatStock() + " where matID=" + mats.get(k).getMatID();
                cm.executeStatement(sqlCmd);
            }
            sqlCmd = "UPDATE Product SET stockProduct = stockProduct + " + quantity + " WHERE prodID=" + prodID;
            result = cm.executeStatement(sqlCmd);
            return result;
        } else {
            // TODO: implement the exception that triggers an error popup in the UI
        }
        return result;
    }

    /**
     * deletes products by prodID
     *
     * @param prodID
     * @return
     */

    public int deleteProductbyID(String prodID) {
        String sqlCmd = "DELETE FROM Product WHERE prodID=" + prodID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    /**
     * find the cheapest item
     *
     * @param
     * @return
     */

    public String[][] cheapestProd() {
        String sqlQuery = "SELECT a.prodID, a.prodName, a.prodPrice FROM Product a, Product b GROUP BY a.prodID, a.prodName, a.prodPrice HAVING a.prodPrice = MIN(b.prodPrice)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * find the most expensive item
     *
     * @param
     * @return
     */

    public String[][] mostExpensiveProd() {
        String sqlQuery = "SELECT a.prodID, a.prodName, a.prodPrice FROM Product a, Product b GROUP BY a.prodID, a.prodName, a.prodPrice HAVING a.prodPrice = MAX(b.prodPrice)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * find the cheapest product and their recipe ID
     *
     * @param
     * @return
     */

    public String[][] CheapestProdplusRecID() {
        String sqlQuery = "SELECT a.prodID, a.prodName, a.recID, a.prodPrice FROM Recipe4Product a, Recipe4Product b GROUP BY a.prodID, a.prodPrice, a.prodName, a.recID HAVING a.prodPrice = MIN(b.prodPrice)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    /**
     * find the most expensive product and their recipe ID
     *
     * @param
     * @return
     */

    public String[][] mostExpensiveProdplusRecID() {
        String sqlQuery = "SELECT a.prodID, a.prodName, a.recID, a.prodPrice FROM Recipe4Product a, Recipe4Product b GROUP BY a.prodID, a.prodPrice, a.prodName, a.recID HAVING a.prodPrice = MAX(b.prodPrice)";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    /**
     * give the recipe information for a particular prodID
     *
     * @param prodID
     * @return
     */
    public String[][] listProdRecProc(String prodID) {

        String[][] recipeResult = new String[0][0];

        String sqlQuery = "SELECT prodID, recID, recName, procedure FROM Recipe4Product WHERE prodID =" + prodID;

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return results;
    }

    /**
     * HELPER:  decrease stock product
     *
     * @param prodID
     * @param quantity
     * @return
     */
    public int decreaseProductStock(String prodID, String quantity) {
        String sqlCmd = "UPDATE Product SET stockProduct = stockProduct - " + quantity + "WHERE prodID=" + prodID;
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    /**
     * Reserve product
     */
    /**
     * gives recipe information and product information for a particular ProdID
     *
     * @param prodID
     * @return
     */

    public String[][] getRecInfor4Prod(String prodID, String orderID, String quantity) {
        decreaseProductStock(prodID, quantity);
        filledForDM.increaseProdsOfFilled_For(prodID, quantity);
        filledForDM.insertNewFilledFor(prodID, orderID, quantity, "0");
        String sqlQuery = "SELECT * FROM Filled_For WHERE prodID =" + prodID;

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    /**
     * gives the list of all products
     *
     * @param
     * @return
     */
    public String[][] listAllProducts() {

        String sqlQuery = "SELECT * FROM Product";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public String[][] getProductByID(String prodID) {
        String sqlQuery = "select * from Product where prodID=" + prodID;
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
     * Gives product ID, Name recipe and price for products whose price is lower than average price
     */
    public String[][] getProdsCheaperAVG() {
        String sqlQuery = "SELECT rp1.prodID, rp1.prodName,rp1.recID, rp1.prodPrice FROM Recipe4Product rp1 WHERE rp1.prodPrice < (SELECT AVG(rp2.prodPrice) FROM Recipe4Product rp2)";

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
     * Gives product ID, Name recipe and price for products whose price is higher than average price
     */
    public String[][] getProdsExpensiverAVG() {

        String sqlQuery = "SELECT rp1.prodID, rp1.prodName,rp1.recID, rp1.prodPrice FROM Recipe4Product rp1 WHERE rp1.prodPrice > (SELECT AVG(rp2.prodPrice) FROM Recipe4Product rp2)";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}

