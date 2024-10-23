package TP4.P6;

public class Taxista implements Runnable {
    Taxi t;

    public Taxista(Taxi t) {
        this.t = t;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            t.andar();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            t.dejarDeAndar();
        }
    }
}
