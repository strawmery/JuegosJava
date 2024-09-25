import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Ahorcado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random =new Random();
        int intentos = 0;
        String[] Palabras = {"entorno", "lectura", "gigante", "castillo", "sensible", "propuesta", "desafio", 
                    "objetivo", "elevado", "esquivar", "poderoso", "esencia", "misterio", "perdido", "distancia", "vacante",
                    "ventana", "observar", "gigantes", "escalera", "sistemas", "proyectos", "estudios", "sociedad", 
                    "relacion", "economico", "empleado", "navegador", "metodos", "tecnologia", "historia", "cultura", 
                    "naturales", "exterior", "gobierno", "energias", "poblacion", "cohesion", "naciones", "universo", 
                    "galaxias", "proteina", "organismo", "minerales", "exclusivo", "desafios", "planetas", "astronomia", 
                    "evidente", "creacion", "relativa", "resistencia", "resolucion", "empleados", "vulnerable", "regiones",
                    "dinamico", "recurrente", "transformar", "colectivo", "variables", "educacion", "propuesta", 
                    "integral", "colectivos", "experiencia", "tendencia", "creciente", "creadores", "mecanico", "competir",
                    "completar", "expansion", "inversion", "operativo", "evaluacion", "teoria", "estrategia", 
                    "industrial", "complejo", "construir", "evaluacion", "modernidad", "tradicion", "manifiesto", 
                    "simettrico", "aplicacion", "verificable", "reconocer", "dominante", "transporte", "reparacion", 
                    "optimizacion", "estructura", "fenomeno", "variables", "ejercicios", "continuo", "inclusion", 
                    "mercados", "regulatorio", "significado", "asociacion", "algoritmo", "interior", "simetrico", 
                    "implementacion", "concrecion", "transaccion", "exclusion", "valores", "infinitos", "materiales",
                    "constante", "radicales", "significado", "adecuado", "voluntario", "sustancial", "presupuesto",
                    "disciplinar", "colectivo", "empresarial", "procesador", "activacion", "esquemas", "concepcion",
                    "personalidad", "finalidad", "visibilidad", "competencia", "privilegio", "mecanicas", "inversion",
                    "produccion", "herramientas", "algoritmos", "efectividad", "analisis", "evolucion", 
                    "procesamiento", "libertades", "justificacion", "limitacion", "orientacion", "especifico",
                    "operaciones", "regulaciones", "parametros", "cualitativo", "profundidad", "automatizacion",
                    "sustentable", "vigilancia", "disenador", "mantenimiento", "expresiones", "determinante",
                    "articulacion", "colaboracion", "instrumento", "decisiones", "crecimiento", "universales",
                    "practicas", "transferencia", "formacion", "constitucion", "aplicaciones", "tecnologicas",
                    "coherencia", "producciones", "contextos", "dinamicas", "preferencias", "innovacion", 
                    "evaluaciones", "sincronizacion", "verificacion", "perspectiva", "programacion",
                    "equivalentes", "funcionales", "administracion", "inteligente", "experimentar",
                    "procesamiento", "planificacion", "procedimientos", "consolidacion", "representacion",
                    "tecnologias", "publicacion", "determinados", "simplificacion"};
            
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
    
             // Pedir letra al usuario y asegurarse de que introduce una letra válida
             char letra = ' ';
             boolean acertada = false;
 
             while (!acertada) {
                 System.out.println("Introduce una letra: ");
                 String input = sc.nextLine().trim();
 
                 if (input.length() == 0) {
                     System.out.println("Error: no has introducido ninguna letra. Inténtalo de nuevo.");
                 } else {
                     letra = input.charAt(0);
                     acertada = true;
                 }
             }
            
            

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
            boolean todasAdivinadas = true;

            for(int i = 0; i < letrasAdivinadas.length; i++){
                if(!letrasAdivinadas[i]){
                    todasAdivinadas = false;
                    break;
                }
            }

            // Si todas las letras fueron adivinadas, terminar el juego
            if (todasAdivinadas) {
                System.out.println("¡Enhorabuena! Has adivinado la palabra: " + ahorcado);
                break;
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