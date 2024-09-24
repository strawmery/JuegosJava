  import java.util.Scanner;

public class AdivinaNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroAleatorio = (int) ((Math.random()*100) + 1);
        int intentos = 0;
        int numeroAdivinar = 0;

        while( numeroAleatorio != numeroAdivinar){
            System.out.println("adivina el numero! introduce un numero");
            numeroAdivinar = sc.nextInt();

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