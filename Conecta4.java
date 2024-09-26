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

    public static int elegirColumna(char jugador) {
        Scanner sc = new Scanner(System.in);
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

    public static boolean verificarGanador(int fila, int columna, int jugador){
        return(verificar)
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


        

    System.out.println("¿Jugar de nuevo? (s/n)");
    if (sc.next().equalsIgnoreCase("s")) {
        main(null);
    }   else {
        System.out.println("TE VERÉ MÁS TARDE.");
    }
    }




}









}
