package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empleado;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpleadoDAOImplementation implements IEmpleadoDAO{
    private EntityManager entityManager;
    
    @Autowired 
    public EmpleadoDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    

    @Override
    public List<Empleado> GetAll() {
        TypedQuery<Empleado> query = entityManager.createQuery("FROM Empleado", Empleado.class);
        List<Empleado> empleados = query.getResultList();

        return empleados;
    }

    @Override
    public int Add(Empleado empleado) {
        entityManager.merge(empleado);
        return empleado.getIdempleado();

    }

    @Override
    public void Delete(Empleado empleado) {
        entityManager.remove(empleado);
    }

    @Override
    @Transactional
    public void Update(Empleado empleado) {
        entityManager.merge(empleado);
    }

    @Override
    public Empleado GetById(int idEmpleado) {
        TypedQuery<Empleado> query = entityManager.createQuery("FROM Empleado WHERE idempleado=:idempleado", Empleado.class);
        query.setParameter("idEmpleado", idEmpleado);
           
        return query.getSingleResult();
    }
    
}
