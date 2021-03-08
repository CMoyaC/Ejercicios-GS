/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusvacios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class SudokusVacios {

    /**
     * @param fila
     * @param filaInversa
     * @return 
     */
    public static boolean comprobador(String[] fila, String[] filaInversa){
        boolean check = true;
        int i = 0, j = 8, contador = 0;
        char[] filaComp, filaCompInv;
        
        while (i < 4 && j > 4){
            filaComp = fila[i].toCharArray();
            filaCompInv = filaInversa[j].toCharArray();
            for(int k = 0; k < filaComp.length; k++){
                if (((filaComp[k] != '-')&&(filaCompInv[k] == '-')) || ((filaComp[k] == '-')&&(filaCompInv[k] != '-'))){
                    check = false;
                    break;
                }
                if (filaComp[k] != '-'){
                    contador++;
                }
                if (filaCompInv[k] != '-'){
                    contador++;
                }
            }
            i++;
            j--;
        }
        
        filaComp = fila[4].toCharArray();
        filaCompInv = filaInversa[4].toCharArray();
        for (int l = 0; l < filaComp.length; l++){
            if (((filaComp[l] != '-')&&(filaCompInv[l] == '-')) || ((filaComp[l] == '-')&&(filaCompInv[l] != '-'))){
                check = false;
                break;
            }
            if (filaComp[l] != '-'){
                    contador++;
            }
            if (filaCompInv[l] != '-'){
                contador++;
            }
        }
        //TODO ENTRE ESTAS DOS BARRAS Y LAS SIGUIENTES SIRVE PARA COPROBAR QUE 
        //EN LAS CELDAS DE 3X3 NO SE REPITAN VALORES; NI EN LAS FILAS; NI EN LAS
        //COLUMNAS.
        char[][] sudoku = new char[9][9];
        char[][] celda = new char[3][3];
        for (int m = 0; m < 9; m++){
            filaComp = fila[m].toCharArray();
            for (int n = 0; n < 9; n++){
                sudoku[m][n] = filaComp[n];
            }
        }
        for ( int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                for (int v = 0; v < 3; v++){
                    for (int w = 0; w < 3; w++){
                        celda[v][w] = sudoku [v+(x*3)][w+(y*3)]; 
                    }   
                }
                int c = 0;
                char[]grupo = new char[9];
                for (int a = 0; a < 3; a++){
                    for (int b = 0; b < 3; b++){
                        grupo[c] = sudoku [a][b];
                        c++;
                    }   
                }
                Arrays.sort(grupo);
                for (int d = 0; d < grupo.length-1; d++){
                    if ((grupo[d] != '-') && (grupo[d] == grupo[d+1])){
                        check = false;
                        break;
                    }
                }
            }
        }
        char[]linea = new char[9];
        for (int f = 0; f < 9; f++){
            for (int g = 0; g < 9; g++){
                linea[g] = sudoku [f][g];
            }
            Arrays.sort(linea);
            for (int h = 0; h < linea.length-1; h++){
                if ((linea[h] != '-') && (linea[h] == linea[h+1])){
                    check = false;
                    break;
                }
            } 
        }
        char[]columna = new char[9];
        for (int o = 0; o < 9; o++){
            for (int p = 0; p < 9; p++){
                columna[p] = sudoku [p][o];
            }
            Arrays.sort(columna);
            for (int q = 0; q < columna.length-1; q++){
                if ((columna[q] != '-') && (columna[q] == columna[q+1])){
                    check = false;
                    break;
                }
            } 
        }
        //
        if (contador > 32){
            check = false;
        }
        
        return check;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File ("src/sudokusvacios/datos");
        Scanner scan = new Scanner (archivo);
        
        int numCasos = 0;
        numCasos = scan.nextInt();
        scan.nextLine();
        
        while (numCasos != 0){
            scan.nextLine();
            String [] fila = new String[9];
            char[] valores = new char[9];
            char[] inversa = new char[9];
            String [] filaInversa = new String[9];
            
            for (int i = 0; i < 9; i++){
                fila[i] = scan.nextLine();
                valores = fila[i].toCharArray();
                int k = 8;
                for (int j = 0; j < 9; j++){
                    inversa [j] = valores[k];
                    k--;
                }
                filaInversa[i] = String.copyValueOf(inversa);
            }
            boolean comprobador = comprobador(fila, filaInversa);
            if(comprobador){
                System.out.print("SI\n");
            } else {
                System.out.print("NO\n");
            }
            numCasos--;
        }
    } 
}