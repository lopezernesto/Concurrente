package TP3.P2;

public class Sanador implements Runnable {
    private Energia energia;

    public Sanador(Energia en) {
        energia = en;
    }

    @Override
    public void run() {
        int i = 0;
        while (i <= 4) {
            energia.sanar();
            System.out.println(Thread.currentThread().getName() + " revitalizó 3 de energia");
            i++;
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}
