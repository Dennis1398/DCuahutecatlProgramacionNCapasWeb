package com.digis01.DCuahutecatlProgramacionNCapasWeb.DAO;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Rol;
import com.digis01.DCuahutecatlProgramacionNCapasWeb.DL_JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioDAOImplementation implements IUsuarioDAO{
    
    private EntityManager entityManager;

    @Autowired //Inyección de dependencias.
    public UsuarioDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Usuario> GetAll(Usuario usuario) {
        
        // TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario", Usuario.class);
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE nombre like:nombreusuario AND apellidopaterno like:paterno AND apellidomaterno like:materno", Usuario.class);
        query.setParameter("nombreusuario",('%'+usuario.getNombre()+'%'));
        query.setParameter("paterno", ('%'+usuario.getApellidopaterno()+'%'));
        query.setParameter("materno", ('%'+usuario.getApellidomaterno()+'%'));
        List<Usuario> usuarios = query.getResultList();
        
        return usuarios;
    }
    
    @Override
    @Transactional
    public int Add(Usuario usuario) {
        //usuario.setFechaNacimiento(new Date());
        Rol rol = new Rol();
        rol.setIdRol(1);
        usuario.setRol(rol);
        entityManager.persist(usuario);
        return usuario.getIdusuario();
        /*Usuario usuarioMuestra= usuario;
        usuarioMuestra.getNombre();*/
    }

    @Override
    public Usuario GetById(int idusuarioeditable) {
        //JPQL
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE idusuario=:idusuarioeditable", Usuario.class);
        query.setParameter("idusuarioeditable", idusuarioeditable);
           
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    @Transactional
    public void ChangeStatus(int idUsuario, boolean status) {
        Usuario usuario = entityManager.find(Usuario.class, idUsuario);
        if (status) {
            usuario.setStatus("Y");
        } else {
            usuario.setStatus("N");
        }

        entityManager.merge(usuario);
    }

    @Override
    public void Delete(Usuario usuario) {
         entityManager.remove(usuario);
    }
    
    
  
}
