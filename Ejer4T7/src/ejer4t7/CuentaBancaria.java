/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4t7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public abstract class CuentaBancaria {
    protected String iban;
    protected double saldo;
    protected String nombreCliente;
    protected ArrayList<String> movimientos = new ArrayList<>();
    protected final double interesAnualBasico = 0.05;
    protected LocalDate fechaCreacion;
    
    CuentaBancaria(String iban, String nombreCliente, double saldo){
        String regex1 = "\\D{2}\\d{22}";
        String regex2 = "^([A-Z]{1}[a-z]+[ ]?){2,5}$";
        if (!iban.matches(regex1) || iban.isEmpty()){
            System.err.println("ERROR, código IBAN no válido.");
        } else if (!nombreCliente.matches(regex2) || nombreCliente.isEmpty()){
                System.err.println("ERROR, nombre del titular no válido.");
            } else if (saldo < 0) {
                    System.err.println("ERROR, saldo inferior al mínimo válido.");
                this.iban = iban;
                this.nombreCliente = nombreCliente;
                this.saldo = saldo;
                this.fechaCreacion = LocalDate.now();
            }
        
    }
    public void consulta(){
        System.out.println("************* DATOS DE LA CUENTA ***************");
        System.out.println(" - Titular: " + this.nombreCliente);
        System.out.println(" - IBAN: " + this.iban);
    }
    
    public void ingreso(double ingreso){
        if (ingreso > 0){
            this.saldo = this.saldo + ingreso;
            this.movimientos.add("Ingreso de " + ingreso + "€.");
            System.out.println("Ingreso realizado con éxito.");
        } else {
            System.err.println("Ha de introducir una cantidad mayor a 0 para realizar un ingreso.");
        }
    }
    public void retirada(double cantidad){
        if (cantidad > 0){
            this.saldo = this.saldo - cantidad;
            this.movimientos.add("Retirada de " + cantidad + "€.");
            if (this.saldo < 0){
                System.out.println("AVISO: Saldo negativo.");
            }
        } else {
            System.err.println("No se ha podido realizar la retirada. Cantidad no válida.");
        }
    }
    public void transferencia(CuentaBancaria cb, double importe){
        Scanner scan = new Scanner(System.in);
        String concepto;
        if(cb.saldo > 0){
            this.saldo = this.getSaldo() - importe;
            cb.saldo = cb.saldo + importe;
            System.out.println("Introduzca concepto de la transferencia:");
            concepto = scan.nextLine();
            this.movimientos.add("Transferencia de " + importe + "€ a la cuenta a nombre de " + cb.getNombreCliente() + ". Motivo: " + concepto);
        } else {
            System.err.println("No hay saldo suficiente como para hacer la transferencia.");
        }
    }
    
    private void añadir(){
    
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public ArrayList<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<String> movimientos) {
        this.movimientos = movimientos;
    }

    public double getInteresAnualBasico() {
        return interesAnualBasico;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    
    public abstract void calcularIntereses();
    public abstract void mostrarDatos();
}
