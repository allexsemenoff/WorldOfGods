package com.zaqwer.main;

import java.util.ArrayList;

/**
 * Created by zaqwer on 06.01.16.
 */
public abstract class Creature {
    public Location location;
    public int hp;
    public int damage;
    public int armor;
    public int lvl;
    public ArrayList<Item> inventory;
    public boolean isInventoryFull()
    {
        if(this.inventory.size() == 16) return true; else return false;
    }
    Creature target;
    public boolean isAlive()
    {
        if(this.hp > 0) return true;
        else
            return false;
    }

    public void pickUpItem(Item item)
    {
        if(!isInventoryFull())
        {
            this.inventory.add(item);
            this.location.items.remove(item);
        }
    }

    public abstract void goTo(String direction);

    public int getHp() {
        return hp;
    }
    public int getDamage() {
        return damage;
    }
    public int getArmor() {
        return armor;
    }
    public int getLvl() {
        return lvl;
    }
    public void setTarget(Creature target) {
        this.target = target;
    }
    public Creature getTarget() {
        return target;
    }
    public Creature(int lvl)
    {
        this.inventory = new ArrayList<Item>();
        this.lvl = lvl;
    }
    abstract public void takeDamage(int damage);
    abstract public void attack();

}
