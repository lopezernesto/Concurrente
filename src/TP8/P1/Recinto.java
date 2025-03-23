package TP8.P1;

import java.util.concurrent.Semaphore;

public class Recinto {
    private Semaphore mostradorPostre = new Semaphore(3);
    private Semaphore mostradorAlmuerzo = new Semaphore(5);
    private Semaphore destapador = new Semaphore(10);

    public Recinto() {

    }

    public void almorzar() {
        System.out.println("El hilo: " + Thread.currentThread().getName() + " entro al recinto para almorzar");
        try {
            mostradorAlmuerzo.acquire();
            System.out.println("El hilo: " + Thread.currentThread().getName() + " esta almorzando");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void dejarDeAlmorzar() {
        mostradorAlmuerzo.release();
        System.out.println("El hilo: " + Thread.currentThread().getName() + " dejo de almorzar");
    }

    public void comerPostre() {
        System.out.println("El hilo: " + Thread.currentThread().getName() + " entro al recinto para almorzar");
        try {
            mostradorPostre.acquire();
            System.out.println("El hilo: " + Thread.currentThread().getName() + " esta comiendo el postre");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void terminarPostre() {
        mostradorPostre.release();
        System.out.println("El hilo: " + Thread.currentThread().getName() + " dejo de comer el postre");
    }

    public void usarDestapador() {
        System.out.println("El hilo: " + Thread.currentThread().getName() + " quiere usar el destapador");
        try {
            destapador.acquire();
            System.out.println("El hilo: " + Thread.currentThread().getName() + " esta usando el destapador");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void dejarDestapador() {
        destapador.release();
        System.out.println("El hilo: " + Thread.currentThread().getName() + " dejo el destapador");
    }
}
