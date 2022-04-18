package com.example.asm;

import java.util.HashMap;

public class TimeManager {
    private static final HashMap<String, Long> startMap = new HashMap<>();
    private static final HashMap<String, Long> endMap = new HashMap<>();

    public static void start(String key, long timeMills) {
        startMap.put(key, timeMills);
    }

    public static void end(String key, long timeMills) {
        endMap.put(key, timeMills);
    }

    public static long current(String key) {
        long startTimeMills = 0L;
        long endTimeMills = 0L;
        if (startMap.get(key) != null) {
            startTimeMills = startMap.get(key);
        }
        if (endMap.get(key) != null) {
            endTimeMills = endMap.get(key);
        }
        return endTimeMills - startTimeMills;
    }
}
