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
public class CuentaAhorro extends CuentaBancaria{
    private final double saldoMinimo = 1000.0;

    public CuentaAhorro(String iban, String nombreCliente, double saldo) {
        super(iban, nombreCliente, saldo);
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }
    
    @Override
    public void calcularIntereses(){
        int creacion = this.getFechaCreacion().getYear();
        int hoy = LocalDate.now().getYear();
        if((creacion - hoy == -1)){
            if(this.getSaldo() >= this.saldoMinimo){
                this.movimientos.add("Abono anual de intereses: " + (this.getSaldo()*(2*this.getInteresAnualBasico())) + "€.");
                this.saldo = this.getSaldo() * (1 + (2*this.getInteresAnualBasico()));
                System.out.println("Se le han abonado los intereses de su cuenta.");
            } else {
                this.movimientos.add("Abono anual de intereses: " + (this.getSaldo()*(this.getInteresAnualBasico()/2)) + "€.");
                this.saldo = this.getSaldo() * (1 + (this.getInteresAnualBasico()/2));
                System.out.println("Se le han abonado los intereses de su cuenta.");
            }
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
