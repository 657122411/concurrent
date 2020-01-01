package com.tjh.concurrent.c_024;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 有N张火车票，每个票都有一个编号
 * 同时有10个窗口对外售票 模拟程序
 * <p>
 * 重复销售 ？ 超量销售？
 */
public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = tickets.poll();
                    if (s == null) {
                        break;
                    } else {
                        System.out.println("销售了：" + s);
                    }
                }
            }).start();
        }
    }


}
