package jtm.activity06;

import java.util.Arrays;

public class Human implements Humanoid {
    private int weight;
    private boolean alive;
    final static int ARM_COUNT = 2;
    private String[] items;

    public Human(int weight) {
        this.weight = weight;
        this.items = new String[10];
        this.alive = true;
    }
    public Human() {
        this(42);
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String killHimself() {
       if(this.alive == true) {
           this.alive = false;
           return "Dead";
       }
       return null;
    }

    @Override
    public int getArmCount() {
        return ARM_COUNT;
    }

    @Override
    public String[] getBackpack() {
        return this.items;
    }

    @Override
    public void addToBackpack(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }
    @Override
    public String isAlive() {
        if (this.alive == true) {
            return "Alive";
        } else {
            return "Dead";
        }
    }

    @Override
    public String toString() {
        return "Humanoid " + weight + " [Backpack content " + Arrays.toString(items) + " ]";
    }
}
