package TP3.P6;

public class Sumador implements Runnable {
    private int[] subArreglo;
    private int rta, inicio, fin;

    public Sumador(int[] subArreglo, int inicio, int fin) {
        this.subArreglo = subArreglo;
        rta = 0;
        this.fin = fin;
        this.inicio = inicio;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fin; i++) {
            rta += subArreglo[i];
        }
    }

    public int getRta() {
        return rta;
    }
}
