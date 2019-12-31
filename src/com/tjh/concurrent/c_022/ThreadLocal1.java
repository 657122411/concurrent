package com.tjh.concurrent.c_022;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 */
public class ThreadLocal1 {
    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "long";
        }).start();
    }
}

class Person {
    String name = "wang";
}