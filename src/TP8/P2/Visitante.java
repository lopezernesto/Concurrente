package TP8.P2;

public class Visitante implements Runnable {
    private Observatorio observatorio;
    private boolean silla;

    public Visitante(Observatorio o, boolean silla) {
        observatorio = o;
        this.silla = silla;
    }

    @Override
    public void run() {
        try {
            observatorio.visitar(silla);
            Thread.sleep(500);
            observatorio.salirVisita(silla);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
