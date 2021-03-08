/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class JuegoAhorcado {

    /**
     * @param args the command line arguments
     */
    
    /***************************************************************************
    * Este método imprime las normas del juego.
    ***************************************************************************/
    public static void imprimeNormas(){
        System.out.println(" =============================================================================================");
        System.out.println("|                        NORMAS DEL AHORCADO MONKEY ISLAND TRIBUTE                            |");
        System.out.println("|     - El objetivo del juego es averiguar la palabra que se encuentra oculta por los guiones.|");
        System.out.println("|     - El juego no acepta tildes de ningún tipo ni otro caracteres que no sean letras de la a|");
        System.out.println("|       a la z en castellano.                                                                 |");
        System.out.println("|     - El juego mostrará al usuario las letras que quedan disponibles. Contando con esta ayu-|");
        System.out.println("|       da se considerará como intento fallido el introducir alguna letra repetida.           |");
        System.out.println("|     - Para ello el jugador tendrá seis intentos. En cada intento se le pedirá que introduzca|");
        System.out.println("|       una letra. Si es correcta, el programa colocará esa letra en la palabra oculta y se   |");
        System.out.println("|       mantendrá en el mismo intento. Si esa letra no forma parte de la palabra oculta, con- |");
        System.out.println("|       sumirá un intento y se irá pintando poco a poco la horca.                             |");
        System.out.println("|     - Si el jugador no logra resoler la palabra antes del final de quedarse sin intentos, se|");
        System.out.println("|       dará por finalizada la partida contando como derrota.                                 |");
        System.out.println("|     - Al inicio de cada nueva partida, el jugador podrá seleccionar el nivel de dificultad  |");
        System.out.println("|       al que desea enfrentarse : fácil (4 a 5 letras), medio (6 a 9 letras) o difícil (10 o |");
        System.out.println("|       más letras).                                                                          |");
        System.out.println("|     - Al final la partida, si el usuario decide dejar de jugar, se le mostrará una ventana  |");
        System.out.println("|       con las estadísticas de la sesión.                                                    |");
        System.out.println(" =============================================================================================");
    }
    /***************************************************************************
    * Este método selecciona la biblioteca según la dificultad y devuelve la 
    * palabra con la que se va a jugar. 
     * @param nivel
     * @return 
     * @throws java.io.FileNotFoundException 
    ***************************************************************************/
    public static String selectorPalabra(String nivel) throws FileNotFoundException{
        String palabra = "";
        int longitud = 0, selector;
        Scanner scan;
        Scanner lector;
        
        switch(nivel){
            case "f":
                File facil = new File ("src/juegoahorcado/facil");
                scan = new Scanner (facil);
                while (scan.hasNextLine()){
                    longitud++;
                    scan.nextLine();
                }
                scan.close();
                selector = (int) Math.floor(Math.random() * longitud + 1);// Así obtendremos un nº entre 1 y nuestro máximo de lineas del diccionario.
                lector = new Scanner (facil);
                if (selector == 1){
                    palabra = lector.nextLine();
                } else {
                    for (int i = 1; i < selector; i++){
                        lector.nextLine();
                    }
                    palabra = lector.nextLine();
                }
                lector.close();
                break;
            case "m":
                File medio = new File ("src/juegoahorcado/medio");
                scan = new Scanner (medio);
                while (scan.hasNextLine()){
                    longitud++;
                    scan.nextLine();
                }
                scan.close();
                selector = (int) Math.floor(Math.random() * longitud + 1);
                lector = new Scanner (medio);
                if (selector == 1){
                    palabra = lector.nextLine();
                } else {
                    for (int i = 1; i < selector; i++){
                        lector.nextLine();
                    }
                    palabra = lector.nextLine();
                }
                lector.close();
                break;
            case "d":
                File dificil = new File ("src/juegoahorcado/dificil");
                scan = new Scanner (dificil);
                while (scan.hasNextLine()){
                    longitud++;
                    scan.nextLine();
                }
                scan.close();
                selector = (int) Math.floor(Math.random() * longitud + 1);
                lector = new Scanner (dificil);
                if (selector == 1){
                    palabra = lector.nextLine();
                } else {
                    for (int i = 1; i < selector; i++){
                        lector.nextLine();
                    }
                    palabra = lector.nextLine();
                }
                lector.close();
                break;
        }
        return palabra;
    }
    /***************************************************************************
     * Este método nos sirve para asegurarnos que el usuario introduce una letra
     * y no un número o cualquier otro caracter (Problemas con la 'ñ' en mi 
     * equipo).
     * @param letra
     * @return 
     **************************************************************************/
    public static boolean validaDatos (char[] letra){
        boolean validaDatos = false;
        char caracter = letra[0];
        int valor = (int) caracter;
        if (((valor >= 97)&&(valor <= 122))||(valor == 241)){
            validaDatos = true;
        }
        return validaDatos;
    }
    /***************************************************************************
     * Este método nos sirve para comprobar si el usuario ha logrado adivinar la
     * palabra.
     * @param respuesta
     * @param intento
     * @return 
     **************************************************************************/
    public static boolean victoria(char[] respuesta, char[] intento){
        boolean victoria = true;
        for (int i = 0; i < respuesta.length; i++){
            if (respuesta[i] != intento[i]){
                victoria = false;
                break;
            }
        }
        return victoria;
    }
    /***************************************************************************
     * Este método nos imprime la horca según el intento por el que vayamos.
     * @param i
     * @throws FileNotFoundException 
     **************************************************************************/
    public static void horca(int i) throws FileNotFoundException{
        Scanner scan;
        switch (i){
            case 1:
                File archivo1 = new File ("src/juegoahorcado/horca1");
                scan = new Scanner(archivo1);
                while (scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }
                scan.close();
                break;
            case 2:
                File archivo2 = new File ("src/juegoahorcado/horca2");
                scan = new Scanner(archivo2);
                while (scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }
                scan.close();
                break;
            case 3:
                File archivo3 = new File ("src/juegoahorcado/horca3");
                scan = new Scanner(archivo3);
                while (scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }
                scan.close();
                break;
            case 4:
                File archivo4 = new File ("src/juegoahorcado/horca4");
                scan = new Scanner(archivo4);
                while (scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }
                scan.close();
                break;
            case 5:
                File archivo5 = new File ("src/juegoahorcado/horca5");
                scan = new Scanner(archivo5);
                while (scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }
                scan.close();
                break;
            case 6:
                File archivo6 = new File ("src/juegoahorcado/horca6");
                scan = new Scanner(archivo6);
                while (scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }
                scan.close();
                break;
        }
    }
    /***************************************************************************
     * Este método va almacenando en las posiciones del array contador las vic-
     * torias y derrotas en cada nivel de dificultad, siendo las posiciones 0 y 
     * 1 las de victoria y derrota en fácil, 2 y 3 las de victoria y derrota en 
     * medio y 4 y 5 las de victoria y derrota en difícil. Funciona.
     * @param victoria
     * @param nivel
     * @param contador
     * @return 
     **************************************************************************/
    public static int[] contador(boolean victoria, String nivel, int[] contador){
        switch (nivel){
            case "f":
                if (victoria){
                    contador[0]++;
                } else {
                    contador[1]++;
                }
                break;
            case "m":
                if (victoria){
                    contador[2]++;
                } else {
                    contador[3]++;
                }
                break;
            case "d":
                if (victoria){
                    contador[4]++;
                } else {
                    contador[5]++;
                }
                break;
        }
        return contador;
    }
    /***************************************************************************
     * Este método nos permite almacenar en un fichero de datos los resultados 
     * de las distintas partidas que se jueguen, incluso aunque cerremos el pro-
     * grama. Las almacena en un formato que coincide con el del return del mé-
     * todo contador para así facilitar su recuperación.
     * @param contador
     * @throws IOException 
     **************************************************************************/
    public static void acumulado(int[] contador) throws IOException{
        FileWriter ficheroResultados = new FileWriter("src/juegoahorcado/datospartidas", true);
        PrintWriter pwResultados = new PrintWriter (ficheroResultados);
        try{
            for(int i = 0; i < 6; i++){
                pwResultados.print(contador[i] + " ");
                if (i==5){
                    pwResultados.print("\n");
                }
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if(null != ficheroResultados){
                    ficheroResultados.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    /***************************************************************************
     * Este método nos permite recuperar los datos guardados en el archivo del
     * método anterior e imprimir en pantalla los resultados del mismo.
     * @throws FileNotFoundException 
     **************************************************************************/
    public static void imprimeDatos() throws FileNotFoundException{
        File archivoDatos = new File ("src/juegoahorcado/datospartidas");
        Scanner scan = new Scanner (archivoDatos);
        int[] resultadoHistorico = {0, 0, 0, 0, 0, 0};
        while (scan.hasNextLine()){
            for (int i = 0; i < resultadoHistorico.length; i++){
                resultadoHistorico[i] = resultadoHistorico[i] + scan.nextInt();
            }
            scan.nextLine();
        }
        scan.close();
        System.out.println(" =================================================");
        System.out.println("|           ACUMULADO HISTÓRICO                   |");
        System.out.println("|     - NIVEL FÁCIL: " + resultadoHistorico[0] + " Ganadas, " + resultadoHistorico[1] + " Perdidas.       |");
        System.out.println("|     - NIVEL MEDIO: " + resultadoHistorico[2] + " Ganadas, " + resultadoHistorico[3] + " Perdidas.       |");
        System.out.println("|     - NIVEL DIFÍCIL: " + resultadoHistorico[4] + " Ganadas, " + resultadoHistorico[5] + " Perdidas.     |");
        System.out.println(" ================================================");
    }
    /***************************************************************************
     * Este método nos da la opción de borrar el registro acumulado de partidas.
     * @throws FileNotFoundException 
     **************************************************************************/
    public static void borraDatos() throws FileNotFoundException{
        File archivo = new File ("src/juegoahorcado/datospartidas");
        try (PrintWriter borrador = new PrintWriter(archivo)) {
            borrador.write("");
            borrador.close();
            System.out.println("RESETEO CON ÉXITO.");
        }
    }
    /***************************************************************************
     * Este método es el encargado de imprimir en pantalla el récord de victorias
     * y derrotas del jugador en cada nivel de juego. Funciona.
     * @param contador 
     **************************************************************************/
    public static void resumen(int[] contador){
        System.out.println(" =================================================");
        System.out.println("|           RESUMEN DE LA PARTIDA                 |");
        System.out.println("|     - NIVEL FÁCIL: " + contador[0] + " Ganadas, " + contador[1] + " Perdidas.       |");
        System.out.println("|     - NIVEL MEDIO: " + contador[2] + " Ganadas, " + contador[3] + " Perdidas.       |");
        System.out.println("|     - NIVEL DIFÍCIL: " + contador[4] + " Ganadas, " + contador[5] + " Perdidas.     |");
        System.out.println(" ================================================");
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner entrada = new Scanner (System.in);
        int[] contador = {0, 0, 0, 0, 0, 0};
        System.out.println("¡Bienvenido grumete! ¿Cuál es tu nombre?");
        String nombre = entrada.nextLine();
        /***********************************************************************
        * Esto, hasta el final del while, sirve para controlar lo de las normas.
        ***********************************************************************/
        boolean bucleNormas = false;
        while (!bucleNormas){
            System.out.println("¿Desea usted que se le expliquen las normas de este juego antes de comenzar?");
            System.out.println("Escriba SI o NO.");
            String normas = entrada.nextLine().toLowerCase();
            if ("si".equals(normas)){
                imprimeNormas();
                bucleNormas = true;
                System.out.println("Muy bien, ya podemos comenzar.");
            } else if ("no".equals(normas)){
                System.out.println("Muy bien listillo, continuemos.");
                bucleNormas = true;
            }
        }
        /***********************************************************************
         * A partir de aquí tenemos la mecánica de la partida en si. cada vuelta
         * al while será una partida distinta.
         **********************************************************************/
        boolean otraPartida = true;
        while (otraPartida){
            /***********************************************************************
             * Selector nivel de dificultad. Funciona.
             **********************************************************************/
            String nivel = "";
            while ((!"f".equals(nivel))&&(!"m".equals(nivel))&&(!"d".equals(nivel))){
                System.out.println("Seleccione el nivel de dificultad: fácil(F), medio(M) o difícil(D).");
                nivel = entrada.nextLine().toLowerCase();
            }
            String palabra = selectorPalabra(nivel).toLowerCase();//En nuestros archivos van a estar en minúsculas siempre, pero por si acaso viniera alguna mayúscula, nos aseguramos.
            /***********************************************************************
             * Aquí se desarrolla el proceso del juego.
             **********************************************************************/
            char[] respuesta = palabra.toCharArray();
            char[] intento = new char [respuesta.length];
            char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
            boolean victoria = false;
            for (int i = 0; i < intento.length; i++){
                intento[i] = '-';
            }
            int aciertos = 0;
            for (int i = 1; i < 7; i++){
                System.out.print("Intento " + i + ": ");
                for(int j = 0; j < intento.length; j++){
                    System.out.print(intento[j]);
                }
                System.out.print("(" + aciertos + " de " + intento.length + ")\n");
                char[] letra;
                char aceptado = ' ';
                boolean check = false;
                while (!check){
                    System.out.println("Vamos, dime una letra:");
                    String recibido = entrada.nextLine().toLowerCase();
                    letra = recibido.toCharArray();
                    if((letra.length == 1) && (validaDatos(letra))){
                        aceptado = letra[0];
                        check = true;
                    }
                }
                boolean bueno = false;
                for (int j = 0; j < respuesta.length; j++){
                    if (aceptado == respuesta [j]){
                        intento[j] = respuesta [j];
                        aciertos++;
                        bueno = true;
                    }
                }
                for (int k = 0; k < alfabeto.length; k++){//Con este for mostramos el alfabeto al jugador y borramos de él las letras ya usadas.
                    if (aceptado == alfabeto[k]){
                        alfabeto[k] = '-';
                    }
                }
                victoria = victoria(respuesta, intento);
                if (victoria){
                    System.out.println("¡¡¡GANASTE!!!");
                    System.out.println("La palabra oculta era: " + palabra);
                    System.out.println("¡" + nombre + " nos está prometiendo mucha diversión y grog gratis!");
                    break;
                } else if (bueno){//En este else if, nos aseguramos de que si el jugador ha acertado una letra, no se le penalice contando un intento.
                        i--;
                        horca(i);
                        for(int a = 0; a < alfabeto.length; a++){
                            System.out.print(alfabeto[a] + " ");
                        }
                        System.out.print("\n");
                    } else {
                        horca(i);
                        for(int a = 0; a < alfabeto.length; a++){
                            System.out.print(alfabeto[a] + " ");
                        }
                        System.out.print("\n");
                    }
            }
            contador = contador(victoria, nivel, contador);
            if (!victoria){
                System.out.println("¡Luchas como un granjero!");
            }
            System.out.println("Fin de la partida. Si desea volver a jugar, pulse 1. Si desea terminar, pulse 2.");
            String nuevoJuego = entrada.nextLine();
            while ((!"1".equals(nuevoJuego))&&(!"2".equals(nuevoJuego))){
                System.out.println("Ha introducido un comando no válido. Si desea volver a jugar, pulse 1. Si desea terminar, pulse 2.");
                nuevoJuego = entrada.nextLine();
            }
            if ("1".equals(nuevoJuego)){
                otraPartida = true;
            } else {
                otraPartida = false;
                resumen(contador);
                acumulado(contador);
            }
        }
        System.out.println("¿Quieres ver el acumulado? Si su respuesta es sí, pulse 1. Si desea resetear el historial de partidas, pulse 2. Si solo desea terminar el programa, pulse cualquier otra tecla.");
        String acumulado = entrada.nextLine();
        switch (acumulado){
            case "1":
                imprimeDatos();
                System.out.println("Guybrush: Al menos he aprendido algo de todo esto.");
                System.out.println("Elaine: ¿Qué?");
                System.out.println("Guybrush: Nunca pagues más de 20 duros por un videojuego.");
                System.out.println("Elaine: ¿Un qué?");
                System.out.println("Guybrush: No sé. No tengo ni idea por qué dije eso.");
                break;
            case "2":
                borraDatos();
                System.out.println("Guybrush: Al menos he aprendido algo de todo esto.");
                System.out.println("Elaine: ¿Qué?");
                System.out.println("Guybrush: Nunca pagues más de 20 duros por un videojuego.");
                System.out.println("Elaine: ¿Un qué?");
                System.out.println("Guybrush: No sé. No tengo ni idea por qué dije eso.");
                break;
            default:
                System.out.println("Guybrush: Al menos he aprendido algo de todo esto.");
                System.out.println("Elaine: ¿Qué?");
                System.out.println("Guybrush: Nunca pagues más de 20 duros por un videojuego.");
                System.out.println("Elaine: ¿Un qué?");
                System.out.println("Guybrush: No sé. No tengo ni idea por qué dije eso.");
                System.out.println("FIN DEL JUEGO");
                break;
        }
    }
}