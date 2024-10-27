package TP5.P1;

public class Main {
    public static void main(String[] args) {
        GestorPiscina g = new GestorPiscina(3);
        Persona[] personas = new Persona[10];
        Thread[] hilos = new Thread[10];
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona(g);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(personas[i], "Hilo: " + i);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

    }
}
