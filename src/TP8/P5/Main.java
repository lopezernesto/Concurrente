package TP8.P5;

public class Main {
    public static void main(String[] args) {
        Olla olla = new Olla(50);
        Thread[] canibales = new Thread[110];
        Thread cocinero = new Thread(new Cocinero(olla), "Cocinero");
        for (int i = 0; i < canibales.length; i++) {
            canibales[i] = new Thread(new Canibal(olla), "Canibal" + i);
        }

        for (Thread canibal : canibales) {
            canibal.start();
        }
        cocinero.start();
    }
}
