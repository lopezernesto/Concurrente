package TP8.P5;

import java.util.concurrent.Semaphore;

public class Olla {
    private int cantRaciones, totalRaciones;
    private Semaphore raciones;
    private Semaphore cocinero = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);

    public Olla(int cant) {
        totalRaciones = cant;
        cantRaciones = cant;
        raciones = new Semaphore(cant);
    }

    public boolean comer() {
        boolean llamarCocinero = false;
        try {
            mutex.acquire();
            if (cantRaciones > 0) {
                raciones.acquire();
                System.out.println("El cannibal: " + Thread.currentThread().getName() + " esta comiendo");
                cantRaciones--;
            } else {
                llamarCocinero = true;
            }
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return llamarCocinero;
    }

    public void despertarCocinero() {
        try {
            cocinero.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void cocinar() {
        try {
            cocinero.acquire();
            System.out.println("El cocinero esta cocinando");
            cantRaciones = totalRaciones;
            raciones.release(totalRaciones);
            System.out.println("dejo de cocinar");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
