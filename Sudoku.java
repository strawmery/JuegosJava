import java.util.*;


public class Sudoku {
    
    public static void VerTablero (int [][] Tablero, int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(Tablero[i][j] == 0 ? " . " : " " + Tablero[i][j] + " ");// los dos bucles recorren las filas y columnas del tablero 
                
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
        for (int i = 0; i < size; i++) { // bucle que recore las filas y combuerba si el numero introducido por el usuario esta ya en alguna de las columnas
            if (Tablero[fila][i] == num) {
                return false;
            }
        }
        for (int j = 0; j < size; j++) {
            if (Tablero[j][col] == num) {// hace lo mismo que el anterior bucle pero con las columnas
                return false;
            }
        }
        int celdaSize;

        //verifica el tamano del sudoku y asigna un tamano de celdas
        switch (size) {
            case 9:
                celdaSize = 3; // Sudoku 9x9 -> subcuadrículas de 3x3
                break;
            case 6:
                celdaSize = 2; // Sudoku 6x6 -> subcuadrículas de 2x3
                break;
            default:
                celdaSize = 3; // Sudoku 3x3 -> subcuadrícula única
                break;
        }

        int iniFila = (fila / celdaSize)*celdaSize;
        int iniCol = (col / celdaSize)*celdaSize;

        //recorre las celdas y comprueba si el numero se encuentra repetido
        for(int i = 0; i < iniFila + celdaSize; i++){
            for(int j = 0; j < iniCol + celdaSize; j++){
                if(Tablero [i][j] == num ){
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
        }else{// si el movimiento no es valido manda un mensaje de error
            System.out.println("no puedes hacer este movimiento vuleve a intentarlo");
            return false;
        }
    }

    public static boolean backtracking(int[][] Tablero, int size) {
        for (int fila = 0; fila < size; fila++) {
            for (int col = 0; col < size; col++) {// dos bucles que recorren el tablero
                if (Tablero[fila][col] == 0) { // el condicional comprueban si el numero que en el lugar es 0 
                    for (int num = 1; num <= 9; num++) {// en ese caso introduce un numero del 1 al 9
                        if (VerificarNumero(Tablero, fila, col, num, size)) {// y posteriormente comprueba si este numero puede ser introducido
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

        //recorre el tablero y elimina numeros aleatorios para que el usuario pueda introducir nuevos numeros
        for (int i = 0; i < CeldaVacia; i++) {
            int fila = random.nextInt(size);
            int col = random.nextInt(size);
            Tablero[fila][col] = 0;
        }
    }

    public static int obtenerInputEntero(Scanner sc, String mensaje) {//verifica si has introducido un dato incorrecto da un mensaje de error.
        int input = -1;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                System.out.print(mensaje);
                String entrada = sc.nextLine().trim();

                if (entrada.isEmpty()) {
                    System.out.println("ERROR: No has introducido nada. Por favor, introduce un número.");
                } else {
                    input = Integer.parseInt(entrada);
                    inputValido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Entrada no válida. Solo se permiten números.");
            }
        }

        return input;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //pregunta al usuario que dificultad quiere seleccionar de entre estas 3 
        System.out.println("seleccione el nivel de dificultad en que que quiere jugar: ");
        System.out.println("1.Facil");
        System.out.println("2.Normal");
        System.out.println("3.Dificil");
        int dificultad = obtenerInputEntero(sc, "Elija una dificultad: ");
        int size = 0;
        int CeldaVacia = 0;

        //cuando elige una dificultad se establece y se genera un tablero con un tamano diferente para cada difiltad el cual aumenta con la dificultad
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
            
            //si no se introduce alguno de las opciones dadas por el programa se emite un mensaje de error y se vuelve a ejecutar el switch
            default: 
                System.out.println("dificultad introdiucida invalida, nivel establecido por defecto: ");
                size = 9;
                CeldaVacia = 30;
                break;
        }

        int[][] Tablero = new int[size][size]; // Crear el tablero por dificltad
        
        // Generar el Sudoku con el tamano determinado con anterioridad en el switch
        GenerarSudoku(Tablero, CeldaVacia, size);

        // Mostrar el Sudoku
        VerTablero(Tablero, size);

        //se pide al usuario que introduzca un numero dando la posicion especifica
        while (true) {
            int fila = obtenerInputEntero(sc, "Introduce la fila (0 a " + (size - 1) + "): ");
            int col = obtenerInputEntero(sc, "Introduce la columna (0 a " + (size - 1) + "): ");
            int num = obtenerInputEntero(sc, "Introduce el número: ");

            if (introducirNumero(Tablero, fila, col, num, size)) {
                VerTablero(Tablero, size);
            }
        }
    }
    
}
