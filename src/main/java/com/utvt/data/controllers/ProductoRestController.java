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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.utvt.data.models.Producto;
import com.utvt.data.services.ProductoService;

//Indiciamos que es un controlador rest
@RestController
@Transactional
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/api") // esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/

public class ProductoRestController {

    // Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private ProductoService ProductoService;

    /*
     * Este método se hará cuando por una petición GET (como indica la anotación) se
     * llame a la url
     * http://127.0.0.1:8080/api/Productos
     */
    @GetMapping("/productos")
    public List<Producto> findAll() {
        // retornará todos los Productos
        return ProductoService.findAll();
    }

    /*
     * Este método se hará cuando por una petición GET (como indica la anotación) se
     * llame a la url + el id de un Producto
     * http://127.0.0.1:8080/api/Productos/1
     */
    @GetMapping("/productos/{ProductoId}")
    public Producto getProducto(@PathVariable int ProductoId) {
        Producto Producto = ProductoService.findById(ProductoId);

        if (Producto == null) {
            throw new RuntimeException("Producto id not found -" + ProductoId);
        }
        // retornará al Producto con id pasado en la url
        return Producto;
    }

    /*
     * Este método se hará cuando por una petición POST (como indica la anotación)
     * se llame a la url
     * http://127.0.0.1:8080/api/Productos/
     */
    @PostMapping("/productos")
    public Producto addProducto(@RequestBody Producto producto) {
    	
        producto.setId(0);
        
        // Este metodo guardará al Producto enviado
        ProductoService.save(producto);

        return producto;

    }

    /*
     * Este método se hará cuando por una petición PUT (como indica la anotación) se
     * llame a la url
     * http://127.0.0.1:8080/api/Productos/
     */
    @PutMapping("/productos")
    public Producto updateProducto(@RequestBody Producto Producto) {

        ProductoService.save(Producto);

        // este metodo actualizará al Producto enviado

        return Producto;
    }

    /*
     * Este método se hará cuando por una petición DELETE (como indica la anotación)
     * se llame a la url + id del Producto
     * http://127.0.0.1:8080/api/Productos/1
     */
    @DeleteMapping("productos/{ProductoId}")
    public String deteteProducto(@PathVariable int ProductoId) {

        Producto Producto = ProductoService.findById(ProductoId);

        if (Producto == null) {
            throw new RuntimeException("Producto id not found -" + ProductoId);
        }

        ProductoService.deleteById(ProductoId);

        // Esto método, recibira el id de un Producto por URL y se borrará de la bd.
        return "0";
    }

}
