package TP5.P3;

public class Main {
    public static void main(String[] args) {
        Gato[] gatos = new Gato[5];
        Perro[] perros = new Perro[5];
        Comedor comedor = new Comedor(5);

        // Inicializa los gatos y perros
        for (int i = 0; i < gatos.length; i++) {
            gatos[i] = new Gato(comedor);
            perros[i] = new Perro(comedor);
        }

        // Crea un arreglo de hilos
        Thread[] hilos = new Thread[10];

        // Inicializa hilos para gatos
        for (int i = 0; i < gatos.length; i++) {
            hilos[i] = new Thread(gatos[i], "Gato: " + i);
        }

        // Inicializa hilos para perros
        for (int j = 0; j < perros.length; j++) {
            hilos[gatos.length + j] = new Thread(perros[j], "Perro: " + j);
        }

        // Inicia todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }
    }

}
