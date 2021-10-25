package id.vidya.menumakansqlite;

import java.io.Serializable;

public class MainData implements Serializable {

    private int ID;
    private String name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MainData(int id, String name){
        this.ID=id;
        this.name = name;
    }

    public MainData(){}
}
