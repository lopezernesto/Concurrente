package TP4.P3;

import java.util.concurrent.Semaphore;

public class OCompartido {
    private Semaphore p1p2 = new Semaphore(1), p2p3 = new Semaphore(0), p3p1 = new Semaphore(0);

    public void empezar() {
        switch (Thread.currentThread().getName()) {
            case "P1":
                metodo1();
                break;
            case "P2":
                metodo2();
                break;
            case "P3":
                metodo3();
                break;
            default:
                break;
        }
    }

    private void metodo1() {
        try {
            p1p2.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Empezo el programa " + Thread.currentThread().getName());

    }

    private void metodo2() {
        try {
            p2p3.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Empezo el programa " + Thread.currentThread().getName());
    }

    private void metodo3() {
        try {
            p3p1.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("Empezo el programa " + Thread.currentThread().getName());
    }

    public void terminar() {
        switch (Thread.currentThread().getName()) {
            case "P1":
                metodo1t();
                break;
            case "P2":
                metodo2t();
                break;
            case "P3":
                metodo3t();
                break;

            default:
                break;
        }
    }

    private void metodo1t() {
        System.out.println("Termino el programa " + Thread.currentThread().getName());
        p2p3.release();
    }

    private void metodo2t() {
        System.out.println("Termino el programa " + Thread.currentThread().getName());
        p3p1.release();
    }

    private void metodo3t() {
        System.out.println("Termino el programa " + Thread.currentThread().getName());
        p1p2.release();
    }
}
