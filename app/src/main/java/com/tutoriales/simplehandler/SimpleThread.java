package com.tutoriales.simplehandler;

import android.util.Log;

import java.util.logging.Handler;

public class SimpleThread extends Thread{

    private int seconds;

    public SimpleThread(int seconds){
        this.seconds=seconds;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<seconds;i++){
                Log.d("simpleThread","i: " + i);
                Thread.sleep(1000);
            }
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
    }
}
