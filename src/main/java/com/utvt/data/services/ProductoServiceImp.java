package com.utvt.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utvt.data.models.Producto;
import com.utvt.data.dao.ProductoDAO;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoDAO ProductoDAO;

    @Override
    public List<Producto> findAll() {
        List<Producto> listProductos = ProductoDAO.findAll();
        return listProductos;
    }

    @Override
    public Producto findById(int id) {
        Producto Producto = ProductoDAO.findById(id);
        return Producto;
    }

    @Override
    public void save(Producto Producto) {
        ProductoDAO.save(Producto);

    }

    @Override
    public void deleteById(int id) {
        ProductoDAO.deleteById(id);
    }

}