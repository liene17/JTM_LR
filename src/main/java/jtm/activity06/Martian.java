package jtm.activity06;

public class Martian implements Humanoid, Alien, Cloneable {
    private int weight;
    final static int LEG_COUNT = 7;
    final static int ARM_COUNT = 2;
    private String[] items;
    private boolean alive;


    public Martian() {
        this.weight = 42;
        this.items = new String[10];
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Martian martian = new Martian();
        martian.setWeight(weight);
        return martian;
    }

    @Override
    public void eatHuman(Humanoid humanoid) {
        if(humanoid.isAlive().equals("Alive")){
           this.weight = humanoid.getWeight() + this.weight;
           humanoid.killHimself();
        }
    }

    @Override
    public int getLegCount() {
        return LEG_COUNT;
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
        }
        return "I AM IMMORTAL!";
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
        }
        return "I AM IMMORTAL!";
    }
}
