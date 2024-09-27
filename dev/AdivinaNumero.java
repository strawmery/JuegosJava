  import java.util.Scanner;

public class AdivinaNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
}