package com.facturacion.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //autoincremental
	private Long id;
	@Column(nullable = false) 							//esto es para que el nombre no sea nulo. si no cargo algo, no se crea la tabla
	private String descripcion;
	private String codigo;
	private int stock;
	private double precio;
	
	
	@OneToMany( 												//oneToMany porque un producto puede corresponder a más de 1 VentaDetalle, con cantidad y precio particular de esa venta
			mappedBy = "producto",								//recorro la tabla VentaDetalle, en base al producto
			fetch = FetchType.EAGER
			)
	
	private List<VentaDetalle> detallesVenta = new ArrayList<>(); //me va a devolver una lista con los detalles de cada producto

	
	
	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public List<VentaDetalle> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<VentaDetalle> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}

	
	
	//toString
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", codigo=" + codigo + ", stock=" + stock
				+ ", precio=" + precio + ", detallesVenta=" + detallesVenta + "]";
	}

		
	
}
