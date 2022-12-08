package com.utvt.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utvt.data.models.Usuario;
import com.utvt.data.services.UsuarioService;


//Indiciamos que es un controlador rest
@RestController
@Transactional
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/

public class UsuarioRestController {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private UsuarioService UsuarioService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
    http://127.0.0.1:8080/api/Usuarios*/
    @GetMapping("/usuarios")
    public List<Usuario> findAll(){
        //retornará todos los Usuarios
        return UsuarioService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un Usuario
    http://127.0.0.1:8080/api/Usuarios/1*/
    @GetMapping("/usuarios/{UsuarioId}")
    public Usuario getUsuario(@PathVariable int UsuarioId){
        Usuario Usuario = UsuarioService.findById(UsuarioId);

        if(Usuario == null) {
            throw new RuntimeException("Usuario id not found -"+UsuarioId);
        }
        //retornará al Usuario con id pasado en la url
        return Usuario;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/Usuarios/  */
    @PostMapping("/usuarios")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
    	
    	
        usuario.setId(0);
       

        //Este metodo guardará al Usuario enviado
        UsuarioService.save(usuario);

        return usuario;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/Usuarios/  */
    @PutMapping("/usuarios")
    public Usuario updateUsuario(@RequestBody Usuario Usuario) {

        UsuarioService.save(Usuario);

        //este metodo actualizará al Usuario enviado

        return Usuario;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del Usuario
    http://127.0.0.1:8080/api/Usuarios/1  */
    @DeleteMapping("usuarios/{UsuarioId}")
    public String deteteUsuario(@PathVariable int UsuarioId) {

        Usuario Usuario = UsuarioService.findById(UsuarioId);

        if(Usuario == null) {
            throw new RuntimeException("Usuario id not found -"+UsuarioId);
        }

        UsuarioService.deleteById(UsuarioId);

        //Esto método, recibira el id de un Usuario por URL y se borrará de la bd.
        return "0";
    }

}
