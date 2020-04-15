package com.example.textpacman;

public class Pacman extends Character
{
    public Pacman(Map map){
        this.mapData = map.mapData;
        this.pos.position_x = 7;
        this.pos.position_y = 7;
        this.name = map.PACMAN;
    }
}
