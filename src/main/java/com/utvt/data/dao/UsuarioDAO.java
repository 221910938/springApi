package com.utvt.data.dao;

import java.util.List;

import com.utvt.data.models.Usuario;

public interface UsuarioDAO {

	    public List<Usuario> findAll();

	    public Usuario findById(int id);

	    public void save(Usuario user);

	    public void deleteById(int id);
}