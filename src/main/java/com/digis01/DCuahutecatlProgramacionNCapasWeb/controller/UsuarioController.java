package com.digis01.DCuahutecatlProgramacionNCapasWeb.controller;


import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.ColoniaDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.DireccionDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.EstadoDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.MunicipioDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.PaisDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.RolDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Pais;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Colonia;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Direccion;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empresa;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Estado;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Municipio;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Rol;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Usuario;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.UsuarioDireccion;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    private UsuarioDAOImplementation usuarioDAOImplementation;
    private DireccionDAOImplementation direccionDAOImplementation;
    private RolDAOImplementation rolDAOImplementation;
    private PaisDAOImplementation paisDAOImplementation;
    private EstadoDAOImplementation estadoDAOImplementation;
    private MunicipioDAOImplementation municipioDAOImplementation;
    private ColoniaDAOImplementation coloniaDAOImplementation;
    
    @Autowired 
    public UsuarioController(UsuarioDAOImplementation usuarioDAOImplementation,
            DireccionDAOImplementation direccionDAOImplementation,
            RolDAOImplementation rolDAOImplementation,
            PaisDAOImplementation paisDAOImplementation,
            EstadoDAOImplementation estadoDAOImplementation,
            MunicipioDAOImplementation municipioDAOImplementation,
            ColoniaDAOImplementation coloniaDAOImplementation
    ) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
        this.direccionDAOImplementation = direccionDAOImplementation;
        this.rolDAOImplementation = rolDAOImplementation;
        this.paisDAOImplementation = paisDAOImplementation;
        this.estadoDAOImplementation = estadoDAOImplementation;
        this.municipioDAOImplementation = municipioDAOImplementation;
        this.coloniaDAOImplementation = coloniaDAOImplementation;


    }

    @GetMapping("/listado")
    private String ListadoUsuarios(Model model){
        Usuario usuario= new Usuario();
        usuario.setNombre("");
        usuario.setApellidopaterno("");
        usuario.setApellidomaterno("");
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario); // recuperación de datos
        model.addAttribute("usuarios",usuarios); //envío de datos para HTML
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuariobusqueda", new Usuario());
        
        /*
        List<Direccion> direcciones = direccionDAOImplementation.GetAll();
        model.addAttribute("direcciones", direcciones);
        model.addAttribute("direccion", new Direccion());*/
        return "ListadoUsuarios";
        
    }
    
    @PostMapping("/listado")
    private String ListadoUsuarios(Model model, @ModelAttribute("usuariobusqueda") Usuario usuario){
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario); 
        model.addAttribute("usuarios",usuarios); 
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuariobusqueda", new Usuario());
        return "ListadoUsuarios";
        
    }
    
     @GetMapping("/form/{idusuario}")
     public String Form(@PathVariable int idusuario, Model model) {
         //List<Rol> roles = rolDAOImplementation.GetAll();
         model.addAttribute("roles", rolDAOImplementation.GetAll()); 
         model.addAttribute("paises", paisDAOImplementation.GetAll());
         if(idusuario==0) {
             model.addAttribute("usuariodireccion", new UsuarioDireccion());
             return "formUsuario";
             
         }else {
             Usuario usuario= usuarioDAOImplementation.GetById(idusuario);
             model.addAttribute("usuario", usuario);
             return "formusuario";
         }
         
         
     }
     
     @PostMapping("/form")
     public String Update(@Valid @ModelAttribute("usuariodireccion") UsuarioDireccion usuariodireccion ,
             BindingResult bindingResult,
             @RequestParam("imagenFile") MultipartFile imagenFile,
              Model model){
        if (bindingResult.hasErrors()){            
            model.addAttribute("usuariodireccion", usuariodireccion);
            return "formusuario";    
            
            
        }
        try {
            if (!imagenFile.isEmpty()) {
                byte[] bytes = imagenFile.getBytes();
                String imagenBase64 = Base64.encodeBase64String(bytes);
                usuariodireccion.getUsuario().setImagen(imagenBase64);
            } else {
                usuariodireccion.getUsuario().setImagen(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         if(usuariodireccion.getUsuario().getIdusuario()>0){
             usuarioDAOImplementation.Update(usuariodireccion.getUsuario());
         }else {
             int idUsuario= usuarioDAOImplementation.Add(usuariodireccion.getUsuario());             
             usuariodireccion.getDireccion().setIddireccion(idUsuario);
             direccionDAOImplementation.Add(usuariodireccion.getDireccion());
             
         }
         return "redirect:/usuario/listado";
     }
     
     @PostMapping("/eliminar/{idusuario}")
    public String Delete(@PathVariable int idusuario, Model model){
        Usuario usuario= usuarioDAOImplementation.GetById(idusuario);
        model.addAttribute("usuario", usuario);     
         
      return "redirect:/usuario/listado";

    }
   
    @GetMapping("/GetEstadoByIdPais")
    @ResponseBody
    public List<Estado> GetEstadoByIdPais(@RequestParam("IdPais") int IdPais) {
        List<Estado> estados = estadoDAOImplementation.GetByIdPais(IdPais); // Obtiene los datos del servicio
        return estados;
    }
    
    @GetMapping("/GetMunicipioByIdEstado")
    @ResponseBody
    public List<Municipio> GetMunicipioByIdEstado(@RequestParam("IdEstado") int IdEstado) {
        List<Municipio> municipios = municipioDAOImplementation.GetByIdEstado(IdEstado); 
        return municipios;
    }
    
    @GetMapping("/GetColoniaByIdMunicipio")
    @ResponseBody
    public List<Colonia> GetColoniaByIdMunicipio(@RequestParam("IdMunicipio") int IdMunicipio) {
        List<Colonia> colonias = coloniaDAOImplementation.GetByIdMunicipio(IdMunicipio); 
        return colonias;
    }
    
    
   
    @GetMapping("/ChangeStatus")
    @ResponseBody
    public void ChangeStatus(@RequestParam("idUsuario") int idUsuario, @RequestParam("status") boolean status) {
        usuarioDAOImplementation.ChangeStatus(idUsuario, status);
    }
    
    
} 



















    /*
    @GetMapping("/add")
    public String Add(Model model){
        model.addAttribute("usuario", new Usuario());
        return "formusuario";
    }*/


    /*
    @PostMapping("addusuario")
    public String Add(@ModelAttribute Usuario usuario){
        
        //la logica necesaria para enviar dicha información a DAO
        usuarioDAOImplementation.Add(usuario);
        
        return "redirect:/usuario/listado";
        
    }*/
    /*
    @GetMapping("/editarAlumno/{idusuario}")
    public String Update(@PathVariable int idusuario, Model model){
        
        //getByID --> precargar elforumalrio JPQL
        Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll();
        model.addAttribute("usuario", usuario);

        
        // precargarlo con el model 
        
        return "formUsuarioEditable";
    }*/
    /*
    @PostMapping("/updateUsuario")
    public String Update(@ModelAttribute Usuario usuario){
        
        usuarioDAOImplementation.Update(usuario);
        
        return "redirect:/usuario/listado";
    }*/
    
    
          
    
    
        
    
    
    
    
    /*
    @GetMapping("/editar/{idusuario}")
    public String Update(@PathVariable int idusuario, Model model){
        
        //getByID --> precargar elforumalrio JPQL
        // precargarlo con el model 
        
        return "html-para-actualizar";
    }*/

