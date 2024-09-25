import java.util.*;


public class Sudoku {
    
    public static void VerTablero (int [][] Tablero, int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(Tablero[i][j] == 0 ? " . " : " " + Tablero[i][j] + " ");//recorre las filas y columnas del tablero y las muestra
                
                if((j + 1) % 3 == 0 && j != size - 1){ //comprueba las dimensiones de las columnas e imprime un separador cada 3 columnas 
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i != 8) {
                System.out.println("---------+---------+---------");//comprueba las dimensiones de las filas e imprime un separador cada 3 filas
            }
        }
    }

    public static boolean VerificarNumero(int[][] Tablero, int fila, int col, int num, int size) {
        for (int i = 0; i < size; i++) {
            if (Tablero[fila][i] == num) {
                return false;
            }
        }
        for (int j = 0; j < size; j++) {
            if (Tablero[j][col] == num) {
                return false;
            }
        }
        
        int iniFila = fila - fila % (size / 3);
        int iniCol = col - col % (size / 3);
        for (int i = iniFila; i < iniFila + (size / 3); i++) {
            for (int j = iniCol; j < iniCol + (size / 3); j++) {
                if (Tablero[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean introducirNumero(int [][] Tablero, int fila, int col, int num, int size){
        if(VerificarNumero(Tablero, fila, col, num, size)){//verifica si el numero se puede introducir y en ese caso lo introduce
            Tablero[fila][col] = num;
            return true;
        }else{// si el movimiento no es valido manda un mensaje
            System.out.println("no puedes hacer este movimiento vuleve a intentarlo");
            return false;
        }
    }

    public static boolean backtracking(int[][] Tablero, int size) {
        for (int fila = 0; fila < size; fila++) {
            for (int col = 0; col < size; col++) {
                if (Tablero[fila][col] == 0) {
                    for (int num = 1; num <= size; num++) {
                        if (VerificarNumero(Tablero, fila, col, num, size)) {
                            Tablero[fila][col] = num;

                            if (backtracking(Tablero, size)) {
                                return true; 
                            }

                            Tablero[fila][col] = 0; 
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }
    public static void GenerarSudoku(int[][] Tablero, int CeldaVacia, int size ){
        Random random = new Random();
        
        backtracking(Tablero, size);//resuleve el sudoku

        //recorre el tablero y elimina numeros aleatorios para que el usuario pueda hacerlo
        for (int i = 0; i < CeldaVacia; i++) {
            int fila = random.nextInt(size);
            int col = random.nextInt(size);
            Tablero[fila][col] = 0;
        }
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("seleccione el nivel de dificultad en qle que quiere jugar: ");
        System.out.println("1.Facil");
        System.out.println("2.Normal");
        System.out.println("3.Dificil");
        int dificultad = sc.nextInt();
        int size = 0;
        int CeldaVacia = 0;

        switch (dificultad) {
            case 1:
                size = 3;
                CeldaVacia = 4;
                break;

            case 2:
                size = 6;
                CeldaVacia = 15;
                break;
            
            case 3:
                size = 9;
                CeldaVacia = 30;
                break;
        
            default: 
                System.out.println("dificultad introdiucida invalida, nivel establecido por defecto: ");
                size = 9;
                CeldaVacia = 30;
                break;
        }

        int[][] Tablero = new int[size][size]; // Crear el tablero por dificltad
        
        // Generar el Sudoku
        GenerarSudoku(Tablero, CeldaVacia, size);

        // Mostrar el Sudoku
        VerTablero(Tablero, size);

        while (true) {
            System.out.println("Introduce la columna: ");
            int col = sc.nextInt();
            System.out.println("Introduce la fila: ");
            int fila = sc.nextInt();
            System.out.println("Introduce el número: ");
            int num = sc.nextInt();
            
            if (introducirNumero(Tablero, fila, col, num, size)) {
                VerTablero(Tablero, size);
            }
        }
    }
    
}
