package com.example.laba6;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    String TAG = "LOG";
    public MyService() {
    }

    public void onCreate(){
        super.onCreate();
        Log.d(TAG, "Старт");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Остановка");
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG, "Запуск таймера");
        for(int i = 1; i < 4; i++){
            try {
                TimeUnit.SECONDS.sleep(i);
                Log.d(TAG, "sleep = " + i + " seconds");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
        Log.d(TAG, "Запуск № " + startId + "; флаг stopResult(" + startId + ") = " + stopSelfResult(startId));
        return  super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Ошибочка!");
    }
}