package TP3.P7;

import java.util.Random;

public class A implements Runnable {
    private Impresora i;
    private String nombre;

    public A(Impresora imp, String nombre) {
        i = imp;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        Random ran = new Random();
        int cant = ran.nextInt(10) + 1;
        i.imprimeNombre(cant);
    }
}
