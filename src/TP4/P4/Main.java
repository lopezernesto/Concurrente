package TP4.P4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cant;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de impresoras que haya");
        cant = sc.nextInt();

        Impresora[] arreglo = new Impresora[cant];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = new Impresora();
        }

        GestorImpresora g = new GestorImpresora(arreglo);
        Persona p = new Persona(g, cant);
        Persona n = new Persona(g, cant);
        Persona q = new Persona(g, cant);
        Thread[] personas = new Thread[3];

        personas[0] = new Thread(p, "Agustin");
        personas[1] = new Thread(n, "Facundo");
        personas[2] = new Thread(q, "Nicolas");
        for (int i = 0; i < personas.length; i++) {
            personas[i].start();
        }
    }
}
