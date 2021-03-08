/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicadawbank;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class CuentaBancaria {
    
    private String iban;
    private String titular;
    private double saldo;
    private ArrayList<String> movimientos = new ArrayList<>();
    private static final int SALDONEGATIVO = -50;
    private static final int LIMITEHACIENDA = 3000;
    
    CuentaBancaria(){
    
    }
    
    CuentaBancaria(String iban, String titular){
        String regex1 = "\\D{2}\\d{22}";
        String regex2 = "^([A-Z]{1}[a-z]+[ ]?){2,5}$";
        if (!iban.matches(regex1) || iban.isEmpty()){
            System.err.println("ERROR, código IBAN no válido.");
        } else if (!titular.matches(regex2) || titular.isEmpty()){
                System.err.println("ERROR, nombre del titular no válido.");
            } else {
                this.iban = iban;
                this.titular = titular;
            }
    }

    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<String> getMovimientos() {
        return movimientos;
    }

    public int getSaldoNegativo() {
        return SALDONEGATIVO;
    }

    public int getLimiteHacienda() {
        return LIMITEHACIENDA;
    }
    
    public void ingreso(double cantidad){
        if (cantidad > 0){
            this.saldo = this.saldo + cantidad;
            this.movimientos.add("Ingreso de " + cantidad + "€.");
            if (cantidad > this.LIMITEHACIENDA){
            System.out.println("AVISO: Notificar a Hacienda.");
            }
        } else {
            System.err.println("No se ha podido realizar el ingreso. Cantidad no válida.");
        }
    }
    
    public void retirada(double cantidad){
        if (cantidad > 0){
            if ((this.saldo - cantidad) < this.SALDONEGATIVO){
                System.err.println("No se ha podido realizar la retirada. No dispone de saldo suficiente en su cuenta.");
            } else {
                this.saldo = this.saldo - cantidad;
                this.movimientos.add("Retirada de " + cantidad + "€.");
                if (cantidad > this.LIMITEHACIENDA){
                    System.out.println("AVISO: Notificar a Hacienda.");
                }
                if (this.saldo < 0){
                    System.err.println("AVISO: Saldo negativo.");
                }
            }
        } else {
            System.err.println("No se ha podido realizar la retirada. Cantidad no válida.");
        }
    }
    
    public void movimientos(){
        for (int i = 0; i < this.movimientos.size(); i++) {
            System.out.println("Movimiento " + (i + 1) + ": " + this.movimientos.get(i));
        }
    }
}
