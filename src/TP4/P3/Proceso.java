package TP4.P3;

public class Proceso implements Runnable {
    OCompartido orden;

    public Proceso(OCompartido ord) {
        orden = ord;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 4) {
            orden.empezar();
            try {
                Thread.sleep(300);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            orden.terminar();
            i++;
        }

    }
}
