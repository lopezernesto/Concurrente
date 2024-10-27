package TP5.P1;

import java.util.concurrent.Semaphore;

public class GestorPiscina {
  private Semaphore capacidad;

  public GestorPiscina(int limite) {
    capacidad = new Semaphore(limite);
  }

  public void entrar() {
    System.out.println("La persona: " + Thread.currentThread().getName() + " entro en la piscina");
    try {
      if (capacidad.tryAcquire(1)) {
        System.out.println("La persona: " + Thread.currentThread().getName() + " se esta bañando");
        salir();
      }
    } catch (Exception e) {
      // TODO: handle exception
    }

  }

  private void salir() {
    capacidad.release();
    System.out.println("La persona: " + Thread.currentThread().getName() + " salio de la piscina");
  }

}
