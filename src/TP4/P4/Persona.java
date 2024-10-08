package TP4.P4;

import java.util.Random;

public class Persona implements Runnable {
    private GestorImpresora g;
    private int cantImpresoras;

    public Persona(GestorImpresora g, int impresoras) {
        this.g = g;
        cantImpresoras = impresoras;
    }

    @Override
    public void run() {
        while (true) {
            Random ran = new Random();
            int imp = ran.nextInt(cantImpresoras);
            // Si lo parto, tengo que saber en que impresora imprimio, para no liberar otra
            g.imprimir(imp);
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                // TODO: handle exception
            }
            g.terminarImprimir(imp);
        }

    }
}
