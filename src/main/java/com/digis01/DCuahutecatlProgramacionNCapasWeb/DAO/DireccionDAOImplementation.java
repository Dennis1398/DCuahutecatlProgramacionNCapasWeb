
package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Direccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DireccionDAOImplementation implements IDireccionDAO {
    private EntityManager entityManager;
    
     @Autowired // inyección
    public DireccionDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Direccion> GetAll(){
        
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion", Direccion.class);
        List<Direccion> direcciones = query.getResultList();
        
        return direcciones;
    }

    @Override
    public void Add(Direccion direccion) {
        
        entityManager.persist(direccion);
    }

    
    
}
