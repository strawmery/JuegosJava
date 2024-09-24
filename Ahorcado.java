import java.util.*;

public class Ahorcado {

    public static void main(String[] args) {
        Scanner sc = Scanner(System.in);
        Random random =new Random();
        int intentos = 0;
        String[] Palabras = {"escalar", "gigante", "lectura", "castillo", "sensible", "propuesta", "sesiones", "desafío", 
        "objetivo", "elevado", "esquivar", "poderoso", "esencia", "misterio", "perdido", "entorno", "vacante", "distancia", "ventana", 
        "observar"};
        String ahorcado = Palabras[random.nextInt(20)];
        Boolean [] letrasAdivinadas = new Boolean[ahorcado.length()];

        //pedir letra a usuario
        System.out.println("introduce una letra ");
        char letra = sc.nextLine().charAt(0);
        boolean acertada = false;

        //comprobacion de de si la letra se ecuentra en la palabra elegida por el programa
        for(int i = 0; i < ahorcado.length(); i++){
            if(ahorcado.charAt(i) == letra){
                acertada = true;
            }

            if(acertada){
                System.out.println("has acertado la letra!");
            }else{
                intentos ++;
                System.out.println("la letra es incorrecta te quedan "+(6 - intentos)+" aciertos");
            }
        }

        //commprobacion de si todas las letras estan adivinadas
        boolean todasAdivinadas = false;

        for(boolean adivina: letrasAdivinadas){
            if(!adivina){
                todasAdivinadas = false;
                break;
            }
        }
        //al adivinar la palabra completa se reproduce el siguiente mensaje
        if(todasAdivinadas){
            todasAdivinadas = true;
            System.out.println("enhorabuena has adivinado la palabra!");
        }

        if(intentos == 6){
            
        }
        
    }
}