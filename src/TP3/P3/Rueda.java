package TP3.P3;

public class Rueda {
    public Rueda() {

    }

    public synchronized void correr() {
        try {
            System.out.println(Thread.currentThread().getName() + " Está corriendo");
            Thread.sleep(300);
            System.out.println(Thread.currentThread().getName() + " Dejó de correr");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
