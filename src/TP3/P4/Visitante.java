package TP3.P4;

import java.util.Random;

public class Visitante implements Runnable {
    private Parque parque;

    public Visitante(Parque p) {
        parque = p;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 4) {
            Random r = new Random();
            int area = r.nextInt(parque.cantidadArea());
            int cant = r.nextInt(5) + 1;
            parque.reservarArea(parque.getArea(area), cant);
            i++;
        }

    }
}
