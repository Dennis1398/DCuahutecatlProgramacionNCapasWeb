package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Estado;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Municipio;
import java.util.List;

public interface IMunicipioDAO {
    List<Municipio> GetAll();
      List<Municipio> GetByIdEstado(int IdEstado);
}
