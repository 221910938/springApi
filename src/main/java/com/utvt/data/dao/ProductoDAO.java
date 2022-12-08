package com.utvt.data.dao;

import java.util.List;

import com.utvt.data.models.Producto;

public interface ProductoDAO {

	public List<Producto> findAll();

	public Producto findById(int id);

	public void save(Producto user);

	public void deleteById(int id);
}