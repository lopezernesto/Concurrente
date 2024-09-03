package TP3.P3;

public class Main {
    public static void main(String[] args) {
        Hamaca h = new Hamaca();
        Plato p = new Plato();
        Rueda r = new Rueda();
        Jaula j = new Jaula(p, h, r);
        Hamster uno = new Hamster(j);
        Hamster dos = new Hamster(j);
        Hamster tres = new Hamster(j);
        Hamster cuatro = new Hamster(j);
        Thread tUno = new Thread(uno, "Pepe");
        Thread tDos = new Thread(dos, "Juan");
        Thread tTres = new Thread(tres, "Jose");
        Thread tCuatro = new Thread(cuatro, "Carlos");
        tUno.start();
        tDos.start();
        tTres.start();
        tCuatro.start();
    }
}
