package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Colonia;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Municipio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ColoniaDAOImplementation implements IColoniaDAO{

    private final EntityManager entityManager;
    @Autowired 
    public ColoniaDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Colonia> GetAll() {
        TypedQuery<Colonia> query = entityManager.createQuery("FROM Colonia",  Colonia.class);
        List<Colonia> colonias = query.getResultList();

        return colonias;

    }

    @Override
    public List<Colonia> GetByIdMunicipio(int IdMunicipio) {
        TypedQuery<Colonia> query = entityManager.createQuery("FROM Colonia WHERE municipio.idmunicipio = :id", Colonia.class);
        query.setParameter("id", IdMunicipio);

        List<Colonia> colonias = query.getResultList();

        return colonias;
    }
    
}
