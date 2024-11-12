package com.facturacion.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //autoincremental
	private Long id;
	@Column(nullable = false) 							//esto es para que el nombre no sea nulo. si no cargo algo, no se crea la tabla
	private String nombre;
	private String marca;
	private int stock;
	private double precio;
	
	
	@OneToMany( 												//oneToMany porque un producto puede corresponder a más de 1 VentaDetalle, con cantidad y precio particular de esa venta
			mappedBy = "producto",								//recorro la tabla VentaDetalle, en base al producto
			fetch = FetchType.EAGER
			)
	
	@JsonIgnore //para que no se me haga un bucle infinito en postman
	private List<VentaDetalle> ventaDetalles = new ArrayList<>(); //me va a devolver una lista con los detalles de cada producto

	
	//genero constructores
	public Producto() {
		super();
	}
	
	
	public Producto(String nombre, String marca, int stock, double precio) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.stock = stock;
		this.precio = precio;
	}



	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<VentaDetalle> getVentaDetalles() {
		return ventaDetalles;
	}

	public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}

	
	
	//toString
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", stock=" + stock
				+ ", precio=" + precio + "]"; //no dejo detallesVenta para que no se haga un bucle infinito
	}
	
}