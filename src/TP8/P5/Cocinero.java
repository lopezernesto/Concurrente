package TP8.P5;

public class Cocinero implements Runnable {
    private Olla olla;

    public Cocinero(Olla o) {
        olla = o;
    }

    @Override
    public void run() {
        while (true) {
            olla.cocinar();
        }

    }
}
