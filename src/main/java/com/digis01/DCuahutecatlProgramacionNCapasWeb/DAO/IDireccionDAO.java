
package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Direccion;
import java.util.List;

public interface IDireccionDAO {
    List<Direccion> GetAll();
    void Add(Direccion direccion);
}
