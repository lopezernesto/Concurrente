package TP3.P3;

public class Plato {
    public Plato() {

    }

    public synchronized void comer() {
        try {
            System.out.println(Thread.currentThread().getName() + " Está comiendo");
            Thread.sleep(300);
            System.out.println(Thread.currentThread().getName() + " Dejó de comer");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
