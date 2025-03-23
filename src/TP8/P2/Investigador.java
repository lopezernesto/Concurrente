package TP8.P2;

public class Investigador implements Runnable {
    private Observatorio observatorio;

    public Investigador(Observatorio o) {
        observatorio = o;
    }

    @Override
    public void run() {
        try {
            observatorio.entraInvestigador();
            Thread.sleep(500);
            observatorio.saleInvestigador();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
