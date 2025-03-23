package TP5.P5;

public class Pasajero implements Runnable {
    private Tren tren;

    public Pasajero(Tren t) {
        tren = t;
    }

    @Override
    public void run() {
        try {
            tren.comprarTicket(Thread.currentThread().getName());
            tren.entrar(Thread.currentThread().getName());
            tren.bajar(Thread.currentThread().getName());
        } catch (Exception ex) {
        }
    }
}
