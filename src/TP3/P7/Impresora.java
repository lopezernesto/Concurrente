package TP3.P7;

public class Impresora {
    private char turno = 'A';
    String s = "";

    public String getCadena() {
        return s;
    }

    public void imprimeNombre(int cant) {
        switch (turno) {
            case 'A':
                if (turno == 'A')
                    imprimir(cant);
                turno = 'B';
                break;
            case 'B':
                if (turno == 'B')
                    imprimir(cant);
                turno = 'C';
                break;
            case 'C':
                if (turno == 'C')
                    imprimir(cant);
                turno = 'A';
                break;
            default:
                break;
        }
    }

    public synchronized void imprimir(int n) {
        int i = 1;
        while (i <= n) {
            s += Thread.currentThread().getName();
            i++;
        }

    }

}
