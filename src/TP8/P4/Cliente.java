package TP8.P4;

public class Cliente implements Runnable {
    private CentroHemoterapia centro;

    public Cliente(CentroHemoterapia c) {
        centro = c;
    }

    @Override
    public void run() {
        boolean entro, seSento, leyo;
        try {
            entro = centro.entrarCentro();
            if (!entro) {
                // Si no entro primero verifica si se sento
                seSento = centro.salaEspera();
                leyo = centro.tomaRevista();
                Thread.sleep(1000);
                if (seSento) {
                    // Si se sento tiene que devolver la silla
                    centro.devolverSilla();
                }
                if (leyo) {
                    // Si leyo tiene que devolver la revista
                    centro.devolverRevista();
                }
                // trato de entrar nuevamente
                centro.usarCamilla();
            }
            Thread.sleep(1000);
            // tiene que salir
            centro.salirCentro();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void aux() {

    }
}
