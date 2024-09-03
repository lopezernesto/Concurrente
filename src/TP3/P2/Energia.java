package TP3.P2;

public class Energia {
    private int cantidad = 10;

    public Energia() {

    }

    public synchronized void sanar() {
        cantidad += 3;
    }

    public synchronized void dañar() {
        cantidad -= 3;
    }

    public int getEnergia() {
        return cantidad;
    }
}
