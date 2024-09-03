package TP3.P3;

public class Hamster implements Runnable {
    private Jaula jaula;

    public Hamster(Jaula j) {
        jaula = j;
    }

    @Override
    public void run() {
        int i = 0;
        while (i <= 5) {
            jaula.comer();
            jaula.correr();
            jaula.hamacarse();
            i++;
        }
    }
}