package com.utvt.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String precio) {
		Precio = precio;
	}

	public String getDescuento() {
		return Descuento;
	}

	public void setDescuento(String descuento) {
		Descuento = descuento;
	}

	@Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Descripcion")
    private String Descripcion;

    @Column(name = "Cantidad")
    private String Cantidad;

    @Column(name = "Precio")
    private String Precio;

    @Column(name = "Descuento")
    private String Descuento;

    void Producto() {
    }

    void Producto(int id, String Nombre, String Descripcion, String Cantidad, String Precio, String Descuento) {
        this.id = id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Descuento = Descuento;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id +
                ", Nombre=" +
                Nombre +
                ", Descripcion=" +
                Descripcion +
                ", Cantidad=" +
                Cantidad +
                ", Precio=" +
                Precio +
                ", Descuento=" +
                Descuento + "]";
    }

}