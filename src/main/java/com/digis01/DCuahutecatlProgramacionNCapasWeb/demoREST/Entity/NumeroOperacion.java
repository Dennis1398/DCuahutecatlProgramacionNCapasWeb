/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Entity;

/**
 *
 * @author digis
 */
public class NumeroOperacion {
    private double numero1;
    private double numero2;

    public NumeroOperacion() {
    }

    public NumeroOperacion(double numero1) {
        this.numero1 = numero1;
    }

    public NumeroOperacion(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }
    
}
