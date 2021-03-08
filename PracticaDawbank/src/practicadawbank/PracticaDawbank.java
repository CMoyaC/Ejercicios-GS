/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicadawbank;

import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class PracticaDawbank {

    /**
     * @return 
     */
    public static int seleccion(){
        Scanner scan = new Scanner(System.in);
        int seleccion;
        System.out.println("Bienvenido a DAWBANK. Seleccione una opción.");
        System.out.println("  (1) Datos de la cuenta.");
        System.out.println("  (2) IBAN.");
        System.out.println("  (3) Titular.");
        System.out.println("  (4) Saldo.");
        System.out.println("  (5) Ingreso.");
        System.out.println("  (6) Retirada.");
        System.out.println("  (7) Movimientos.");
        System.out.println("  (8) Salir.");
        seleccion = scan.nextInt();
//        scan.close();
        return seleccion;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
//        CuentaBancaria c1 = new CuentaBancaria("ES6621000418401234567891", "Juan Juanez");
//        CuentaBancaria c2 = new CuentaBancaria("ES6621000418401234567892", "Ana Anez");
//        CuentaBancaria c3 = new CuentaBancaria("ES6621000418401234567893", "Pedro Perez");
//        CuentaBancaria c4 = new CuentaBancaria("ES6621000418401234567894", "Lope Lopez");
//        CuentaBancaria c5 = new CuentaBancaria("ES6621000418401234567895", "Martin Martinez");
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el IBAN de su cuenta: ");
        String iban = scan.next();
        scan.nextLine();
        System.out.println("Introduzca su nombre: ");
        String titular = scan.nextLine();
        CuentaBancaria prueba = new CuentaBancaria(iban, titular);
        
        boolean cierre = false;
        
        while (!cierre){
            switch (seleccion()){
                case 1:
                    System.out.println("IBAN: " + prueba.getIban());
                    System.out.println("Titular: " + prueba.getTitular());
                    if(prueba.getSaldo() < 0){
                        System.err.println("Saldo: " + prueba.getSaldo());
                    } else {
                        System.out.println("Saldo: " + prueba.getSaldo());
                    }
                    break;
                case 2:
                    System.out.println("IBAN: " + prueba.getIban());
                    break;
                case 3:
                    System.out.println("Titular: " + prueba.getTitular());
                    break;
                case 4:
                    if(prueba.getSaldo() < 0){
                        System.err.println("Saldo: " + prueba.getSaldo());
                    } else {
                        System.out.println("Saldo: " + prueba.getSaldo());
                    }
                    break;
                case 5:
                    System.out.println("Introduzca la cantidad que desea ingresar: ");
                    prueba.ingreso(scan.nextDouble());
                    break;
                case 6:
                    System.out.println("Introduzca la cantidad que desea retirar: ");
                    prueba.retirada(scan.nextDouble());
                    break;
                case 7:
                    System.out.println("Historial de movimientos: ");
                    prueba.movimientos();
                    break;
                case 8:
                    cierre = true;
                    System.out.println("Cerrando aplicación... Gracias por elegir DAWBANK.");
            }
        }
        scan.close();
    }
        
//        System.out.println(c1.iban);
//        System.out.println(c1.titular);
//        System.out.println(c2.iban);
//        System.out.println(c2.titular);
//        System.out.println(c3.iban);
//        System.out.println(c3.titular);
//        System.out.println(c4.iban);
//        System.out.println(c4.titular);
//        System.out.println(c5.iban);
//        System.out.println(c5.titular);
        
//        System.out.println(c1.saldo);
//        c1.ingreso(40);
//        System.out.println(c1.saldo);
//        c1.ingreso(0);
//        System.out.println(c1.saldo);
//        c1.ingreso(-5);
//        System.out.println(c1.saldo);
//        c1.ingreso(4000);
//        System.out.println(c1.saldo);
//        c1.ingreso(100);
//        System.out.println(c1.saldo);
//        c1.retirada(10);
//        System.out.println(c1.saldo);
//        c1.ingreso(20);
//        System.out.println(c1.saldo);
//        c1.retirada(100);
//        System.out.println(c1.saldo);
//        System.out.println(c1.getMovimientos());
//    }
//    
}
