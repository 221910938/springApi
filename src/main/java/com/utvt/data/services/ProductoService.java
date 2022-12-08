package com.utvt.data.services;

import java.util.List;

import com.utvt.data.models.Producto;

public interface ProductoService {

    public List<Producto> findAll();

    public Producto findById(int id);

    public void save(Producto Producto);

    public void deleteById(int id);
}