package TP3.P5;

public class Surtidor {
    private int combustible;

    public Surtidor(int combustible) {
        this.combustible = combustible;
    }

    public synchronized boolean cargar(int cant) {
        boolean exit = false;
        if (combustible - cant >= 0) {
            System.out.println("El Auto: " + Thread.currentThread().getName() + " esta usando el surtidor");
            combustible -= cant;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exit = true;
            System.out.println("El Auto: " + Thread.currentThread().getName() + " dejo de usar el surtidor");
        } else {
            System.out.println("El surtidor se quedó sin nafta " + Thread.currentThread().getName());
        }
        return exit;
    }
}
