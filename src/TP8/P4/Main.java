package TP8.P4;

public class Main {
    public static void main(String[] args) {
        CentroHemoterapia centro = new CentroHemoterapia(6);
        Thread[] clientes = new Thread[20];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Thread(new Cliente(centro), "Cliente " + i);
        }
        for (int i = 0; i < clientes.length; i++) {
            clientes[i].start();
        }
    }
}
