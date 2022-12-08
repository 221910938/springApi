package com.utvt.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utvt.data.models.Usuario;

import jakarta.persistence.EntityManager;

@Repository
public class UsuarioDAOImp implements UsuarioDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Usuario> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("from Usuario", Usuario.class);

        List<Usuario> Usuarios = theQuery.getResultList();

        return Usuarios;

    }

    @Override
    public Usuario findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Usuario Usuario = currentSession.get(Usuario.class, id);

        return Usuario;
    }

    @Override
    public void save(Usuario Usuario) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(Usuario);  

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("Delete from Usuario where id=:idUsuario");

        theQuery.setParameter("idUsuario", id);
        theQuery.executeUpdate();

    }


}
