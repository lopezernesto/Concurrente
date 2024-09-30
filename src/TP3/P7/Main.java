package TP3.P7;

public class Main {
    public static void main(String[] args) {
        Impresora i = new Impresora();
        A uno = new A(i, "A");
        B dos = new B(i, "B");
        C tres = new C(i, "C");

        Thread a = new Thread(uno, uno.getNombre());
        Thread b = new Thread(dos, dos.getNombre());
        Thread c = new Thread(tres, tres.getNombre());
        a.start();
        b.start();
        c.start();
        try {
            a.join();
            b.join();
            c.join();
            System.out.println(i.getCadena());
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
