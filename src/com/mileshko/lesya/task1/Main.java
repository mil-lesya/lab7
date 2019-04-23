package com.mileshko.lesya.task1;

import java.io.IOException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        LinkedList<Door> list = new LinkedList<Door>() {
            {
                this.add(new Door(1));
                this.add(new Door(2));
            }
        };

        DoorPool<Door> pool = new DoorPool<>(list);

        for (int i = 0; i < 20; i++) {
            new Student(" входит ", pool).start();
            new Student(" выходит ", pool).start();
        }



    }
}
