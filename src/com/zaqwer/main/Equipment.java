package com.zaqwer.main;

/**
 * Created by alex on 06.01.16.
 */
public class Equipment extends Item implements IEquipable{

    public int inc_int;
    public int inc_end;
    public int inc_str;
    public int inc_ag;
    public int slot; // Номер слота на персонаже
    public Equipment(int id, int slot, int inc_int, int inc_end, int inc_ag, int inc_str) {
        super(id);
        this.slot = slot;
        this.inc_int = inc_int;
        this.inc_end = inc_end;
        this.inc_ag = inc_ag;
        this.inc_str = inc_str;

    }
    Hero hero; //Ссылка на носителя

    @Override
    public void equip(Hero hero) {
        if(hero.equipment[this.slot] == null) //Если слот пустой - надеваем
        {
            this.hero.equipment[this.slot] = this;
        }
        else
        {
            hero.equipment[this.slot].unequip(this.hero);
            hero.equipment[this.slot] = this;
        }
        hero.incStats(this.inc_int,this.inc_ag,this.inc_str,this.inc_end);
    }


    @Override
    public void unequip(Hero hero)
    {
        hero.decStats(hero.equipment[this.slot].inc_int,hero.equipment[this.slot].inc_ag,hero.equipment[this.slot].inc_str,hero.equipment[this.slot].inc_end);
        if(hero.equipment[this.slot] == this)
            if(!hero.isInventoryFull())
            {
                hero.inventory.add(this);
                hero.equipment[this.slot] = null;
            } else {
                hero.location.items.add(this);
            }
    }
}
