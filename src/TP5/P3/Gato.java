package TP5.P3;

public class Gato implements Runnable {
    private Comedor comedor;

    public Gato(Comedor c) {
        comedor = c;
    }

    @Override
    public void run() {
        while (true) {
            comedor.comeGato();
        }
    }
}
