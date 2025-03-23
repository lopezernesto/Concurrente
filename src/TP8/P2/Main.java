package TP8.P2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Observatorio observatorio = new Observatorio(50);
        boolean[] arr = { false, true };
        Thread[] investigadores = new Thread[3];
        Thread[] mantenimiento = new Thread[6];
        Thread[] visitantes = new Thread[100];

        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i] = new Thread(new Visitante(observatorio, arr[new Random().nextInt(2)]), "Visitante: " + i);
        }
        for (int i = 0; i < mantenimiento.length; i++) {
            mantenimiento[i] = new Thread(new Mantenimiento(observatorio), "Mantenimiento: " + i);
        }
        for (int i = 0; i < investigadores.length; i++) {
            investigadores[i] = new Thread(new Investigador(observatorio), "Investigador: " + i);
        }
        for (Thread thread : mantenimiento) {
            thread.start();
        }
        for (Thread thread : visitantes) {
            thread.start();
        }
        for (Thread thread : investigadores) {
            thread.start();
        }
    }
}
