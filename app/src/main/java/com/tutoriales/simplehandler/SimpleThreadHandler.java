package com.tutoriales.simplehandler;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class SimpleThreadHandler extends Thread{
    private int seconds;
    private Handler handler;
    private Context context;

    public SimpleThreadHandler(int seconds, Context context){
        this.seconds=seconds;
        this.context =context;
        handler = new Handler(context.getMainLooper());
    }

    @Override
    public void interrupt() {
        super.interrupt();
        Log.d("interrupted","interrupted");
        handler.post(() -> Toast.makeText(context, "post SimpleThreadHandler interrupted", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void run() {
        try{
            if(!interrupted()) {
                for (int i = 0; i < seconds; i++) {
                    Log.d("SimpleThreadHandler", "i: " + i);
                    Thread.sleep(1000);
                }


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "post SimpleThreadHandler", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }catch (Exception ex){

        }
    }
}
