package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empresa;
import java.util.List;


public interface IEmpresaDAO {
    List<Empresa> GetAll();
    int Add(Empresa empresa);
    void Delete(Empresa empresa);
    void Update(Empresa empresa);
    Empresa GetById(int idEmpresa);
     
}
