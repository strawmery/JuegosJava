public class Conecta4 {

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


