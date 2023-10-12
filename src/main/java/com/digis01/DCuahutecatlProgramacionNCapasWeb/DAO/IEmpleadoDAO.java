
package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empleado;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empresa;
import java.util.List;


public interface IEmpleadoDAO {
    List<Empleado> GetAll();
    int Add(Empleado empleado);
    void Delete(Empleado empleado);
    void Update(Empleado empleado);
    Empleado GetById(int idEmpleado);
}
