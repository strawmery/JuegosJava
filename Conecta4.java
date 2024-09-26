import java.util.Scanner;

public class Conecta4 {
    

    
    // PASO 1: declaración de variables
    private static int filas = 6, columnas = 7;
    private static char asterisco = '*', j1 = 'X', j2 = 'O';
    private static char[][] tablero = new char [filas][columnas];
    private static Scanner sc = new Scanner(System.in);



    //PASO 2: métodos
    public static void estadoInicial() { // inicializa el juego ???
        for (int f = 0, i < filas; i++)
            for (int c = 0, j < columnas; j++)
                tablero[f][c] = asterisco;
    }
    
    public static void estadoActual() { // muestra el tablero con las jugadas
        for (int i = 0, i < filas; i++) {
            for (int j = 0, j < columnas; j++) {
                System.out.println(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6"); 
    }

    public static int elegirColumna(char jugador, Scanner sc) {
        System.out.println("Elige una columna (0-6): ");
        return sc.nextInt();
    }

    public static boolean verificarColumna(int columna){
        return columna >= 0 && columna < columnas && tablero[0][columna] == asterisco;
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

    private static boolean verificarGanador(int fila, int columna, char jugador) {
        int[][] direcciones = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};

        for (int[] direccion : direcciones) {
            int contador = 0;
            for (int i = 0; i < 4; i++) {
                int nuevaFila = fila + i * direccion[0];
                int nuevaColumna = columna + i * direccion[1];
                // Verificación directa sobre el tablero
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

    private static void reiniciarJuego() {
        System.out.println("¿Jugar de nuevo? (s/n)");
        if (sc.next().equalsIgnoreCase("s")) {
            main(null);
        }   else {
            System.out.println("TE VERÉ MÁS TARDE.");
        }
    }
    
    //PASO 3: programa principal (método "main")
    public static void main(String[] args) {
        estadoInicial();
        estadoActual();
        char jugadorJugando = j1;
        boolean finalJuego = true; 

    while (finalJuego != true) {
        System.out.println("Presiona una tecla " + (jugador == j1 ? "Jugador 1" : "Jugador 2"));
        int columna = verificar();

        if(!ponerFicha(columna, jugadorJugando)) {
            System.out.println("Intenta otra columna.");
            continue;
        }

        estadoActual();


        


    }




}









}
