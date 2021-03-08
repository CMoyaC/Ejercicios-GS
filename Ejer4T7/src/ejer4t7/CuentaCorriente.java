/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4t7;

import java.time.LocalDate;

/**
 *
 * @author Carlos
 */
public class CuentaCorriente extends CuentaBancaria{

    public CuentaCorriente(String iban, String nombreCliente, double saldo) {
        super(iban, nombreCliente, saldo);
    }
    
    @Override
    public void calcularIntereses(){
        int creacion = this.getFechaCreacion().getYear();
        int hoy = LocalDate.now().getYear();
        if(creacion - hoy == -1){
            this.movimientos.add("Abono anual de intereses: " + (this.getSaldo()*this.getInteresAnualBasico()) + "€.");
            this.saldo = this.getSaldo() * (1 + this.getInteresAnualBasico());
            System.out.println("Se le han abonado los intereses de su cuenta.");
        } else {
            System.out.println("No toca abonar intereses. De ser así su saldo sería " + (this.getSaldo() * (1 + this.getInteresAnualBasico())));
        }
    }
    @Override
    public void mostrarDatos(){
        System.out.println("************* DATOS DE LA CUENTA ***************");
        System.out.println(" - Titular: " + this.nombreCliente);
        System.out.println(" - IBAN: " + this.iban);
        System.out.println(" - Tipo de interés: " + this.interesAnualBasico);
        System.out.println(" - Saldo: " + this.saldo);
    }
}
