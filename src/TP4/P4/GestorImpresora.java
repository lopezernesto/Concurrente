package TP4.P4;

import java.util.concurrent.Semaphore;

/*
 * Aclaracion: Este ejercicio se podria hacer con un solo metodo de imprimir
 * y que cada impresora tenga su semaforo asi voy liberando el mismo semaforo que tome.
 * Sino la otra opcion(la que estoy haciendo) es que cada persona sepa que impresora esta usando
 * para que en el metodo de liberar, pueda liberar esa misma
 */
public class GestorImpresora {
    private Impresora[] imp;
    // mutex es para cuando todas las impresoras estan ocupadas
    // mutex2 es para que solo se pueda entrar de a uno a la vez
    private Semaphore sem2 = new Semaphore(1), mutex = new Semaphore(1);

    public GestorImpresora(Impresora[] arreglo) {
        imp = arreglo;
    }

    public void imprimir(int impresora) {
        try {
            mutex.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (imp[impresora].getEstado().equals("disponible")) {
            imp[impresora].imprimir();
        } else {
            System.out.println("La impresora " + impresora + " esta ocupada " + Thread.currentThread().getName());
        }
        mutex.release();
    }

    public void terminarImprimir(int impresora) {
        try {
            mutex.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (imp[impresora].getEstado().equals("ocupado"))
            imp[impresora].terminarImprimir();
        else {
            System.out.println("La impresora " + impresora + " ya esta liberada " + Thread.currentThread().getName());
        }
        mutex.release();
    }
    /*
     * public void imprimir() {
     * try {
     * mutex2.acquire();
     * System.out.println("ENTRO al mutex2 " + Thread.currentThread().getName());
     * } catch (Exception e) {
     * // TODO: handle exception
     * }
     * int ocupadas = 0, i = 0;
     * while (i < imp.length) {
     * if (imp[i].getEstado().equals("ocupado")) {
     * ocupadas++;
     * } else {
     * System.out.println("intenta imprimir " + Thread.currentThread().getName());
     * imp[i].imprimir();
     * System.out.println("Esta imprimiendo " + Thread.currentThread().getName());
     * i = imp.length;
     * }
     * i++;
     * }
     * if (ocupadas == imp.length - 1) {
     * try {
     * // Si todas las impresoras estan ocupadas no se puede imprimir
     * mutex.acquire();
     * } catch (Exception e) {
     * // TODO: handle exception
     * }
     * }
     * mutex2.release();
     * System.out.println("SALIO al mutex2 " + Thread.currentThread().getName());
     * }
     * 
     * public void terminarImprimir() {
     * try {
     * mutex2.acquire();
     * System.out.println("ENTRO al mutex2 " + Thread.currentThread().getName());
     * } catch (Exception e) {
     * // TODO: handle exception
     * }
     * int ocupadas = 0, i = 0;
     * while (i < imp.length) {
     * if (imp[i].getEstado().equals("ocupada")) {
     * ocupadas++;
     * }
     * i++;
     * }
     * if (ocupadas == imp.length) {
     * // Si todas las impresoras estaban ocupadas, libero una junto con el permiso
     * imp[0].terminarImprimir();
     * System.out.println(Thread.currentThread().getName() +
     * " Termino de imprimir");
     * mutex.release();
     * } else {
     * imp[ocupadas].terminarImprimir();
     * System.out.println(Thread.currentThread().getName() +
     * " Termino de imprimir");
     * }
     * mutex2.release();
     * System.out.println("SALIO al mutex2 " + Thread.currentThread().getName());
     * }
     */
}
