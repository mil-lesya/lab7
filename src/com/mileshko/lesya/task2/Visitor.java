package com.mileshko.lesya.task2;

public class Visitor extends Thread{
    private boolean reading = false;
    private TablePool<Table> pool;

    public Visitor(TablePool<Table> pool)  {
        this.pool = pool;
    }

    public Visitor( ) {
    }

    public void run() {
        Table table = null;
        try {
            table = pool.getResource(51);
            reading = true;
            System.out.println("Посетитель #" + this.getId() + " сидит за столом" + table.getIdTable());
            table.using();
        } catch (Exception e) {
            System.out.println("Посетитель #" + this.getId() + " ожидает" );
        } finally {
            if (table != null) {
                reading = false;
                pool.returnResource(table);
            }
            }
        }
}
