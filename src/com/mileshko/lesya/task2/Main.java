package com.mileshko.lesya.task2;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Table> list = new LinkedList<Table>() {
            {
                for (int i = 0; i < 10; i++) {
                    this.add(new Table(i + 1));
                }
            }
        };

        TablePool<Table> pool = new TablePool<>(list);

        for (int i = 0; i < 20; i++) {

            new Visitor(pool).start();


        }
    }
}
