package TP4.P5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cant;
        char tipo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de impresoras que cargara: ");
        cant = sc.nextInt();
        Impresora[] arreglo = new Impresora[cant];
        for (int i = 0; i < cant; i++) {
            System.out.println("Ingrese un tipo: ");
            tipo = sc.next().charAt(0);
            arreglo[i] = new Impresora(tipo);
        }
        Cliente cliente[] = new Cliente[5];
        Thread hilos[] = new Thread[5];
        Gestor rc = new Gestor(arreglo);
        for (int i = 0; i < cliente.length; i++) {
            cliente[i] = new Cliente(rc);
            hilos[i] = new Thread(cliente[i], "Cliente " + i);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

    }
}
