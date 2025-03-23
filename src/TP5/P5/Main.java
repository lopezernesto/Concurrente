package TP5.P5;

public class Main {
    public static void main(String[] args) {
        Tren tren = new Tren(5);

        VendedorTicket v = new VendedorTicket(tren);
        Thread vendedor = new Thread(v, "Vendedor");
        vendedor.start();

        ControlTren c = new ControlTren(tren);
        Thread control = new Thread(c, "Control");
        control.start();

        Thread[] hilos = new Thread[25];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Pasajero(tren), "Pasajero: " + i);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
