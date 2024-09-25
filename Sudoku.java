import java.util.*;


public class Sudoku {
    
    public static void VerTablero (int [][] Tablero){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(Tablero[i][j] == 0 ? " . " : " " + Tablero[i][j] + " ");//recorre las filas y columnas del tablero y las muestra
                
                if((j + 1) % 3 == 0 && j != 8){ //comprueba las dimensiones de las columnas e imprime un separador cada 3 columnas 
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i != 8) {
                System.out.println("---------+---------+---------");//comprueba las dimensiones de las filas e imprime un separador cada 3 filas
            }
        }
    }

    public static boolean VerificarNumero(int[][] Tablero, int fila, int col, int num){
        for(int i = 0; i < 9; i++){//recorre las filas comprobando si el numero introducido se encuentra en la misma fila
            if(Tablero[fila][i] == num){
                return false;
            }
        }
        for(int j = 0; j < 9; j++){//recorre las columnas comprobando si el numero introducido se repite en la misma columna
            if(Tablero[j][col] == num){
                return false;
            }
        }
        
        int iniFila = fila - fila % 3;
        int iniCol = col - col % 3;
        for (int i = iniFila; i < iniFila + 3; i++) { // Desde iniFila hasta iniFila + 3
            for (int j = iniCol; j < iniCol + 3; j++) { // Desde iniCol hasta iniCol + 3
                if (Tablero[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean introducirNumero(int [][] Tablero, int fila, int col, int num){
        if(VerificarNumero(Tablero, fila, col, num)){//verifica si el numero se puede introducir y en ese caso lo introduce
            Tablero[fila][col] = num;
            return true;
        }else{// si el movimiento no es valido manda un mensaje
            System.out.println("no puedes hacer este movimiento vuleve a intentarlo");
            return false;
        }
    }

    public static boolean backtracking(int[][] Tablero) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                if (Tablero[fila][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (VerificarNumero(Tablero, fila, col, num)) {
                            Tablero[fila][col] = num;
    
                            if (backtracking(Tablero)) {
                                return true; // si el numero es correcto se resuelve y devuelve true
                            }
    
                            Tablero[fila][col] = 0; // Si no se resuelve vacia la celda
                        }
                    }
                    return false; // si el numero no es valido y no puede llenar la celda devuelve false
                }
            }
        }
        return true; // si ha comppletado todas las celdas el sudoku esta completado
    }

    public static void GenerarSudoku(int[][] Tablero, int CeldaVacia ){
        Random random = new Random();
        
        backtracking(Tablero);//resuleve el sudoku

        //recorre el tablero y elimina numeros aleatorios para que el usuario pueda hacerlo
        for (int i = 0; i < CeldaVacia; i++) {
            int fila, col;
            do {
                fila = random.nextInt(9);
                col = random.nextInt(9);
            } while (Tablero[fila][col] == 0); // Repite hasta encontrar una celda no vacía
            Tablero[fila][col] = 0;
        }
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] Tablero = new int[9][9]; //creamos un tablero de 9 x 9 
        int col, fila, num;
        //generamos un sudoku
        GenerarSudoku(Tablero, 30);

        //mostramos el sudoku
        VerTablero(Tablero);

        while (true) {
            System.out.println("introduzca la columna (0-8): ");
            col = sc.nextInt();
            System.out.println("introduzca la fila (0-8): ");
            fila = sc.nextInt();
            System.err.println("introduce el numero (1-9): ");
            num = sc.nextInt();
        
            if (col < 0 || col > 8 || fila < 0 || fila > 8 || num < 1 || num > 9) {
                System.out.println("Valores fuera de rango. Por favor, inténtalo de nuevo.");
            } else if (introducirNumero(Tablero, fila, col, num)) {
                VerTablero(Tablero);
            }
        }
    }
    
}
