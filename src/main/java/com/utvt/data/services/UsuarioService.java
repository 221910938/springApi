package com.utvt.data.services;

import java.util.List;

import com.utvt.data.models.Usuario;


public interface UsuarioService {

    public List<Usuario> findAll();

    public Usuario findById(int id);

    public void save(Usuario Usuario);

    public void deleteById(int id);
}