package com.zaqwer.main;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by zaqwer on 06.01.16.
 */
public class Location
{
    public Point position;
    public ArrayList<Item> items;
    public String type;
    public Location(String type, int x, int y)
    {
        this.type = type;
        this.position.x = x;
        this.position.y = y;

    }
}
