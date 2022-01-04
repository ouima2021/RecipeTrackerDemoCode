package org.example.Models;


import java.util.ArrayList;

public class API {
    public ArrayList<Object> hits;


    public API (ArrayList<Object> hits){
        super();
        this.hits = hits;

    }

    public ArrayList<Object> getHits() {
        return hits;
    }

    public void setHits(ArrayList<Object> hits) {
        this.hits = hits;
    }

    @Override
public String toString(){

return "I ADDED THIS FOR: " + hits;


}

}