/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Service;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Entity.NumeroOperacion;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Entity.Resultado;

/**
 *
 * @author digis
 */
public interface IDemoServicio {
    Resultado Suma(NumeroOperacion numeroOperacion);
    Resultado Resta(NumeroOperacion numeroOperacion);
    Resultado Multiplicacion(NumeroOperacion numeroOperacion);
    Resultado Division(NumeroOperacion numeroOperacion);
}



