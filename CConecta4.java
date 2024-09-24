public class Conecta4 {
    public static void main(String[] args) {
        
        int filas = 6;
        int columnas = 9;
        
        for (int i = 0; i < filas; i++) {
            // Bucle para las columnas
            for (int j = 0; j < columnas; j++) {
                // Imprimir símbolo sin salto de línea
                System.out.print("* ");
            }
            // Saltar a la siguiente línea después de cada fila
            System.out.println();
        }
    }
}
