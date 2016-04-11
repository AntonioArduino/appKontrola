package com.primjer.kk.myapplication;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;

import static com.primjer.kk.myapplication.MainActivity.openBT;
import static com.primjer.kk.myapplication.MainActivity.sendData;



public class upravljanje extends Activity {


    Character naredba;
    private Handler handler = new Handler();
    private boolean gore=false,dolje=false,lijevo=false,desno=false;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Print out your letter here...

            if(gore==true && lijevo==true){


               // Log.w("Log:","FL");
                try {
                    sendData('G');
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }else if(gore==true && desno==true){

                //Log.w("Log:","FR");

            try {
                sendData('I');
            } catch (IOException e) {
                e.printStackTrace();
            }
            }



            else if(dolje==true && lijevo==true){


                //Log.w("Log:","BL");

                try {
                    sendData('H');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if(dolje==true && desno==true){

               // Log.w("Log:","BR");

                try {
                    sendData('J');
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(gore==true && dolje==true){

                try {
                    sendData('S');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else{


                switch(naredba) {

                    case 'F':   //Log.w("Log:","F");
                        try {
                            sendData('F');
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                                break;

                    case 'B':

                        try {
                            sendData('B');
                        } catch (IOException e) {
                            e.printStackTrace();
                        }// Log.w("Log:","B");
                                break;

                    case 'L':
                     // Log.w("Log:","L");
                        try {
                            sendData('L');
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                                break;

                    case 'R':
                     // Log.w("Log:","R");
                        try {
                            sendData('R');
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                                break;


                };


            }
            // Call the runnable again
            handler.postDelayed(this, 100);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_upravljanje);
        ImageButton up = (ImageButton) findViewById(R.id.imageButton);
        ImageButton right = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton down = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton left = (ImageButton) findViewById(R.id.imageButton4);




        //lp.topMargin =  y;




        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        gore = true;

                        naredba = 'F';
                        handler.post(runnable);
                        v.setPressed(true);


                        break;

                    case MotionEvent.ACTION_UP:

                        gore = false;
                        v.setPressed(false);


                     if (lijevo == false || desno == false) {
                         handler.removeCallbacks(runnable);

                     }
                        break;

                }


                return true;
            }
        });

        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        dolje=true;
                        naredba = 'B';
                        v.setPressed(true);

                        handler.post(runnable);


                        break;
                    case MotionEvent.ACTION_UP:

                        dolje=false;

                        if(lijevo==false || desno == false){
                        handler.removeCallbacks(runnable);}

                        v.setPressed(false);
                        break;

                }
                return true;

            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        desno=true;

                        naredba='R';
                        v.setPressed(true);

                        handler.post(runnable);


                        break;
                    case MotionEvent.ACTION_UP:

                        desno=false;





                        if(gore==true){
                            handler.removeCallbacks(runnable);
                            naredba='F';
                            handler.post(runnable);


                        }else if(dolje==true){

                            handler.removeCallbacks(runnable);
                            naredba='B';
                            handler.post(runnable);

                        }else{

                              handler.removeCallbacks(runnable);

                }


                        v.setPressed(false);
                        break;
                }


                return true;
            }
        });

        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        lijevo=true;

                        naredba = 'L';
                        v.setPressed(true);

                        handler.post(runnable);


                        break;
                    case MotionEvent.ACTION_UP:

                        lijevo=false;
                        v.setPressed(false);
                        if(gore==true){
                            handler.removeCallbacks(runnable);
                            naredba='F';
                            handler.post(runnable);


                        }else if(dolje==true){

                            handler.removeCallbacks(runnable);
                            naredba='B';
                            handler.post(runnable);

                        }else{

                            handler.removeCallbacks(runnable);

                        }

                        break;
                }


                return true;
            }
        });




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    }





