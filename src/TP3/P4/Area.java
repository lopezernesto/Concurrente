package TP3.P4;

public class Area {
    private int capacidad;
    private String nombre;

    public Area(int c, String nom) {
        capacidad = c;
        nombre = nom;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean reservar(int cant) {
        boolean exit = false;
        if (capacidad - cant >= 0) {
            exit = true;
            capacidad -= cant;
        }
        return exit;
    }
}
