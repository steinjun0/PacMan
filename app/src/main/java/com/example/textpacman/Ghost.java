package com.example.textpacman;

import android.util.Log;

public class Ghost extends Character{
    public Ghost(Map map, int init_x, int init_y){
        this.mapData = map.mapData;
        this.pos.position_x = init_x;
        this.pos.position_y = init_y;
        this.name = map.GHOST;
    }

    public void move(int pacmanX, int pacmanY){
        pos_past.position_x = pos.position_x;
        pos_past.position_y = pos.position_y;
        if(pacmanX <= this.pos.position_x && pacmanY <= this.pos.position_y){
            if (mapData[this.pos.position_x - 1][this.pos.position_y] == Map.SPACE) {
                this.pos.position_x -= 1;
                Log.d("Ghost", "Move in 1");
            }
            if (mapData[this.pos.position_x][this.pos.position_y - 1] == Map.SPACE) {
                this.pos.position_y -= 1;
                Log.d("Ghost", "Move in 2");
            }
        }
        else if(pacmanX <= this.pos.position_x && pacmanY >= this.pos.position_y){

            if (mapData[this.pos.position_x - 1][this.pos.position_y] == Map.SPACE) {
                this.pos.position_x -= 1;
                Log.d("Ghost", "Move in 3");
            }
            if (mapData[this.pos.position_x][this.pos.position_y + 1] == Map.SPACE) {
                this.pos.position_y += 1;
                Log.d("Ghost", "Move in 4");
            }

        }
        else if(pacmanX >= this.pos.position_x && pacmanY >= this.pos.position_y){
            Log.d("Ghost","Move in 5 6");

            if (mapData[this.pos.position_x + 1][this.pos.position_y] == Map.SPACE) {
                this.pos.position_x += 1;
                Log.d("Ghost", "Move in 5");
            } else if (mapData[this.pos.position_x][this.pos.position_y + 1] == Map.SPACE) {
                this.pos.position_y += 1;
                Log.d("Ghost", "Move in 6");
            }

        }
        else if(pacmanX >= this.pos.position_x && pacmanY <= this.pos.position_y){

            if (mapData[this.pos.position_x + 1][this.pos.position_y] == Map.SPACE) {
                this.pos.position_x += 1;
                Log.d("Ghost", "Move in 7");
            }

            else if (mapData[this.pos.position_x][this.pos.position_y - 1] == Map.SPACE) {
                this.pos.position_y -= 1;
                Log.d("Ghost", "Move in 8");
            }
        }
        Log.d("Ghost","Move in end");
    }
}



