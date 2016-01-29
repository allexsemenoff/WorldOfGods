package com.zaqwer.main;

import java.util.ArrayList;

/**
 * Created by zaqwer on 06.01.16.
 */
public abstract class Creature {
    public Location location;
    //Статы каждого вида существ скалируются относительно их уровня. Т.е. у огра статы будут отличны от скелета мага-элементалиста
    public int moveSpeed;
    public int attack_range;
    public int hp;
    public int damage;
    public int armor;
    public int lvl;
    public ArrayList<Item> inventory;
    public boolean isInventoryFull()
    {
        return this.inventory.size() == 16;
    }
    Creature target;
    public Creature(int lvl)
    {
        this.moveSpeed = 100;
        this.inventory = new ArrayList<Item>();
        this.lvl = lvl;
    }
    public boolean isAlive()
    {
        return this.hp > 0;
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
    abstract public void takeDamage(int damage);
    abstract public void attack();

}
