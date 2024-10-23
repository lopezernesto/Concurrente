package TP4.P5;

import java.util.concurrent.Semaphore;

public class Gestor {
    private Impresora[] impresoras;
    private Semaphore mutex = new Semaphore(1), mutex2 = new Semaphore(1);

    public Gestor(Impresora[] arreglo) {
        impresoras = arreglo;
    }

    public void elegirImpresora(char tipo) {
        switch (tipo) {
            case 'A':
                imprimirA();

                break;
            case 'B':
                imprimirB();
                break;
            case 'X':
                imprimir();
                break;

            default:
                break;
        }
    }

    private void imprimir() {
        System.out.println("Soy: " + Thread.currentThread().getName() + " quiero entrar en 'Imprimir'");
        try {
            mutex.acquire();
        } catch (Exception e) {
        }
        System.out.println("Soy: " + Thread.currentThread().getName() + " entre en 'Imprimir'");
        int impresoraElegida = -1;
        for (int i = 0; i < impresoras.length; i++) {
            if (impresoras[i].tryAcquire()) {
                impresoraElegida = i;
                i = impresoras.length;
            }
        }
        if (impresoraElegida == -1) {
            System.out.println("Todas las impresoras estan ocupadas sr: " + Thread.currentThread().getName());
        } else {
            System.out.println(Thread.currentThread().getName() + " esta imprimiendo en la impresora: "
                    + impresoraElegida + " es del tipo: " + impresoras[impresoraElegida].getTipo());
            try {
                Thread.sleep(1000);
                System.out.println(
                        Thread.currentThread().getName() + " dejo de imprimir en la impresora: "
                                + impresoraElegida + " es del tipo: " + impresoras[impresoraElegida].getTipo());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            impresoras[impresoraElegida].release();
        }
        System.out.println("Soy: " + Thread.currentThread().getName() + " sali de 'Imprimir'");
        mutex.release();
    }

    private void imprimirA() {
        System.out.println("Soy: " + Thread.currentThread().getName() + " quiero entrar en 'ImprimirA'");
        try {
            mutex.acquire();
        } catch (Exception e) {
        }
        System.out.println("Soy: " + Thread.currentThread().getName() + " entre en 'ImprimirA'");
        int impresoraElegida = -1;
        for (int i = 0; i < impresoras.length; i++) {
            if (impresoras[i].getTipo() == 'A' && impresoras[i].tryAcquire()) {
                impresoraElegida = i;
                i = impresoras.length;
            }
        }
        if (impresoraElegida == -1) {
            System.out.println("Todas las impresoras del tipo A ocupadas sr: " + Thread.currentThread().getName());
        } else {
            System.out.println(Thread.currentThread().getName() + " esta imprimiendo en la impresora: "
                    + impresoraElegida);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " dejo de imprimir en la impresora: "
                    + impresoraElegida);
        }
        mutex.release();
    }

    private void imprimirB() {
        System.out.println("Soy: " + Thread.currentThread().getName() + " quiero entrar en 'ImprimirB'");
        try {
            mutex2.acquire();
        } catch (Exception e) {
        }
        System.out.println("Soy: " + Thread.currentThread().getName() + " entre en 'ImprimirB'");
        int impresoraElegida = -1;
        for (int i = 0; i < impresoras.length; i++) {
            if (impresoras[i].getTipo() == 'B' && impresoras[i].tryAcquire()) {
                impresoraElegida = i;
                i = impresoras.length;
            }
        }
        if (impresoraElegida == -1) {
            System.out.println("Todas las impresoras tipo B estan ocupadas sr: " + Thread.currentThread().getName());
        } else {
            System.out.println(Thread.currentThread().getName() + " esta imprimiendo en la impresora: "
                    + impresoraElegida);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " dejo de imprimir en la impresora: "
                    + impresoraElegida);
        }
        mutex2.release();
    }
}
