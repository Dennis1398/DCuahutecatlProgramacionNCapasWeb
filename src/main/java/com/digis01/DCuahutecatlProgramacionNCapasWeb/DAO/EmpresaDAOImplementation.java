package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;

import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Empresa;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpresaDAOImplementation implements IEmpresaDAO {

    private EntityManager entityManager;

    @Autowired //Inyección de dependencias. 
    public EmpresaDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Empresa> GetAll() {
        TypedQuery<Empresa> query = entityManager.createQuery("FROM Empresa", Empresa.class);
        List<Empresa> empresas = query.getResultList();

        return empresas;
    }

    @Override
    @Transactional
    public int Add(Empresa empresa) {
        entityManager.merge(empresa);
        return empresa.getIdempresa();

    }



    @Override
    public Empresa GetById(int idempresa) {
        TypedQuery<Empresa> query = entityManager.createQuery("FROM Empresa WHERE idempresa=:idempresa", Empresa.class);
        query.setParameter("idempresa", idempresa);
           
        return query.getSingleResult();

    }

    @Override
    @Transactional
    public void Update(Empresa empresa) {
        entityManager.merge(empresa);
    }

    @Override
    public void Delete(Empresa empresa) {
        entityManager.remove(empresa);
    }
}
