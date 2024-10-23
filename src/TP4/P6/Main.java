package TP4.P6;

public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Taxista t = new Taxista(taxi);
        Cliente c = new Cliente(taxi);
        Thread taxista = new Thread(t, "Jejox");
        Thread cliente = new Thread(c, "Erick");
        cliente.start();
        taxista.start();
    }
}
