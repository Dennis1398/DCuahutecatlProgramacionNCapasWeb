/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Controller;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Entity.NumeroOperacion;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Entity.Resultado;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.demoREST.Service.DemoServiceImplementation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @PostMapping("/suma")
    public Resultado suma(@RequestBody NumeroOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Suma(numeros);
    }
    
    @PostMapping("/resta")
    public Resultado resta(@RequestBody NumeroOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Resta(numeros);
    }
    
    @PostMapping("/multiplicacion")
    public Resultado multiplicacion(@RequestBody NumeroOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Resta(numeros);
    }
    
    @PostMapping("/division")
    public Resultado division(@RequestBody NumeroOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Resta(numeros);
    }

    
}
