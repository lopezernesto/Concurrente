package TP3.P6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int rta = 0;
        int[] arreglo = new int[50000];
        for (int i = 0; i < arreglo.length; i++) {
            int aux = r.nextInt(10) + 1;
            arreglo[i] = aux;
            rta += aux;
        }

        Sumador uno = new Sumador(arreglo, 0, 10000);
        Sumador dos = new Sumador(arreglo, 10000, 20000);
        Sumador tres = new Sumador(arreglo, 20000, 30000);
        Sumador cuatro = new Sumador(arreglo, 30000, 40000);
        Sumador cinco = new Sumador(arreglo, 40000, 50000);
        Sumador[] arrSumadores = { uno, dos, tres, cuatro, cinco };
        Thread[] threads = new Thread[5];

        for (int i = 0; i < arrSumadores.length; i++) {
            threads[i] = new Thread(arrSumadores[i]);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        try {
            threads[0].join();
            threads[1].join();
            threads[2].join();
            threads[3].join();
            threads[4].join();

            int rtaHilos = 0;
            for (int i = 0; i < arrSumadores.length; i++) {
                rtaHilos += arrSumadores[i].getRta();
            }
            System.out.println("La respuesta es: " + rta + " la respuesta de los hilos es: " + rtaHilos);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
