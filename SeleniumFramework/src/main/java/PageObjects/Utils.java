package PageObjects;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static String generateRandomEmail(){
        String opciones = "abcdefghijklmnopqrstuvwxyz1234567890";
        String cadena = "";
        String correo = "";
        for (int x = 0; x < 10; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, opciones.length() - 1);
            char caracterAleatorio = opciones.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
            correo = cadena+"@correo.com";
        }
        return correo;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

   public static double extraePrecios(String precioTexto){
        char [] caracter = precioTexto.toCharArray();
        String n = "";
        for (int i = 0;i<caracter.length;i++){
            if (Character.isDigit(caracter[i])){
                n+=caracter[i];
            }
            if (caracter[i] == '.'){
                n+=caracter[i];
            }
            if (caracter[i]=='\n'){
                break;
            }
        }
        double valorPrecio = Double.parseDouble(n);
        return valorPrecio;
   }

}
