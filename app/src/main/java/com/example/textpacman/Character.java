package com.example.textpacman;

import android.util.Log;

public class Character {
    protected int name;
    protected Position pos = new Position(); //should be initialized by constructor
    protected Position pos_past = new Position(); //should be initialized by constructor
    protected int[][] mapData; //should be initialized by constructor


    public Position getPosition() {
        return pos;
    }

    public Position getPositionPast() {
        return pos_past;
    }

    /*
    public void updateCharacterPosition() {
        this.map.moveCharacter(this);
    }
    */

    public void move(Controller controller){
        pos_past.position_x = pos.position_x;
        pos_past.position_y = pos.position_y;
        int x = this.pos.position_x;
        int y = this.pos.position_y;
        int diff_x = 0, diff_y =0;

        if(controller.getAction() == Controller.UP){
            diff_x=-1;
        }
        else if(controller.getAction() == Controller.DOWN){
            diff_x=+1;
        }
        else if(controller.getAction() == Controller.LEFT){
            diff_y=-1;
        }
        else if(controller.getAction() == Controller.RIGHT){
            diff_y=+1;
        }

        if((x+ diff_x >= 0 && y + diff_y >= 0)&&(x+diff_x<15 && y+diff_y<15)) {
            if (mapData[x + diff_x][y + diff_y] == 0) {
                this.pos.position_x = this.pos.position_x + diff_x;
                this.pos.position_y = this.pos.position_y + diff_y;

            }
        }
    }

}

class Position{
    public int position_x = 0, position_y = 0;
}
