package TP5.P5;

import java.util.concurrent.Semaphore;

public class Tren {

    private int capacidad, cantActual = 0;
    private Semaphore puedeSubir;
    private Semaphore mutex = new Semaphore(1);

    public Tren(int c) {
        capacidad = c;
        puedeSubir = new Semaphore(c);
    }

    public void comprarTicket() {
        try {
            mutex.acquire();
            System.out.println("El cliente: " + Thread.currentThread().getName() + " quiere comprar un ticket");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void venderTicket() throws InterruptedException {
        Semaphore semTicket;
        semTicket.acquire();
        System.out.println("Se vendio un Ticket");
        semAcceso.release();
    }

    public void entrar(String nombre) throws InterruptedException {
        semAcceso.acquire();
        System.out.println("El Cliente " + nombre + " tiene su ticket, esperando a entrar");
        semAsientos.acquire();
        System.out.println("El Cliente " + nombre + " entro al Tren");
        semViaje.release();
    }

    public void iniciarRecorrido() throws InterruptedException {
        semViaje.acquire(capacidad);
        System.out.println("--------------- El Tren Turistico inicio el Recorrido ---------------");
        Thread.sleep(1000);
        System.out.println("--------------- El Tren Turistico finalizo el Recorrido ---------------");
        semSalida.release(capacidad);
    }

    public void bajar(String nombre) throws InterruptedException {
        semSalida.acquire();
        mutex.acquire();
        System.out.println("El Cliente " + nombre + " se bajo del Tren");
        salieron++;
        mutex.release();
        // Una vez que salgan todos, empiezan a subir los que quieren entrar
        if (salieron == capacidad) {
            semAsientos.release(capacidad);
            salieron = 0;
        }
    }

}
