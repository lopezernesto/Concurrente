package TP8.ParcialesViejos.Exposicion;

import java.util.concurrent.locks.*;

import TP3.P7.C;

public class Sala {
    private int capacidad;
    private int personasEnSala = 0;
    private int visitantesEsperando = 0;
    private int criticosEsperando = 0;
    private int responsablesEsperando = 0;
    private boolean banderaVisitante = true;
    private boolean banderaCritico = true;
    private boolean banderaResponsable = true;
    private Lock lock = new ReentrantLock();
    private Condition visitante = lock.newCondition();
    private Condition critico = lock.newCondition();
    private Condition responsable = lock.newCondition();

    public Sala(int c) {
        capacidad = c;
    }

    public void entraVisitante() {
        try {
            System.out.println("El visitante: " + Thread.currentThread().getName() + " quiere entrar a la sala");
            lock.lock();
            visitantesEsperando++;
            while (!banderaVisitante || personasEnSala >= capacidad) {
                visitante.wait();
            }
            // pudo entrar
            visitantesEsperando--;
            if (personasEnSala == 0) {
                banderaCritico = false;
            }

            personasEnSala++;
            System.out.println("El visitante: " + Thread.currentThread().getName() + " entro a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void saleVisitante() {
        try {
            System.out.println("El visitante: " + Thread.currentThread().getName() + " quiere salir");
            lock.lock();
            personasEnSala--;
            System.out.println("El visitante: " + Thread.currentThread().getName() + " salio de la sala");
            if (criticosEsperando > 0) {
                banderaResponsable = false;
                banderaVisitante = false;
            }
            if (personasEnSala == 0) {
                banderaCritico = true;
                critico.signalAll();
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {

            lock.unlock();
        }
    }

    public void saleCrico() {
        try {
            lock.lock();
            personasEnSala--;
            if (personasEnSala == 0) {
                banderaCritico = false;
                banderaResponsable = true;
                banderaVisitante = true;
                visitante.signalAll();
                responsable.signalAll();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void saleResponsable() {
        try {
            lock.lock();

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void entraResponsable() {
        try {
            lock.lock();
            System.out.println("El Responsalbe: " + Thread.currentThread().getName() + " quiere entrar a la sala");
            responsablesEsperando++;
            while (!banderaResponsable || personasEnSala >= capacidad) {
                responsable.wait();
            }
            responsablesEsperando--;
            if (personasEnSala == 0) {
                banderaCritico = false;
            }
            personasEnSala++;
            System.out.println("El Responsalbe: " + Thread.currentThread().getName() + " entro a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }

    public void entraCritico() {
        try {
            System.out.println("QUIERE ENTRAR EL CRITICO: " + Thread.currentThread().getName());
            lock.lock();
            criticosEsperando++;
            while (!banderaCritico || personasEnSala >= capacidad) {
                critico.wait();
            }
            criticosEsperando--;
            if (personasEnSala == 0) {
                banderaResponsable = false;
                banderaVisitante = false;
            }
            // pudo entrar
            personasEnSala++;
            System.out.println("ENTRO EL CRITICO: " + Thread.currentThread().getName());
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
        }
    }
}
