package TP5.P1;

public class Persona implements Runnable {
    private GestorPiscina gestor;

    public Persona(GestorPiscina g) {
        gestor = g;
    }

    public void run() {
        while (true) {
            gestor.entrar();
            try {
                Thread.sleep(300);

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
