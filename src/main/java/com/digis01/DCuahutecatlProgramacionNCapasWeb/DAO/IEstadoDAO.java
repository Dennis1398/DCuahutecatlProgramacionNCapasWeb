package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Estado;
import java.util.List;


public interface IEstadoDAO {
    List<Estado> GetAll();
      List<Estado> GetByIdPais(int IdPais);
}
