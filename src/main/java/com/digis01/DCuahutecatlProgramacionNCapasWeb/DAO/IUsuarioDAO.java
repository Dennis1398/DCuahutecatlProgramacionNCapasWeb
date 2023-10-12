package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;


import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empresa;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Usuario;
import jakarta.persistence.Id;
import java.util.List;
public interface IUsuarioDAO {
    
     List<Usuario> GetAll(Usuario usuario);
     int Add(Usuario usuario);
     void Delete(Usuario usuario);
     Usuario GetById(int idusuarioeditable);
     void Update(Usuario usuario);
     void ChangeStatus(int idUsuario, boolean status);
}


