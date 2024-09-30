package TP3.P5;

public class Auto extends Vehiculo implements Runnable {
    private Surtidor surtidor;
    private String patente;

    public Auto(String patente, String marca, int modelo, int km, int cantCombustible, Surtidor s) {
        super(marca, modelo, km, cantCombustible);
        this.patente = patente;
        this.surtidor = s;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 7) {
            andar(55);
            i++;
        }
    }

    public String getPatente() {
        return patente;
    }

    private void andar(int cant) {
        if (cantCombustible - cant >= 0) {
            System.out.println("El Auto: " + patente + " esta andando");
            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }
            cantCombustible -= cant;
            km += cant;
            System.out.println("El Auto: " + patente + " dejo de andar");
        } else {
            if (surtidor.cargar(60)) {
                cantCombustible += 60;
            }
        }
    }
}
