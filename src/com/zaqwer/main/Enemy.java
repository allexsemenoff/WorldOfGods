package com.zaqwer.main;

/**
 * Created by alex on 06.01.16.
 */
public abstract class Enemy extends Creature {


    private int range;
    public Item inventory[];
    public abstract void recountStats();
    public int getRange() {
        return range;
    }

    public Enemy(int lvl) {
        super(lvl);
    }

    public void attack(){
        this.getTarget().takeDamage((int)(this.getDamage() - (this.getDamage() + getTarget().getArmor() * 0.01)));
    }

}

