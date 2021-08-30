package PageObjects;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        String correo = generateRandomEmail();
        System.out.println(correo);
    }


    public static String generateRandomEmail() {
        // El banco de caracteres
        String banco = "abcdefghijklmnopqrstuvwxyz1234567890";
        String cadena = "";
        String correo = "";
        for (int x = 0; x < 10; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
            correo = cadena+"@correo.com";
        }
        return correo;
        //return "asdfasdfads";
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
