package TP4.P3;

public class Main {
    public static void main(String[] args) {
        OCompartido orden = new OCompartido();
        Proceso p = new Proceso(orden);
        Thread a = new Thread(p, "P1");
        Thread b = new Thread(p, "P2");
        Thread c = new Thread(p, "P3");
        c.start();
        b.start();
        a.start();
    }
}
