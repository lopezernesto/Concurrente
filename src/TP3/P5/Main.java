package TP3.P5;

public class Main {
    public static void main(String[] args) {
        Surtidor s = new Surtidor(1000);

        Auto a = new Auto("ABC-123", null, 2009, 10, 60, s);
        Auto b = new Auto("ABD-130", null, 2010, 0, 30, s);
        Auto c = new Auto("ADA-133", null, 2013, 1, 50, s);
        Auto d = new Auto("ABC-166", null, 2005, 0, 0, s);
        Auto e = new Auto("ADD-999", null, 2000, 40, 40, s);

        Auto[] arreglo = { a, b, c, d, e };
        Thread[] threads = new Thread[5];
        for (int i = 0; i < arreglo.length; i++) {
            threads[i] = new Thread(arreglo[i], arreglo[i].getPatente());
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
