package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Municipio;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Colonia;
import java.util.List;


public interface IColoniaDAO {
    List<Colonia> GetAll();
    List<Colonia> GetByIdMunicipio(int IdMunicipio);
}
