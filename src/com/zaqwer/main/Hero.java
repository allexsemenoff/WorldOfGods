package com.zaqwer.main;

import com.zaqwer.main.Creature;

/**
 * Created by zaqwer on 06.01.16.
 */
public abstract class Hero extends Creature {
    public Weapon weapon;
    public Equipment[] equipment;
    public int melee_damage, range_damage, mana;
    private int agility, endurance,intelligence, strength,increment_agility, increment_endurance, increment_strength,increment_intelligence;
    public Hero(int lvl) {
        super(lvl);
        this.equipment = new Equipment[7];
        increment_strength = 2;increment_agility=2;increment_endurance=2;increment_intelligence=2;
    }

    public void recountStats()
    {
        this.melee_damage = this.strength;
        this.range_damage = this.agility;
        if(this.weapon.type == "melee") this.damage = this.weapon.damage + this.melee_damage;
        if(this.weapon.type == "range") this.damage = this.weapon.damage + this.range_damage;
        this.mana = 10 + this.intelligence * 16;
        this.hp = 50 + this.endurance * 10;
    }

    public void lvlUp()
    {
        this.lvl++;
        this.agility+=increment_agility;
        this.endurance+=increment_endurance;
        this.intelligence+=increment_intelligence;
        this.strength+=increment_strength;
    }

    public void goTo(String direcrion)
    {
        switch (direcrion)
        {
            //TODO: Доделать
            case "up":
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }
    }
    public void incStats(int intelligence, int agility, int strength, int endurance)
    {
        this.agility += agility;
        this.strength += strength;
        this.endurance += endurance;
        this.intelligence += intelligence;
    }

    public void decStats(int intelligence, int agility, int strength, int endurance)
    {
        this.agility -= agility;
        this.strength -= strength;
        this.endurance -= endurance;
        this.intelligence -= intelligence;
    }

    public void attack()
    {
        this.getTarget().takeDamage((int)(this.getDamage() - (this.getDamage() * (getTarget().getArmor() * 0.01))));
    }
}
