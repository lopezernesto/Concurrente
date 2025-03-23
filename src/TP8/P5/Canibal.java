package TP8.P5;

public class Canibal implements Runnable {
    private Olla olla;

    public Canibal(Olla o) {
        olla = o;
    }

    @Override
    public void run() {
        try {
            if (!olla.comer()) {
                olla.despertarCocinero();
                olla.comer();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
