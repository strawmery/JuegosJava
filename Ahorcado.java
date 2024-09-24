import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Ahorcado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random =new Random();
        int intentos = 0;
        String[] Palabras = {"escalar", "gigante", "lectura", "castillo", "sensible", "propuesta", "sesiones", "desafío", 
        "objetivo", "elevado", "esquivar", "poderoso", "esencia", "misterio", "perdido", "entorno", "vacante", "distancia", "ventana", 
        "observar"};
        String ahorcado = Palabras[random.nextInt(20)];
        Boolean [] letrasAdivinadas = new Boolean[ahorcado.length()];

         //sustituir las letras por guiones y poner las letras acertadas en los guiones
         char [] ocultar = new char[ahorcado.length()];

         for(int i = 0; i < ahorcado.length(); i++){
            ocultar[i] = '_';
            letrasAdivinadas[i] = false;
         }

         //creo un arraylist que guardara las letras incorrectas introducidas por el usuario
          ArrayList <Character> letrasIncorrectas = new ArrayList<Character>();

        while(intentos < 6){
    
            //pedir letra a usuario
            System.out.println("introduce una letra ");
            char letra = sc.nextLine().charAt(0);
            boolean acertada = false;
            

            //comprobacion de de si la letra se ecuentra en la palabra elegida por el programa
            for(int i = 0; i < ahorcado.length(); i++){
                if(ahorcado.charAt(i) == letra){
                    ocultar[i] = letra;
                    letrasAdivinadas[i] = true;
                    acertada = true;
                }
            }

            //muestra elprogreso y las letras acertadas
                System.out.println(ocultar);

            //comprueba si has acertado la letra y en ese caso printea un mensaje si no printea otro mensaje y te dice cuantos intentos te quedan
            if(acertada){
                System.out.println("has acertado la letra!");
            }else{
                if(!letrasIncorrectas.contains(letra)){
                    letrasIncorrectas.add(letra);
                    intentos ++;
                    System.out.println("la letra es incorrecta te quedan "+(6 - intentos)+" aciertos");
                }else{
                    System.out.println("ya has introducido esta letra incorrecta antes. ");
                }
            }

            System.out.println("letras incorrectas introducidas: "+letrasIncorrectas);

            //commprobacion de si todas las letras estan adivinadas
            boolean todasAdivinadas = false;

            for(int i = 0; i < letrasAdivinadas.length; i++){
                if(!letrasAdivinadas[i]){
                    todasAdivinadas = false;
                    break;
                }
            }
            //al adivinar la palabra completa se reproduce el siguiente mensaje
            if(todasAdivinadas){
                todasAdivinadas = true;
                System.out.println("enhorabuena has adivinado la palabra!");
            }

            // si agotas los intentos aparece el muneco ahorcado y un mensaje de perdiste
            switch (intentos) {
                case 1:
                        System.out.println("_____");
                        System.out.println("|   |");
                        System.out.println("|   0");
                        System.out.println("|    ");
                        System.out.println("|    ");
                        System.out.println("|    ");
                        System.out.println("|_____");

                    break;
            
                case 2:
                        System.out.println("_____");
                        System.out.println("|   |");
                        System.out.println("|   0");
                        System.out.println("|   |");
                        System.out.println("|    ");
                        System.out.println("|    ");
                        System.out.println("|_____");
                    break;

                case 3:
                        System.out.println("_____");
                        System.out.println("|   |");
                        System.out.println("|   0");
                        System.out.println("|  /|");
                        System.out.println("|    ");
                        System.out.println("|    ");
                        System.out.println("|_____");
                    break;
                
                case 4:
                        System.out.println("_____");
                        System.out.println("|   |");
                        System.out.println("|   0");
                        System.out.println("|  /|\\");
                        System.out.println("|    ");
                        System.out.println("|    ");
                        System.out.println("|_____");
                    break;
                    
                case 5:
                        System.out.println("_____");
                        System.out.println("|   |");
                        System.out.println("|   0");
                        System.out.println("|  /|\\");
                        System.out.println("|  / ");
                        System.out.println("|    ");
                        System.out.println("|_____");
                    break;
                    
                case 6:
                        System.out.println("_____");
                        System.out.println("|   |");
                        System.out.println("|   0");
                        System.out.println("|  /|\\");
                        System.out.println("|  / \\");
                        System.out.println("|     ");
                        System.out.println("|_____");
                        System.out.println("has perdido, la parabra que debias adivinar era "+ ahorcado);
                    break;
            }
        }
        
    sc.close();
    }
}