/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Service;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Entity.NumeroOperacion;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Entity.Resultado;

/**
 *
 * @author digis
 */
public class DemoServiceImplementation implements IDemoServicio {
    @Override
    public Resultado Suma(NumeroOperacion numeroOperacion) {
        return new Resultado(numeroOperacion.getNumero1() + numeroOperacion.getNumero2());
    }
    @Override
    public Resultado Resta(NumeroOperacion numeroOperacion) {
        return new Resultado(numeroOperacion.getNumero1()- numeroOperacion.getNumero2());
    }

    @Override
    public Resultado Multiplicacion(NumeroOperacion numeroOperacion) {
        return new Resultado(numeroOperacion.getNumero1()* numeroOperacion.getNumero2());
    }

    @Override
    public Resultado Division(NumeroOperacion numeroOperacion) {
       return new Resultado(numeroOperacion.getNumero1()/ numeroOperacion.getNumero2());
    }
}
