package com.mileshko.lesya.task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(2*5);
        new Thread(() -> {
            try {
                for (int i = 1; i < 30; i++) {
                    queue.put(i);
                    System.out.println(i + " посетитель зашел в ресторан");
                }
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }).start();

        new Thread(() -> {
            try {
                for(int i = 1 ; i < 30; ++i) {
                    Thread.sleep(500);
                    System.out.println(queue.take() + " покинул ресторан");
                }
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }).start();
    }
}
