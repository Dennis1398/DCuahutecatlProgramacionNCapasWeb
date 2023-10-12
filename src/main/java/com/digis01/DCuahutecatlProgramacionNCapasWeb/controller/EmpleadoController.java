package com.digis01.DCuahutecatlProgramacionNCapasWeb.controller;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.EmpleadoDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empleado;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empresa;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("empleado")
public class EmpleadoController {
    private EmpleadoDAOImplementation empleadoDAOImplementation;
    
    @Autowired
    public EmpleadoController(EmpleadoDAOImplementation empleadoDAOImplementation) {
        this.empleadoDAOImplementation = empleadoDAOImplementation;
    }
    
    @GetMapping("/lista")
    private String ListadoEmpleado(Model model){
    List<Empleado> empleados = empleadoDAOImplementation.GetAll(); 
        Object empleado;
        model.addAttribute("empleados",empleados); 
        model.addAttribute("empleado", new Empleado());
        return "ListadoEmpleado";
        
    }
    
    @GetMapping("/formulario/{idempleado}")
    public String Formulario(@PathVariable int idempleado, Model model){
        
        if(idempleado == 0){  
            model.addAttribute("empleado", new Empleado());
            return "FormularioEmpleado";
        }
        else {        
            Empleado empleado = empleadoDAOImplementation.GetById(idempleado);
            model.addAttribute("empleado", empleado);
            return "FormularioEmpleado";
        }
    }
    
    @PostMapping("/formulario")
    public String Update(@Valid @ModelAttribute ("empleado") Empleado empleado,
            @RequestParam("imagenFile") MultipartFile imagenFile, Model model){        
        
        if(empleado.getIdempleado() > 0){
            empleadoDAOImplementation.Update(empleado);
        } else {
            empleadoDAOImplementation.Add(empleado);
        }
        return "redirect:/empleado/lista"; 
        
        
    }
}
