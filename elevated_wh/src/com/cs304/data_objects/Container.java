package com.cs304.data_objects;

/**
 * Created by SadafiYadegari on 2016-11-19.
 */
public class Container extends com.cs304.data_objects.Material {

    private int volume;


    public Container(int volume, int matID, String matName, float matStock, int matPrice, String matUnit) {
        super(matID, matName, matStock, matPrice, matUnit);
        this.volume = volume;
    }

    public int getVolume(){
        return this.volume;
    }

    public void setVolume(int v){
        this.volume = v;
    }

    private void addContainer(int quantity) {
        super.addMaterial(quantity);
    }

    private void removeContainer(int quantity) {
        super.removeMaterial(quantity);
    }

}
