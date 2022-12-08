package com.utvt.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utvt.data.models.Producto;

import jakarta.persistence.EntityManager;

@Repository
public class ProductoDAOImp implements ProductoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Producto> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Producto> theQuery = currentSession.createQuery("from Producto", Producto.class);

        List<Producto> Productos = theQuery.getResultList();

        return Productos;

    }

    @Override
    public Producto findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Producto Producto = currentSession.get(Producto.class, id);

        return Producto;
    }

    @Override
    public void save(Producto Producto) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(Producto);

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Producto> theQuery = currentSession.createQuery("delete from Producto where id=:idProducto");

        theQuery.setParameter("idProducto", id);
        theQuery.executeUpdate();

    }

}
