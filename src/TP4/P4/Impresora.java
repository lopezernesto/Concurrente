package TP4.P4;

public class Impresora {
    private String estado = "disponible";

    public void imprimir() {
        System.out.println("Esta imprimiendo " + Thread.currentThread().getName());
        estado = "ocupado";
    }

    public void terminarImprimir() {
        System.out.println(Thread.currentThread().getName() + " Termino de imprimir");
        estado = "disponible";
    }

    public String getEstado() {
        return estado;
    }
}
