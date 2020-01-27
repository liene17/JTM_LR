package jtm.activity06;

public class Martian implements Humanoid, Alien, Cloneable {
    private int weight;
    final static int LEG_COUNT = 7;


    public Martian() {
        this.weight = 42;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void eatHuman(Humanoid humanoid) {


    }

    @Override
    public int getLegCount() {
        return 0;
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
        return null;
    }

    @Override
    public int getArmCount() {
        return 0;
    }

    @Override
    public String[] getBackpack() {
        return new String[0];
    }

    @Override
    public void addToBackpack(String item) {

    }

    @Override
    public String isAlive() {
        return null;
    }
}
