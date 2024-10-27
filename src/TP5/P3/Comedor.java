package TP5.P3;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore comenGatos;
    private Semaphore comenPerros;
    private int contadorPerros = 0, contadorGatos = 0; // Cuenta cuantos gatos / perros comieron
    private int perrosEnComedor = 0, gatosEncomedor = 0;
    private Semaphore mutex = new Semaphore(1);
    private int platos;
    private boolean cambio = false;

    public Comedor(int cant) {
        platos = cant;
        comenGatos = new Semaphore(cant);
        comenPerros = new Semaphore(0);
    }

    public void comePerro() {
        System.out.println("El hilo: " + Thread.currentThread().getName() + " quiere entrar a comer");
        try {
            mutex.acquire();
            comenPerros.acquire();
            if (perrosEnComedor < 7) {
                System.out.println("El hilo: " + Thread.currentThread().getName() + " esta comiendo");
                contadorPerros++;
                perrosEnComedor++;
                if (contadorPerros == 7) {
                    System.out.println("Es hora de que coman los perros");
                    cambio = true;
                }
                perrosEnComedor--;
                comenPerros.release();
                System.out.println("El hilo: " + Thread.currentThread().getName() + " dejo de comer");
                if (cambio && perrosEnComedor == 0) {
                    contadorPerros = 0;
                    comenPerros.release(platos);
                    comenGatos.acquire(platos);
                    cambio = false;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            mutex.release();
        }

    }

    public void comeGato() {
        System.out.println("El hilo: " + Thread.currentThread().getName() + " quiere entrar a comer");
        try {
            mutex.acquire();
            comenGatos.tryAcquire(1);
            System.out.println("El hilo: " + Thread.currentThread().getName() + " esta comiendo");
            contadorGatos++;
            gatosEncomedor++;
            if (contadorGatos == 7) {
                System.out.println("Es hora de que coman los perros");
                cambio = true;
            }
            gatosEncomedor--;
            comenGatos.release();
            System.out.println("El hilo: " + Thread.currentThread().getName() + " dejo de comer");
            if (cambio && gatosEncomedor == 0) {
                contadorGatos = 0;
                comenGatos.release(platos);
                comenPerros.acquire(platos);
                cambio = false;
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            mutex.release();
        }

    }
}
