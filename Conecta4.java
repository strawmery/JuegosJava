import java.util.Scanner;

public class Conecta4 {
    

    
    // PASO 1: declaración de variables
    public static char j1 = 'X';
    public static char j2 = 'O';
    public static char[] jugadores = {j1, j2};
    public static int jugadorActual = 0;
    public static int filas = 6;
    public static int columnas = 7;
    public static char asterisco = '*';
    public static char[][] tablero = new char [filas][columnas];
    public static Scanner sc = new Scanner(System.in);
    public static boolean juegoTerminado = false;



    //PASO 2: métodos
    public static void estadoInicial() { // inicializa el juego ???
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                tablero[f][c] = asterisco;
                System.out.print(tablero[f][c] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }
    public static void estadoActual() { // muestra el tablero con las jugadas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6"); 
    }

    public static int elegirColumna(char jugador) {
        System.out.println(" ");
        System.out.println("Jugador " + "(" + jugadores[jugadorActual] + ")" + " elija una columna (0-6): ");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println(" ");
            System.out.println("Por favor, jugador " + "(" + jugadores[jugadorActual] + ")" + " introduzca un número válido entre 0 y 6:");
        }

        return sc.nextInt();
    }

    public static boolean verificarColumna(int columna){
        return columna >= 0 && columna < columnas && tablero[0][columna] == asterisco;
    }

    public static int ponerFicha(int columna, char ficha) {
        for(int i = filas -1; i >= 0; i--) {
            if(tablero[i][columna] == asterisco) {
                tablero[i][columna] = ficha;
                return i;
            }
        } 
        return -1; 
    }

    private static boolean verificarGanador(int fila, int columna, char jugador) {
        int[][] direcciones = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
        for (int[] direccion : direcciones) {
            int contador = 0;
            for (int i = 0; i < 4; i++) {
                int nuevaFila = fila + i * direccion[0];
                int nuevaColumna = columna + i * direccion[1];
                if (0 <= nuevaFila && nuevaFila < filas && 0 <= nuevaColumna && nuevaColumna < columnas &&
                    tablero[nuevaFila][nuevaColumna] == jugador) {
                    contador++;
                } else {
                    break;
                }
                if (contador == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean tableroLleno() {
        for (int i = 0; i < filas; i++) { 
            for (int j = 0; j < columnas; j++) { 
                if (tablero[i][j] == asterisco) {
                    return false; 
                }
            }
        }
        return true; 
    }

    private static void reiniciarJuego() {
        System.out.println("¿Jugar de nuevo? (s/n)");
        if (sc.next().equalsIgnoreCase("s")) {
            main(null);
        }   else {
            System.out.println(" "); 
            System.out.println("TE VERÉ MÁS TARDE.");
        }
    }
    
    //PASO 3: programa principal (método "main")
    public static void main(String[] args) {
        System.out.println("                                     ");
        System.out.println("*****************************************");
        System.out.println("*                                       *");
        System.out.println("*     BIENVENIDO A CONECTA4 by Grupo8   *");
        System.out.println("*                                       *");
        System.out.println("*****************************************");
        System.out.println("                                     ");
        estadoInicial();

        char[] jugadores = {j1, j2};
        int jugadorActual = 0;

        while (!juegoTerminado) {
            int columna = elegirColumna(jugadores[jugadorActual]);
            if (verificarColumna(columna)) {
                int fila = ponerFicha(columna, jugadores[jugadorActual]);
                if (fila == -1) {
                    System.out.println("No se puede colocar la ficha en esta columna. Intente de nuevo.");
                } else {
                    System.out.println(" ");
                    System.out.println(" ");
                    estadoActual();
                    if (verificarGanador(fila, columna, jugadores[jugadorActual]) || tableroLleno()) {
                        System.out.println(" "); 
                        System.out.println("¡El juego ha terminado! " +
                                (verificarGanador(fila, columna, jugadores[jugadorActual]) ?
                                        "Ha ganado el jugador " + jugadores[jugadorActual] + "." :
                                        "Es un empate"));
                        juegoTerminado = true;
                    } else {
                        jugadorActual = (jugadorActual + 1) % jugadores.length;
                    }
                }
            } else {
                System.out.println("Columna inválida. Intente de nuevo.");
            }
        }
        reiniciarJuego();
        }
    }
