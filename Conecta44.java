import java.util.Scanner;

public class Conecta44 {
    public static int filas = 6, columnas = 7;
    public static char asterisco = '*', j1 = 'X', j2 = 'O';
    public static char[][] tablero = new char [filas][columnas];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        estadoInicial();
        estadoActual();
        char jugador = j1;
        

    public static void estadoInicial() {
        for (int f = 0, i < filas; i++)
            for (int c = 0, j < columnas; j++)
                tablero[f][c] = asterisco;
    }
    }



    public static void main(String[] args) {
        Tablero();
        char jugadorActual = JUGADOR1;
    }

    public static void Tablero() {
        
        int filas = 6;
        int columnas = 9;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    


}


