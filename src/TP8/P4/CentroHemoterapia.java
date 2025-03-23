package TP8.P4;

import java.util.concurrent.Semaphore;

public class CentroHemoterapia {
    private Semaphore sillas;
    private Semaphore camillas = new Semaphore(4);
    private Semaphore revistas = new Semaphore(9);
    private int revistasOcupadas = 0;
    private int cantCamillas = 0;
    private int sillasOcupadas = 0;
    private int cantSillas;

    public CentroHemoterapia(int s) {
        sillas = new Semaphore(s);
        cantSillas = s;
    }

    public boolean entrarCentro() {
        boolean exit = true;
        System.out.println("El cliente: " + Thread.currentThread().getName() + " quiere entrar");
        try {
            if (cantCamillas < 4) {
                camillas.acquire();
                cantCamillas++;
                System.out.println("El cliente: " + Thread.currentThread().getName() + " se esta atendiendo");
            } else {
                // Va a la sala de espera
                exit = false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return exit;
    }

    public void usarCamilla() {
        try {
            camillas.acquire();
            cantCamillas++;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirCentro() {
        camillas.release();
        cantCamillas--;
        System.out.println("El cliente: " + Thread.currentThread().getName() + " dejo de atenderse");
    }

    public boolean salaEspera() {
        boolean estaSentado = false;
        System.out.println("El cliente: " + Thread.currentThread().getName() + "  esta en la sala de espera");
        try {
            if (sillasOcupadas < cantSillas) {
                // Puede esperar sentado
                sillas.acquire();
                sillasOcupadas++;
                System.out.println("El cliente: " + Thread.currentThread().getName() + " esta esperando sentado");
                estaSentado = true;
            } else {
                System.out.println("El cliente: " + Thread.currentThread().getName() + " esta esperando parado");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return estaSentado;
    }

    public boolean tomaRevista() {
        System.out.println("El cliente: " + Thread.currentThread().getName() + " intentara tomar una revista");
        boolean leyo = false;
        try {
            if (revistasOcupadas < 9) {
                revistas.acquire();
                revistasOcupadas++;
                leyo = true;
                System.out.println("El cliente: " + Thread.currentThread().getName() + " esta leyendo una revista");
            } else {
                System.out.println("El cliente: " + Thread.currentThread().getName() + " esta mirando tele");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return leyo;
    }

    public void devolverRevista() {
        revistas.release();
        revistasOcupadas--;
        System.out.println("El cliente: " + Thread.currentThread().getName() + " devolvio la revista");
    }

    public void devolverSilla() {
        sillas.release();
        sillasOcupadas--;
        System.out.println("El cliente: " + Thread.currentThread().getName() + " devolvio la silla");
    }
}
