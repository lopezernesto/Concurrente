package TP5.P5;

public class ControlTren implements Runnable {
    private Tren tren;

    public ControlTren(Tren t) {
        tren = t;
    }

    @Override
    public void run() {
        while (true) {
            try {
                tren.iniciarRecorrido();
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
