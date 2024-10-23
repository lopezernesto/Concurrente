package TP4.P6;

public class Cliente implements Runnable {
    Taxi t;

    public Cliente(Taxi t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true) {
            t.subirTaxi();
            t.bajarTaxi();
        }

    }
}
