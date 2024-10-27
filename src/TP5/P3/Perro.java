package TP5.P3;

public class Perro implements Runnable {
    private Comedor comedor;

    public Perro(Comedor c) {
        comedor = c;
    }

    public void run() {
        while (true) {
            comedor.comePerro();
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
