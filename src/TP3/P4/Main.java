package TP3.P4;

public class Main {
    public static void main(String[] args) {

        Area[] areas = new Area[4];
        Visitante[] visitantes = new Visitante[4];
        for (int i = 0; i < areas.length; i++) {
            areas[i] = new Area(10, "Area " + i);
        }
        Parque p = new Parque(areas);
        for (int j = 0; j < visitantes.length; j++) {
            visitantes[j] = new Visitante(p);
        }

        Thread[] threadsVisitantes = new Thread[4];
        for (int h = 0; h < threadsVisitantes.length; h++) {
            threadsVisitantes[h] = new Thread(threadsVisitantes[h], "Thread " + h);
        }
        for (int i = 0; i < threadsVisitantes.length; i++) {
            threadsVisitantes[i].start();
        }

    }
}
