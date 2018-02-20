package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public class Label extends com.cs304.data_objects.Material {

    private String labelSize;


    public Label(String labelSize, int matID, String matName, float matStock, int matPrice, String matUnit) {
        super(matID, matName, matStock, matPrice, matUnit);
        this.labelSize = labelSize;
    }

    public String getLabelSize(){
        return this.labelSize;
    }

    private void setLabelSize(String labelSize) {
        this.labelSize = labelSize;
    }

    private void removeLabel(int quantity) {
        super.removeMaterial(quantity);
    }

    private void addLabel(int quantity) {
        super.addMaterial(quantity);
    }

}
