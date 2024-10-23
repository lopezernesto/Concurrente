package TP4.P5;

import java.util.Random;

public class Cliente implements Runnable {
    Gestor objCompartido;

    public Cliente(Gestor g) {
        objCompartido = g;
    }

    @Override
    public void run() {
        while (true) {
            Random rand = new Random();
            char[] opciones = { 'A', 'B', 'X' };
            int indice = rand.nextInt(opciones.length);
            // Si lo parto, tengo que saber en que impresora imprimio, para no liberar otra
            objCompartido.elegirImpresora(opciones[indice]);

        }
    }
}
