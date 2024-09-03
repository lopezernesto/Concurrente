package TP3.P3;

public class Hamaca {
    public Hamaca() {
    }

    public synchronized void hamacarse() {
        try {
            System.out.println(Thread.currentThread().getName() + " Se está hamacando");
            Thread.sleep(300);
            System.out.println(Thread.currentThread().getName() + " Dejó de hamacarse");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
