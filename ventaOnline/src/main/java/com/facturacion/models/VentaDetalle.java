package com.facturacion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "VentaDetalle")
public class VentaDetalle {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)					//esto es porque cada registro dentro de venta detalle corresponde a una sola venta, aunque 
	@JoinColumn(
			name = "venta_id", 
			nullable = false)							//venta_id es primary key de Venta
	private Venta venta;
	
	@ManyToOne(fetch = FetchType.EAGER)					//esto es porque cada detalle de venta corresponde a un solo producto, a pesar de que un producto puede estar en muchos detalles de venta
	@JoinColumn(
			name = "producto_id",						//producto_id es primary key de la tabla Producto
			nullable = false
	)
	private Producto producto;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(nullable = false)
	private double precio;
	
	
	
	//genero constructores
	public VentaDetalle() {
		super();
	}
	
	
	public VentaDetalle(Venta venta, Producto producto, int cantidad, double precio) {
		super();
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}



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
		return "VentaDetalle [id=" + id + ", venta=" + venta.getId() + ", producto=" + producto.getId() + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}

}