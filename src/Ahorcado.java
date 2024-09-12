import java.util.Scanner;

public class Ahorcado {
    Scanner sc = new Scanner(System.in);

    private String palabraSecreta = "inteligencia";
    private String resplado = palabraSecreta;
    private int intentosMaximos = 10;
    private int intentos = 1;
    private boolean palabraAdivinada = false;
    private char letra;
    private char[] letrasAdivinadas = new char[palabraSecreta.length()];

    public void PedirDatos() {
        if (ComprovacionGanar()) {
            System.out.println("Tu ganas");
            return;
        } else {
            try {
                System.out.println("Digite una letra...");
                letra = sc.next().charAt(0);
            } catch (Exception e) {
                System.out.println("¡¡¡NO SE PUEDEN DAR SALTOS DE LINEA!!!");
            } finally {
                Comprovacion(letra);
            }
        }
    }

    public void RellenarEspacios() {
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
    }

    private void Comprovacion(char letra) {
        if (palabraSecreta.indexOf(letra) == -1 && Conteo(intentos)) {
            System.out.println("La letra no esta dento de la palabra secreta");
            intentos++;
            PedirDatos();
        } else if (Conteo(intentos)) {
            System.out.println("EXELENTE");
            letrasAdivinadas[palabraSecreta.indexOf(letra)] = letra;
            palabraSecreta = RemoverLetra(letra);
            MostarLetrasEncontradas();
            System.out.println();
            PedirDatos();
            ComprovacionGanar();
        } else {
            System.out.println("GAME OVER");
        }
    }

    private void MostarLetrasEncontradas() {
        for (char c : letrasAdivinadas) {
            System.out.print(c);
        }
    }

    private String RemoverLetra(char letra) {
        return palabraSecreta.replaceFirst(Character.toString(letra), "*");
    }

    private boolean Conteo(int contador) {
        boolean sePuede = contador != intentosMaximos ? true : false;
        return sePuede;
    }

    private boolean ComprovacionGanar() {
        String palabra = "";
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            palabra += letrasAdivinadas[i];
        }

        palabraAdivinada = palabra.equals(resplado);
        return palabraAdivinada;
    }

}