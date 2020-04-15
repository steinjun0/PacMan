package com.example.textpacman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return  size;
    }



    final Map map = new Map();
    final Pacman pman = new Pacman(map);
    Ghost ghost1 = new Ghost(map, 0 , 0);
    Ghost ghost2 = new Ghost(map, 14 , 14);
    final Controller controller = new Controller(map);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Main",""+getScreenSize(this).x+", "+getScreenSize(this).y);

        final ImageView testImage = (ImageView)findViewById(R.id.imageView);



        final TextView monitor;
        Button upButton, leftButton, rightButton, downButton;
        monitor = (TextView)findViewById(R.id.monitorTextView);
        upButton = (Button)findViewById(R.id.upButton);
        downButton = (Button)findViewById(R.id.downButton);
        rightButton = (Button)findViewById(R.id.rightButton);
        leftButton = (Button)findViewById(R.id.leftButton);

        Log.d("Main", "pos:("+pman.pos.position_x+", "+pman.pos.position_y + ")");
        controller.setAction(controller.STAY);
        controller.updateMapMonitorData(pman);
        controller.updateMapMonitorData(ghost1);


        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                controller.setAction(controller.UP);
                Log.d("Main","before pos_post ("+pman.pos_past.position_x +", " + pman.pos_past.position_y+")");
                Log.d("Main","before pos ("+pman.pos.position_x +", " + pman.pos.position_y+")");
                pman.move(controller); //change the position data in pman.
                Log.d("Main","after pos_post ("+pman.pos_past.position_x +", " + pman.pos_past.position_y+")");
                Log.d("Main","after pos ("+pman.pos.position_x +", " + pman.pos.position_y+")");
                controller.updateMapMonitorData(pman); // update to mapMonitorData
                monitor.setText(controller.getMapString());
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.setAction(controller.DOWN);
                pman.move(controller);
                controller.updateMapMonitorData(pman);
                monitor.setText(controller.getMapString());

            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.setAction(controller.LEFT);
                pman.move(controller);
                controller.updateMapMonitorData(pman);
                monitor.setText(controller.getMapString());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        float tmpx = testImage.getX();
                        while(tmpx-100<testImage.getX()){
                            try{
                                Thread.sleep(1);
                            }catch (Exception e){};
                            testImage.setX(testImage.getX()-1);
                        }
                    }
                }).start();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.setAction(controller.RIGHT);
                pman.move(controller);
                controller.updateMapMonitorData(pman);
                monitor.setText(controller.getMapString());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        float tmpx = testImage.getX();
                        while(tmpx+500>testImage.getX()){
                            try{
                                Thread.sleep(1);
                            }catch (Exception e){};
                            testImage.setX(testImage.getX()+2);
                        }
                    }
                }).start();
            }
        });

        monitor.setText(controller.getMapString());

        //new Thread(controller.moveGhost(ghost1, pman, monitor)).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(750);
                    }catch (Exception e){};
                    runOnUiThread(controller.moveGhost(ghost1, pman, monitor));
                }
            }
        }).start();

/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) { // 현재 UI 스레드가 아니기 때문에 메시지 큐에 Runnable을 등록 함
                    try{
                        Thread.sleep(750);
                    }catch (Exception e){};
                    runOnUiThread(new Runnable() {
                        public void run() { // 메시지 큐에 저장될 메시지의 내용
                            ghost1.move(pman.getPosition().position_x, pman.getPosition().position_y);
                            ghost2.move(pman.getPosition().position_x, pman.getPosition().position_y);
                            controller.updateMapMonitorData(ghost1);
                            controller.updateMapMonitorData(ghost2);
                            monitor.setText(controller.getMapString());
                        }
                    });
                }
            }
        }).start();

 */



    }

}
