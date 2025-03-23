package TP8.P2;

public class Mantenimiento implements Runnable {
    private Observatorio observatorio;

    public Mantenimiento(Observatorio o) {
        observatorio = o;
    }

    @Override
    public void run() {
        try {

            observatorio.entraMantenimiento();
            Thread.sleep(500);
            observatorio.saleMantenimiento();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
