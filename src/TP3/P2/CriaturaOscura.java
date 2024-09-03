package TP3.P2;

public class CriaturaOscura implements Runnable {
    private Energia energia;

    public CriaturaOscura(Energia en) {
        energia = en;
    }

    @Override
    public void run() {
        int i = 0;
        while (i <= 4) {
            energia.dañar();
            System.out.println(Thread.currentThread().getName() + " dañó al objetivo en 3 unidades");
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                // TODO: handle exception
            }
            i++;
        }

    }
}
