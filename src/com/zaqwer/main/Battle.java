package com.zaqwer.main;

/**
 * Created by zaqwer on 08.01.16.
 */
public class Battle extends Thread {
    private Location location; //Поле боя
    private int distance; //Расстояние между противниками
    private Creature w1,w2; //Бойцы
    public Battle(Creature w1, Creature w2)
    {
        this.w1 = w1;
        this.w2 = w2;
        this.w1.setTarget(w2);
        this.w2.setTarget(w1);
        if(this.w1.attack_range >= this.w2.attack_range)
            this.distance = this.w1.attack_range;
        else
            this.distance = this.w2.attack_range;
        this.start();
    }

    @Override
    public void run()
    {
        //TODO: ПЕРЕДЕЛАТЬ, это говно здесь на время тестов
        while (true)
        {
            if(w1.attack_range >= this.distance)
            {
                w1.attack();
            }
            else this.distance -= w1.moveSpeed;
            try {
                this.sleep(5000); //5 секунд ожидание между ударами
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(w2.attack_range >= this.distance)
            {
                w2.attack();
            }
            else this.distance -= w2.moveSpeed;
            try {
                this.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!this.w1.isAlive()) //Проверка конца битвы для первого дебила
            {
                for(Item i : this.w1.inventory)
                {
                    this.location.items.add(i);
                }
                this.w1.removeFromWorld();
            }

            if(!this.w2.isAlive()) //Проверка конца битвы для второго дебила
            {
                for(Item i : this.w2.inventory)
                {
                    this.location.items.add(i);
                }
                this.w2.removeFromWorld();
            }
        }
    }
}
