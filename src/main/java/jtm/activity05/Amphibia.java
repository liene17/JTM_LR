package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Vehicle {
    private byte sails;
    public Amphibia(String id, float consumption, int tankSize, byte sails, int wheels) {
        super(id, consumption, tankSize, wheels);
        this.sails =  sails;
    }

    @Override
    public String move(Road road) {
        if(road instanceof WaterRoad){
            super.move(road);
            return getId() + " " + getClass().getSimpleName() + " is sailing on " + road.toString() +
                    " with " + sails  + " sails";
        }else{
                super.move(road);
                return getId() + " " + getClass().getSimpleName() + " is driving on " +
                        road.toString() + " with " + wheels + " wheels";
        }
    }
}
