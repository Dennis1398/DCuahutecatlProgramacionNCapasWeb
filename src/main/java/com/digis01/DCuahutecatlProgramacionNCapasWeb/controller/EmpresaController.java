package com.digis01.DCuahutecatlProgramacionNCapasWeb.controller;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.EmpresaDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empresa;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Usuario;
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
@RequestMapping("/empresa")
public class EmpresaController {
    private EmpresaDAOImplementation empresaDAOImplementation;
    
    
    @Autowired
    public EmpresaController(EmpresaDAOImplementation empresaDAOImplementation){
        this.empresaDAOImplementation = empresaDAOImplementation;
    }
            

    @GetMapping("/lista")
    private String ListadoEmpresas(Model model){
    List<Empresa> empresas = empresaDAOImplementation.GetAll(); 
        model.addAttribute("empresas",empresas); 
        model.addAttribute("empresa", new Empresa());
        return "ListadoEmpresas";
        
    }
    
    @GetMapping("/formulario/{idempresa}")
    public String Formulario(@PathVariable int idempresa, Model model){
        
        if(idempresa == 0){  
            model.addAttribute("empresa", new Empresa());
            return "FormularioEmpresa";
        }
        else {        
            Empresa empresa = empresaDAOImplementation.GetById(idempresa);
            model.addAttribute("empresa", empresa);
            return "FormularioEmpresa";
        }
    }
    
    @PostMapping("/formulario")
    public String Update(@Valid @ModelAttribute ("empresa") Empresa empresa,
            @RequestParam("imagenFile") MultipartFile imagenFile, Model model){        
        
        if(empresa.getIdempresa() > 0){
            empresaDAOImplementation.Update(empresa);
        } else {
            empresaDAOImplementation.Add(empresa);
        }
        return "redirect:/empresa/lista"; 
        
        
    }
    
    @PostMapping("/eliminar/{idempresa}")
    public String Delete(@PathVariable int idEmpresa, Model model){
        Empresa empresa= empresaDAOImplementation.GetById(idEmpresa);
        model.addAttribute("empresa", empresa);
        return "redirect:/empresa/lista";
    }
}
