package TP5.P5;

public class VendedorTicket implements Runnable {
    private Tren tren;

    public VendedorTicket(Tren t) {
        tren = t;
    }

    @Override
    public void run() {
        while (true) {
            try {
                tren.venderTicket();
            } catch (Exception ex) {
            }
        }
    }
}
