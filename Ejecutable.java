import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutable {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int juego;

        System.out.println("que juego quieres jugar?: \n1.Sudoku \n2.adivina el numero \n3.conecta 4");
        juego = sc.nextInt();

        while (juego != 0){

            switch (juego) {
                case 1 -> {
                    //pregunta al usuario que dificultad quiere seleccionar de entre estas 3
                    System.out.println("seleccione el nivel de dificultad en qle que quiere jugar: ");
                    System.out.println("1.Facil");
                    System.out.println("2.Normal");
                    System.out.println("3.Dificil");
                    int dificultad = sc.nextInt();
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
                    Sudoku.GenerarSudoku(Tablero, CeldaVacia, size);
                    
                    // Mostrar el Sudoku
                    Sudoku.VerTablero(Tablero, size);
                    
                    //se pide al usuario que introduzca un numero dando la posicion especifica
                    while (true) {
                        System.out.println("Introduce la columna: ");
                        int col = sc.nextInt();
                        System.out.println("Introduce la fila: ");
                        int fila = sc.nextInt();
                        System.out.println("Introduce el número: ");
                        int num = sc.nextInt();
                        
                        if (Sudoku.introducirNumero(Tablero, fila, col, num, size)) {
                            Sudoku.VerTablero(Tablero, size);
                        }
                    }
                }
                case 2 -> {
                    int numeroAleatorio = (int) ((Math.random()*100) + 1);
                    int intentos = 0;
                    int numeroAdivinar = 0;
                    
                    while( numeroAleatorio != numeroAdivinar){
                        System.out.println("introduce un numero entre 0 y 100: ");
                        
                        String input = sc.nextLine();
                        
                        if(input.isEmpty()){
                            System.out.println("Error:no has introducido ningun numero vuelva a intentarlo ");
                            continue;
                        }
                        
                        try {
                            
                            numeroAdivinar = Integer.parseInt(input);
                            
                            if (numeroAdivinar < 1 || numeroAdivinar > 100) {
                                System.out.println("Error: el numero debe estar entre 1 y 100");
                                continue;
                            }
                            
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Debes introducir un número válido. Intenta de nuevo.");
                            continue;
                        }
                        
                        
                        
                        if (numeroAleatorio > numeroAdivinar) {
                            System.out.println("el numero es mayor al que el que has introducido");
                            intentos ++;
                        }else if (numeroAleatorio < numeroAdivinar) {
                            System.out.println("el numero es menor al que has introducido");
                            intentos ++;
                        }else{
                            System.out.println("has adivinado el numero, enhorabuena!");
                            System.out.println("has usado "+intentos+" intentos");
                        }
                    }
                }

                case 3 -> {
                       /* System.out.println("                                     ");
                        System.out.println("*****************************************");
                        System.out.println("*                                       *");
                        System.out.println("*     BIENVENIDO A CONECTA4 by Grupo8   *");
                        System.out.println("*                                       *");
                        System.out.println("*****************************************");
                        System.out.println("                                     ");
                        Conecta4.estadoInicial();

                        char[] jugadores = {j1, j2};
                        int jugadorActual = 0;

                        while (!Conecta4.juegoTerminado) {
                            int columna = Conecta4.elegirColumna(jugadores[jugadorActual]);
                            if (Conecta4.verificarColumna(columna)) {
                                int fila = Conecta4.ponerFicha(columna, jugadores[jugadorActual]);
                                if (fila == -1) {
                                    System.out.println("No se puede colocar la ficha en esta columna. Intente de nuevo.");
                                } else {
                                    System.out.println(" ");
                                    System.out.println(" ");
                                    Conecta4.estadoActual();
                                    if (Conecta4.verificarGanador(fila, columna, jugadores[jugadorActual]) || Conecta4.tableroLleno()) {
                                        System.out.println(" "); 
                                        System.out.println("¡El juego ha terminado! " +
                                                (Conecta4.verificarGanador(fila, columna, jugadores[jugadorActual]) ?
                                                        "Ha ganado el jugador " + jugadores[jugadorActual] + "." :
                                                        "Es un empate"));
                                        Conecta4.juegoTerminado = true;
                                    } else {
                                        jugadorActual = (jugadorActual + 1) % jugadores.length;
                                    }
                                }
                            } else {
                                System.out.println("Columna inválida. Intente de nuevo.");
                            }
                        }
                        Conecta4.reiniciarJuego();*/
                }
                
                case 4 -> {
                        String palabra = Ahorcado.elegirPalabra();
                        char[] ocultarPalabra = Ahorcado.ocultar(palabra);
                        Boolean[] letrasAdivinadas = new Boolean[palabra.length()];
                        
                        // Inicializar letras adivinadas a false
                        for (int i = 0; i < palabra.length(); i++) {
                            letrasAdivinadas[i] = false;
                        }

                        ArrayList<Character> letrasIncorrectas = new ArrayList<>();
                        int intentos = 0;

                        System.out.println("Bienvenido al Ahorcado");

                        while (intentos < Ahorcado.MAX_INTENTOS) {
                            Ahorcado.mostrarEstadoJuego(ocultarPalabra, letrasIncorrectas, intentos);
                            char letra = Ahorcado.introducirLetra(sc);
                            boolean acierto = Ahorcado.verificarLetra(palabra, letra, ocultarPalabra, letrasAdivinadas);

                            if (!acierto) {
                                intentos = Ahorcado.registrarLetraIncorrecta(letra, letrasIncorrectas, intentos);
                            } else {
                                System.out.println("¡Letra correcta!");
                            }

                            if (Ahorcado.todasAdivinadas(letrasAdivinadas)) {
                                System.out.println("¡Has adivinado la palabra! Felicidades: " + palabra);
                                break;
                            }

                            if (intentos == Ahorcado.MAX_INTENTOS) {
                                System.out.println("Has perdido. La palabra correcta era: " + palabra);
                                Ahorcado.dibujarMonigote(intentos);
                            }
                        }
                }
                default -> throw new AssertionError();
            }

        }
                
        
        
    }
}
