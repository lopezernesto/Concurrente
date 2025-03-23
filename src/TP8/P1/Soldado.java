package TP8.P1;

import java.util.Random;

public class Soldado implements Runnable {
    private Recinto recinto;
    boolean quierePostre;

    public Soldado(Recinto r, boolean postre) {
        recinto = r;
        quierePostre = postre;
    }

    @Override
    public void run() {
        try {
            char[] arreglo = { 'x', 'b' };
            int opcion = new Random().nextInt(2);
            char bebida = arreglo[opcion];
            recinto.almorzar();
            if (bebida == 'g') {
                recinto.usarDestapador();
                Thread.sleep(1000);
                recinto.dejarDestapador();
            }
            recinto.dejarDeAlmorzar();
            if (quierePostre) {
                recinto.comerPostre();
                Thread.sleep(1000);
                recinto.terminarPostre();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
