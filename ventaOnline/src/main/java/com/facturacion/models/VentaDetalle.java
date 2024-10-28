package com.facturacion.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VentaDetalle {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne											//esto es porque cada registro dentro de venta detalle corresponde a una sola venta, aunque 
	@JoinColumn(
			name = "venta_id", 
			nullable = false)							//venta_id es primary key de Venta
	private Venta venta;
	
	@ManyToOne											//esto es porque cada detalle de venta corresponde a un solo producto, a pesar de que un producto puede estar en muchos detalles de venta
	@JoinColumn(
			name = "producto_id",						//producto_id es primary key de la tabla Producto
			nullable = false
	)
	
	private Producto producto; 						
	private int cantidad;
	private double precio;
	
	
	
	//getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "VentaDetalle [id=" + id + ", venta=" + venta + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}
	
	
	
}

