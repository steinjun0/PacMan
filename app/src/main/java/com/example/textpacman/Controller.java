package com.example.textpacman;

import android.util.Log;
import android.widget.TextView;

public class Controller {

    public static final int UP = 8;
    public static final int DOWN = 2;
    public static final int LEFT = 4;
    public static final int RIGHT = 6;
    public static final int STAY = 0;

    private StringBuffer mapString;
    private int action = 0;
    Map map;

    public Controller(Map map) {
        this.map = map;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public int getAction() {
        return action;
    }

    public void updateMapMonitorData(Character character) {
        map.mapMonitorData[character.pos_past.position_x][character.pos_past.position_y] = map.SPACE;
        map.mapMonitorData[character.pos.position_x][character.pos.position_y] = character.name;
        mapString = map.showMapMonitorData();
    }

    public StringBuffer getMapString() {
        return mapString;
    }

    public Runnable moveGhost(final Ghost ghost1, final Pacman pman, final TextView monitor) {
        final Controller controller = this;
        Runnable autoMove = new Runnable() {
            @Override
            public void run() {

                ghost1.move(pman.getPosition().position_x, pman.getPosition().position_y);
                controller.updateMapMonitorData(ghost1);
                monitor.setText(controller.getMapString());
            }
        };
        return autoMove;
    }
/*
    public Runnable moveGhost1(final Ghost ghost1, final Pacman pman, final TextView monitor) {
        final Controller controller = this;
        Runnable autoMove2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(750);
                    } catch (Exception e) {};
                    runOnUiThread(controller.moveGhost(ghost1, pman, monitor)); //에러???왜???
                }
            }
        };
        return autoMove2;
    }

 */
}
