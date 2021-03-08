/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e18_sudokusalternativo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class E18_SudokusAlternativo {

    /**
     * @param comprobacion
     * @param sudoku
     * @return 
     */
    public static boolean checkFilas(int[] comprobacion, int[][] sudoku){
        boolean check = true;
        int[] fila = new int[9];
        
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                fila[j] = sudoku [i][j];
            }
            Arrays.sort(fila);
            for (int k = 0; k < 9; k++){
                if (fila[k] != comprobacion[k]){
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    
    public static boolean checkColumnas(int[] comprobacion, int[][] sudoku){
        boolean check = true;
        int[] columna = new int[9];
        
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                columna[j] = sudoku[j][i];
            }
            Arrays.sort(columna);
            for (int k = 0; k < 9; k++){
                if (columna[k] != comprobacion[k]){
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    
    public static boolean checkCuadrante(int[] comprobacion, int[][] sudoku){
        int[] celdaCheck = new int[9];
        int[][] celda = new int[3][3];
        boolean check = true;
        
        for ( int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        celda[i][j] = sudoku [i+(x*3)][j+(y*3)]; 
                    }   
                }
                int n = 0;
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        celdaCheck[n] = celda[i][j];
                        n++;
                    }
                }
                Arrays.sort(celdaCheck);
                for (int k = 0; k < celdaCheck.length; k++){
                    if (celdaCheck[k] != comprobacion[k]){
                        check = false;
                        break;
                    }
                }
            }
        }
        return check;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File archivo = new File ("src/e18_sudokusalternativo/datos");
        Scanner scan = new Scanner (archivo);
        int[][] sudoku = new int[9][9];
        final int [] comprobacion = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        int numCasos = scan.nextInt();
        while (scan.hasNextLine() && numCasos != 0){
            for(int j = 0; j < sudoku.length; j++){
                for(int k = 0; k < sudoku[j].length; k++){
                    sudoku[j][k] = scan.nextInt();
                }
            }
            boolean checkFilas = checkFilas(comprobacion, sudoku);
            if (checkFilas == true){
                boolean checkColumnas = checkColumnas(comprobacion, sudoku);
                if (checkColumnas == true){
                    boolean checkCuadrante = checkCuadrante(comprobacion, sudoku);
                    if (checkCuadrante == true){
                        System.out.println("SI");
                    } else {
                        System.out.println("NO");
                    }
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
            numCasos--;
        }
        if(numCasos > 0 && !scan.hasNextLine()){
            System.out.println("ERROR, FALTAN DATOS EN EL ARCHIVO.");
        }
        if(scan.hasNextLine()){
            System.out.println("QUEDAN DATOS POR CORREGIR. POR FAVOR, REVISE EL FICHERO Y ASEGÚRESE DE QUE EL NÚMERO DE CASOS A ESTUDIAR COINCIDA CON LOS QUE CONTIENE EL ARCHIVO.");
        }
        System.out.println("FIN DEL PROGRAMA.");
    }
    
}
