package TP4.P6;

import java.util.concurrent.Semaphore;

public class Taxi {
    private Semaphore taxista = new Semaphore(0);// 0 despierta / 1 duerme el taxista
    private Semaphore pasajero = new Semaphore(0);// se 0 sube / 1 baja al taxi

    public Taxi() {

    }

    public void subirTaxi() {
        taxista.release();
        System.out.println("El pasajero se subio al taxi");
        try {
            pasajero.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void andar() {
        System.out.println("El taxista esta durmiendo");
        try {
            taxista.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("El taxista esta andando");
    }

    public void dejarDeAndar() {
        System.out.println("El taxista dejará de andar");
        pasajero.release();

    }

    public void bajarTaxi() {
        System.out.println("El cliente se bajo del taxi");
    }

}
