package TP3.P2;

public class Main {
    public static void main(String[] args) {
        Energia energia = new Energia();
        CriaturaOscura criatura = new CriaturaOscura(energia);
        Sanador sanador = new Sanador(energia);
        Thread hiloCriatura = new Thread(criatura, "Criatura Oscura");
        Thread hiloSanador = new Thread(sanador, "Sanador");

        hiloCriatura.start();
        hiloSanador.start();
        try {
            hiloCriatura.join();
            hiloSanador.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(energia.getEnergia() + " De energia");
    }
}
