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
        Persona p1 = new Persona(g, cant);
        Persona p2 = new Persona(g, cant);
        Persona p3 = new Persona(g, cant);
        Thread[] personas = new Thread[3];

        personas[0] = new Thread(p1, "Agustin");
        personas[1] = new Thread(p2, "Facundo");
        personas[2] = new Thread(p3, "Nicolas");
        for (int i = 0; i < personas.length; i++) {
            personas[i].start();
        }
    }
}
