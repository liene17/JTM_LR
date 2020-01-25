package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Vehicle extends Transport {
    protected int wheels;

    public Vehicle(String id, float consumption, int tankSize, int wheels) {
        super(id, consumption, tankSize);
        this.wheels = wheels;
    }

    @Override
    public String move(Road road) {
        if (road.getClass() == Road.class) {
            super.move(road);
            return getId() + " " + getClass().getSimpleName() + " is driving on " +
                    road.toString() + " with " + this.wheels + " wheels";
        } else {
            return "Cannot drive on " + road.toString();
        }
    }
}
