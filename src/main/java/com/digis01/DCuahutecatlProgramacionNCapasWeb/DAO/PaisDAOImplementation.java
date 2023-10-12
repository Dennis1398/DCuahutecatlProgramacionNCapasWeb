package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository 
public class PaisDAOImplementation implements IPaisDAO {
    private EntityManager entityManager;
    
    @Autowired 
    public PaisDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Pais> GetAll() {
        TypedQuery<Pais> query = entityManager.createQuery("FROM Pais", Pais.class);
        List<Pais> paises = query.getResultList();
        return paises;
    }
    
    
  
}
