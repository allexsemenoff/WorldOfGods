package com.zaqwer.main;

/**
 * Created by zaqwer on 08.01.16.
 */
public class Weapon extends Equipment {

    public int damage, range;
    public String name;
    /*
        Примерные типы оружия:
            Двуручный меч
            Двуручный посох
            Одноручный меч
            Одноручный гримуар
            Одноручный щит
            ...

            т.е. 1 слово - количество занимаемых слотов оружием
                 2 слово - класс оружия
                 3+ - описание
                    # Одноручный топор Драконоборца
                    # Двуручный гримуар Укротителя Ветров
    */

    public Weapon(int id, int slot, int inc_int, int inc_end, int inc_ag, int inc_str, int damage, int range, String name) {
        super(id, slot, inc_int, inc_end, inc_ag, inc_str);
        this.damage = damage;
        this.range = range;
        this.name = name;
    }

    public boolean isRanged() {
        if(this.range > 0) return true;
        else return false;
    }
}
