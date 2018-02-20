package com.cs304.data_managers;
import com.cs304.data_objects.Recipe;

import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDM {
    ArrayList<Recipe> recipes;
    ConnectionManager cm;

    public RecipeDM() {
        recipes = null;
        cm = new ConnectionManager();
    }
    public int addNewRecipe(String recName, String recID, String procedure) {
        String sqlCmd = "insert into Recipe(recID, recName, procedure) " +
                "values(" + recID + ",\'" + recName + "\',\'" + procedure + "\')";
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public int addNewRecipeUses(String recID, String matID, String quantity) {
        String sqlCmd = "insert into recipe_uses(recID, matID, quantity) values("+
                recID+","+matID+","+quantity+")";
        int result = cm.executeStatement(sqlCmd);
        return result;
    }

    public  String[][] getRecInfo(String recID) {
        String sqlQuery = "SELECT procedure, recName FROM Recipe";

        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return results;
    }

    public String[][] getRecipeDetailsByProdID(String prodID) {

        //select r.recID, r.recName, r.procedure
        //  from recipe r, build_product bp
        //  where r.recID=bp.recID AND bp.prodID=prodID;

        String sqlQuery = "select r.recID, r.recName, r.procedure " +
                "from recipe r, build_product bp " +
                "where bp.prodID=" + prodID + " AND r.recID=bp.recID";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public String[][] getRecipeUsesDetailsByProdID(String prodID) {
        String sqlQuery = "select ru.matID, ru.quantity " +
                "from build_product bp, recipe_uses ru " +
                "where bp.prodID=\'" + prodID + "\' AND ru.recID=bp.recID";
        String[][] results = new String[0][0];
        try {
            results = cm.submitQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    


}
