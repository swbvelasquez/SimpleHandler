package com.tutoriales.simplehandler;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class SimpleRunneableHandler implements Runnable{
    private int seconds;
    private Handler handler;
    private Context context;

    public SimpleRunneableHandler(int seconds, Context context){
        this.seconds=seconds;
        this.context =context;
        handler = new Handler(context.getMainLooper());
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<seconds;i++){
                Log.d("SimpleRunneableHandler","i: " + i);
                Thread.sleep(1000);
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context,"post SimpleRunneableHandler",Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
    }
}
