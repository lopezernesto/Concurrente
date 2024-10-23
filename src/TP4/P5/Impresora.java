package TP4.P5;

import java.util.concurrent.Semaphore;

public class Impresora extends Semaphore {
    private char tipo;

    public Impresora(char tipo) {
        super(1);
        this.tipo = tipo;
    }

    public char getTipo() {
        return tipo;
    }
}
