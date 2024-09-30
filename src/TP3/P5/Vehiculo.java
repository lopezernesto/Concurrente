package TP3.P5;

public class Vehiculo {
    protected String marca;
    protected int modelo, km, cantCombustible;

    public Vehiculo(String marca, int modelo, int km, int cantCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.km = km;
        this.cantCombustible = cantCombustible;
    }

    public String getMarca() {
        return marca;
    }
}
