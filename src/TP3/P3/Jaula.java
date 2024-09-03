package TP3.P3;

public class Jaula {
    private Plato plato;
    private Hamaca hamaca;
    private Rueda rueda;

    public Jaula(Plato p, Hamaca h, Rueda r) {
        plato = p;
        hamaca = h;
        rueda = r;
    }

    public void hamacarse() {
        hamaca.hamacarse();
    }

    public void correr() {
        rueda.correr();
    }

    public void comer() {
        plato.comer();
    }
}
