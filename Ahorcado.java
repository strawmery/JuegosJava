import java.util.*;

public class Ahorcado {

    public static final String[] palabras = {
        "programacion", "tecnologia", "java", "computadora", 
        "desarrollo", "ahorcado", "sistema", "algoritmo"
    };

    public static final int MAX_INTENTOS = 6;

    public static String elegirPalabra() {
        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }

    public static char[] ocultar(String palabra) {
        char[] ocultarPalabra = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            ocultarPalabra[i] = '_';
        }
        return ocultarPalabra;
    }

    public static boolean verificarLetra(String palabra, char letra, char[] ocultar, Boolean[] letrasAdivinadas) {
        boolean acierto = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra && !letrasAdivinadas[i]) {
                ocultar[i] = letra;
                letrasAdivinadas[i] = true;
                acierto = true;
            }
        }
        return acierto;
    }

    public static int registrarLetraIncorrecta(char letra, ArrayList<Character> letrasIncorrectas, int intentos) {
        if (!letrasIncorrectas.contains(letra)) {
            intentos++;
            letrasIncorrectas.add(letra);
            System.out.println("Letra incorrecta, intentos restantes: " + (MAX_INTENTOS - intentos));
        } else {
            System.out.println("Ya has introducido esa letra.");
        }
        return intentos;
    }

    public static boolean todasAdivinadas(Boolean[] letrasAdivinadas) {
        for (boolean adivinada : letrasAdivinadas) {
            if (!adivinada) {
                return false;
            }
        }
        return true;
    }

    public static void dibujarMonigote(int intentos) {
        switch (intentos) {
            case 0:
                System.out.println("_____");
                System.out.println("|   |");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|_____");
                break;
            case 1:
                System.out.println("_____");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|_____");
                break;
            case 2:
                System.out.println("_____");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|   |");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|_____");
                break;
            case 3:
                System.out.println("_____");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|  /|");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|_____");
                break;
            case 4:
                System.out.println("_____");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|    ");
                System.out.println("|    ");
                System.out.println("|_____");
                break;
            case 5:
                System.out.println("_____");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|  / ");
                System.out.println("|    ");
                System.out.println("|_____");
                break;
            case 6:
                System.out.println("_____");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|  / \\");
                System.out.println("|    ");
                System.out.println("|_____");
                break;
        }
    }

    public static void mostrarEstadoJuego(char[] ocultar, ArrayList<Character> letrasIncorrectas, int intentos) {
        System.out.println("Palabra: " + String.valueOf(ocultar));
        System.out.println("Letras incorrectas: " + letrasIncorrectas);
        dibujarMonigote(intentos);
    }

    public static char introducirLetra(Scanner sc) {
        System.out.print("Introduce una letra: ");
        return sc.nextLine().toLowerCase().charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra = elegirPalabra();
        char[] ocultarPalabra = ocultar(palabra);
        Boolean[] letrasAdivinadas = new Boolean[palabra.length()];
        
        // Inicializar letras adivinadas a false
        for (int i = 0; i < palabra.length(); i++) {
            letrasAdivinadas[i] = false;
        }

        ArrayList<Character> letrasIncorrectas = new ArrayList<>();
        int intentos = 0;

        System.out.println("Bienvenido al Ahorcado");

        while (intentos < MAX_INTENTOS) {
            mostrarEstadoJuego(ocultarPalabra, letrasIncorrectas, intentos);
            char letra = introducirLetra(sc);
            boolean acierto = verificarLetra(palabra, letra, ocultarPalabra, letrasAdivinadas);

            if (!acierto) {
                intentos = registrarLetraIncorrecta(letra, letrasIncorrectas, intentos);
            } else {
                System.out.println("¡Letra correcta!");
            }

            if (todasAdivinadas(letrasAdivinadas)) {
                System.out.println("¡Has adivinado la palabra! Felicidades: " + palabra);
                break;
            }

            if (intentos == MAX_INTENTOS) {
                System.out.println("Has perdido. La palabra correcta era: " + palabra);
                dibujarMonigote(intentos);
            }
        }

        sc.close();
    }
}
