package com.utvt.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utvt.data.models.Usuario;
import com.utvt.data.dao.UsuarioDAO;


@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioDAO UsuarioDAO;

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listUsuarios= UsuarioDAO.findAll();
        return listUsuarios;
    }

    @Override
    public Usuario findById(int id) {
        Usuario Usuario = UsuarioDAO.findById(id);
        return Usuario;
    }

    @Override
    public void save(Usuario Usuario) {
        UsuarioDAO.save(Usuario);

    }

    @Override
    public void deleteById(int id) {
        UsuarioDAO.deleteById(id);
    }

}