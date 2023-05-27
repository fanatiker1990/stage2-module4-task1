package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton singleton;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (singleton == null) {
            synchronized (ThreadSafeSingleton.class) {
                singleton = new ThreadSafeSingleton();
            }
        }
        return singleton;
    }
}
