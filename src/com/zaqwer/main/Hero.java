package com.zaqwer.main;

import com.zaqwer.main.Creature;

/**
 * Created by zaqwer on 06.01.16.
 */
public abstract class Hero extends Creature {
    public Weapon weapon;
    public Equipment[] equipment;
    /*
        Экипировка персонажа - 7 слотов
            0 - голова
            1 - нагрудник
            2 - аксессуар (оберег\кольцо\{прочее бесполезное говно})
            3 - левая рука (заблокировна, если надето двуручное оружие)
            4 - правая рука
            5 - поножи
            6 - сапоги
     */
    public int melee_damage // "Родной" урон в ближнем бою
            , range_damage, // "Родной" урон в дальнем бою
             mana;
    private int agility, endurance,intelligence, strength,
            increment_agility, increment_endurance, increment_strength,increment_intelligence; //Увеличение характеристик с каждым уровнем
    public Hero(int lvl) {
        super(lvl);
        this.equipment = new Equipment[7];
        increment_strength = 2;increment_agility=2;increment_endurance=2;increment_intelligence=2;
    }

    public void recountStats()
    {

        this.moveSpeed = 100 + this.agility;
        this.melee_damage = this.strength;
        this.range_damage = this.agility;
        if(!this.weapon.isRanged()) this.damage = this.weapon.damage + this.melee_damage; else this.damage = this.weapon.damage + this.range_damage;
        this.attack_range = this.weapon.range;
        this.mana = 10 + this.intelligence * 16;
        this.hp = 50 + this.endurance * 10;
        this.weapon = (Weapon)this.equipment[4]; // Нехорошо
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

    public void attack() // Расчёт дальности будет происходить в самом бою
    {
        this.getTarget().takeDamage((int)(this.getDamage() - (this.getDamage() * (getTarget().getArmor() * 0.01))));
    }
}
