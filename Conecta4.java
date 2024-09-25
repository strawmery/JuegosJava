import java.util.Scanner;

public class Conecta4 {
    

    
    // PASO 1: declaración de variables
    public static int filas = 6, columnas = 7;
    public static char asterisco = '*', j1 = 'X', j2 = 'O';
    public static char[][] tablero = new char [filas][columnas];
    public static Scanner sc = new Scanner(System.in);



    //PASO 2: métodos
    public static void estadoInicial() {
        for (int f = 0, i < filas; i++)
            for (int c = 0, j < columnas; j++)
                tablero[f][c] = asterisco;
    }
    
    public static void estadoActual() {
        for()

    }

    public static int verificar() {
        int columna;
        do {
            System.out.print("Elige dónde insertar ficha (0-6): ");
        }
    }

    public static boolean ponerFicha(int columna, char ficha) {
        for(int i = filas ; i >= 0; i--) {
            if(tablero[i][columna] == asterisco) {
                tablero[i][columna] = ficha;
                return true;
            }
        }
        return false; // si no encuentro una posición para colocar la ficha retorno false
    }

    //PASO 3: programa principal (método "main")
    public static void main(String[] args) {
        estadoInicial();
        estadoActual();
        char jugador = j1;
        boolean finalJuego = true; 

    while (finalJuego != true) {
        System.out.println("Presiona una tecla " + (jugador == j1 ? "Jugador 1" : "Jugador 2"));
        int columna = leerColumna();

        if

    }

}









}
