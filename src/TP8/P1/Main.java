package TP8.P1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Recinto recinto = new Recinto();
        Thread[] hilos = new Thread[100];
        boolean[] postre = { true, false };
        for (int i = 0; i < hilos.length; i++) {
            int aux = new Random().nextInt(2);
            hilos[i] = new Thread(new Soldado(recinto, postre[aux]), "Soldado " + i);
        }
        for (Thread thread : hilos) {
            thread.start();
        }
    }
}
