package TP3.P4;

public class Parque {
    private Area[] areas;

    public Parque(Area[] a) {
        areas = a;
    }

    public Area getArea(int num) {
        return areas[num];
    }

    public int cantidadArea() {
        return areas.length;
    }

    public synchronized void reservarArea(Area a, int cant) {
        if (!a.reservar(cant)) {
            System.out.println(Thread.currentThread().getName() + " no hay cupos para el area: " + a.getNombre());
        } else {
            System.out.println("El visitante " + Thread.currentThread().getName() + " compro " + cant
                    + " tickets para el area" + a.getNombre());
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
