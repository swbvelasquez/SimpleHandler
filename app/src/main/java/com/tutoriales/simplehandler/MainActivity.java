package com.tutoriales.simplehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Handler mainHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startThread(View view){
        //iniciarSimpleRunneableHandler();
        iniciarSimpleThreadHandler();
    }

    public void stopThread(View view){

    }

    private void iniciarSimpleThread(){
        //1era forma de usar threads
        //extendiendo de Thread
        SimpleThread simpleThread = new SimpleThread(5);
        simpleThread.start();
    }

    private void iniciarSimpleRunneable(){
        //2da forma de usar threads
        //implementando runneable y mandandolo a un generic thread
        SimpleRunneable simpleRunneable = new SimpleRunneable(4);
        Thread thread = new Thread(simpleRunneable);
        thread.start();
    }

    private void iniciarMainHandler(){
        //1era forma de usar el handler
        //cuando el handler se declara en el activity esta ligado al lopper automaticamente
        mainHandler = new Handler();
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Inside post handler", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void iniciarSimpleRunneableHandler(){
        //2da forma de usar el handler
        //cuando asocias el looper dentro del runneable o thread run
        SimpleRunneableHandler runneableHandler = new SimpleRunneableHandler(3,getApplicationContext());
        Thread thread = new Thread(runneableHandler);
        thread.start();
    }

    private void iniciarSimpleThreadHandler(){
        //2da forma de usar el handler
        //cuando asocias el looper dentro del runneable o thread run
        SimpleThreadHandler simpleThreadHandler = new SimpleThreadHandler(10,getApplicationContext());
        simpleThreadHandler.start();
        simpleThreadHandler.interrupt();
    }
}