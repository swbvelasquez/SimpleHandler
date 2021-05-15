package com.tutoriales.simplehandler;

import android.os.Handler;
import android.util.Log;

public class SimpleRunneable implements Runnable{
    private int seconds;

    public SimpleRunneable(int seconds){
        this.seconds=seconds;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<seconds;i++){
                Log.d("simpleRunneable","i: " + i);
                Thread.sleep(1000);
            }
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
    }
}
