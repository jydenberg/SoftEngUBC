package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-20.
 */
public class Recipe {
    private int recID;
    private String procedure;
    private String recName;


    public Recipe(int recID, String procedure, String recName) {
        this.recID = recID;
        this.procedure = procedure;
        this.recName = recName;
    }

    public int getRecID() {
        return this.recID;
    }

    private void setRecID(int rid) {
        this.recID = rid;
    }

    public String getProcedure() {
        return this.procedure;
    }


    private void setProcedure(String p) {
        this.procedure = p;
    }

    public String getRecName() {
        return this.recName;
    }

    private void setRecName(String rn) {
        this.recName = rn;
    }

}
