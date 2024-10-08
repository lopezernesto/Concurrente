package TP4.P4;

import java.util.concurrent.Semaphore;

public class GestorImpresora {
    private Impresora[] imp;
    private Semaphore mutex = new Semaphore(1);

    public GestorImpresora(Impresora[] arreglo) {
        imp = arreglo;
    }

    public void imprimir(int impresora) {
        System.out.println("intenta imprimir " + Thread.currentThread().getName());
        try {
            mutex.acquire();
        } catch (Exception e) {
        }

        if (imp[impresora].getEstado().equals("disponible")) {
            imp[impresora].imprimir();
        } else {
            System.out.println("La impresora " + impresora + " esta ocupada " + Thread.currentThread().getName());
        }
    }

    public void terminarImprimir(int impresora) {
        if (imp[impresora].getEstado().equals("ocupado")) {
            imp[impresora].terminarImprimir();
            mutex.release();
        } else {
            System.out.println("La impresora " + impresora + " ya esta liberada " + Thread.currentThread().getName());
        }
    }
}
