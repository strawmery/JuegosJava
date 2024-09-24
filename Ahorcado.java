import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Ahorcado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random =new Random();
        int intentos = 0;
        String[] Palabras = {"entorno", "lectura", "gigante", "castillo", "sensible", "propuesta", "desafío", 
        "objetivo", "elevado", "esquivar", "poderoso", "esencia", "misterio", "perdido", "distancia", "vacante",
         "ventana", "observar", "gigantes", "escalera", "sistemas", "proyectos", "estudios", "sociedad", 
         "relación", "económico", "empleado", "navegador", "métodos", "tecnología", "historia", "cultura", 
         "naturales", "exterior", "gobierno", "energías", "población", "cohesión", "naciones", "universo", 
         "galaxias", "proteína", "organismo", "minerales", "exclusivo", "desafíos", "planetas", "astronomía", 
         "evidente", "creación", "relativa", "resistencia", "resolución", "empleados", "vulnerable", "regiones",
          "dinámico", "recurrente", "transformar", "colectivo", "variables", "educación", "propuesta", 
          "integral", "colectivos", "experiencia", "tendencia", "creciente", "creadores", "mecánico", "competir",
           "completar", "expansión", "inversión", "operativo", "evaluación", "teoría", "estrategia", 
           "industrial", "complejo", "construir", "evaluación", "modernidad", "tradición", "manifiesto", 
           "simétrico", "aplicación", "verificable", "reconocer", "dominante", "transporte", "reparación", 
           "optimización", "estructura", "fenómeno", "variables", "ejercicios", "continuo", "inclusión", 
           "mercados", "regulatorio", "significado", "asociación", "algoritmo", "interior", "simétrico", 
           "implementación", "concreción", "transacción", "exclusión", "valores", "infinitos", "materiales",
            "constante", "radicales", "significado", "adecuado", "voluntario", "sustancial", "presupuesto",
            "disciplinar", "colectivo", "empresarial", "procesador", "activación", "esquemas", "concepción",
            "personalidad", "finalidad", "visibilidad", "competencia", "privilegio", "mecánicas", "inversión",
            "producción", "herramientas", "algoritmos", "efectividad", "análisis", "evolución", 
            "procesamiento", "libertades", "justificación", "limitación", "orientación", "específico",
            "operaciones", "regulaciones", "parámetros", "cualitativo", "profundidad", "automatización",
            "sustentable", "vigilancia", "diseñador", "mantenimiento", "expresiones", "determinante",
            "articulación", "colaboración", "instrumento", "decisiones", "crecimiento", "universales",
            "prácticas", "transferencia", "formación", "constitución", "aplicaciones", "tecnológicas",
            "coherencia", "producciones", "contextos", "dinámicas", "preferencias", "innovación", 
            "evaluaciones", "sincronización", "verificación", "perspectiva", "programación",
            "equivalentes", "funcionales", "administración", "inteligente", "experimentar",
            "procesamiento", "planificación", "procedimientos", "consolidación", "representación",
            "tecnologías", "publicación", "determinados", "simplificación"
};
        String ahorcado = Palabras[random.nextInt(200)];
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