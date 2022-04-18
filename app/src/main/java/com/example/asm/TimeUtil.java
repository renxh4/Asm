package com.example.asm;

import android.util.Log;

public class TimeUtil {
    public void handler() {
        Log.d("mmm", "hahaha");

        long l = System.currentTimeMillis();

        TimeManager.start("111",l);
    }
}
