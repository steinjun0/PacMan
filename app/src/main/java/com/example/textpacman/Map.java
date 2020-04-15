package com.example.textpacman;

import android.util.Log;

public class Map {
    public final static int SPACE = 0;
    public final static int WALL = 1;
    public final static int PACMAN = 10;
    public final static int GHOST = -1;

    protected int mapData [][] = new int [15][15]; //initialize mapData as [15][15] scale, and {0} (automatically)
    protected int wallData [][] = {{6,8,13},
                        {0,4,5,6,8,11},
                        {2,8,13},
                        {0,4,5,6,8,10,12,13},
                        {1,3,6,10},
                        {6, 8, 10, 12},
                        {0,1,3,4,5,6,8,9,10,12,13,14},
                        {},
                        {0,1,2,4,5,6,8,9,11,12,13,14},
                        {2,4,6,8},
                        {4,8,9,10,11},
                        {1,2,4,6,13},
                        {1,6,8,9,11},
                        {3,6,8,11,12,14},
                        {1,6,8}};
    int mapMonitorData[][] = new int [15][15];
    StringBuffer mapString = new StringBuffer();

    public Map(){
        //update the map data(wall) to mapCoordinate
        for(int i=0;i<15;i++){
            Log.d("Map", ""+i);
            for(int w : wallData[i]){
                mapData[i][w] = 1;

            }
        }
        mapMonitorData = copyArray(mapData, mapMonitorData);
    }

    public StringBuffer showMapMonitorData() {
        try {
            mapString.delete(0, mapString.toString().length());
        }catch (Exception e){Log.d("Map",""+e);};
        for (int i = 0; i < mapData.length; i++) {
            for (int j = 0; j < mapData[i].length; j++) {
                if (mapMonitorData[i][j] == WALL) {
                    mapString.append("■"); // ■ ■
                } else if (mapMonitorData[i][j] == SPACE) {
                    mapString.append("□");
                } else if (mapMonitorData[i][j] == PACMAN) {
                    mapString.append("●"); // ● ●
                } else if (mapMonitorData[i][j] == GHOST) {
                    mapString.append("▼"); // ▼ ▼
                }
            }
            mapString.append("\n");
        }
        return mapString;
    }

    public int [][] copyArray(int arr1 [][], int arr2 [][]){
        for(int i=0; i<arr1.length; i++){
            for(int j = 0; j<arr1[i].length; j++){
                arr2[i][j] = arr1[i][j];
            }
        }
        return arr2;
    }
}

