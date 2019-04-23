package com.mileshko.lesya.task1;

public class Student extends Thread {
    private boolean reading = false;
    private String state;
    private DoorPool<Door> pool;

    public Student(String state, DoorPool<Door> pool)  {
        this.state = state;
        this.pool = pool;
    }

    public Student( ) {
    }

    public void run() {
        Door door = null;
        try {
            door = pool.getResource(300);
            reading = true;
            System.out.println("Студент #" + this.getId() + state + " дверь" + door.getIdDoor());
            door.using();
        } catch (Exception e) {
            System.out.println("Студент #" + this.getId() + " ожидает" );
        } finally {
            if (door != null) {
                reading = false;
                pool.returnResource(door);

            }
        }
    }


    public boolean isReading() {
        return reading;
    }
}
