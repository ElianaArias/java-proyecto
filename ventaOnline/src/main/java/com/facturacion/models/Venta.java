package com.facturacion.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venta")
public class Venta {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 	//autoincremental
	private Long id;
	
	@ManyToOne (fetch = FetchType.EAGER)											//many to one porque cada venta está relacionada a un solo cliente
	@JoinColumn(name = "cliente_id", nullable = false)		//cliente_id es primary key en la tabla cliente
	private Cliente cliente;
	
	private LocalDateTime createdAt = LocalDateTime.now(); //fecha de la venta
	private double precioTotal;
	
	@OneToMany(												//one to many porque cada venta puede tener varios detalles de venta dentro, es decir varios productos
			mappedBy = "venta", 
			cascade = CascadeType.ALL,						//cascade sirve para que los cambios que haga en venta tambien se reflejen en VentaDetalles
			fetch = FetchType.EAGER
			)
	@JsonIgnore//lo ignoro para que no se me haga un bucle infinito
	private List<VentaDetalle> ventaDetalles;

	
	
	//genero constructor	
	public Venta() {
		super();
	}


	public Venta(Cliente cliente, LocalDateTime createdAt, double precioTotal) {
		super();
		this.cliente = cliente;
		this.createdAt = createdAt;
		this.precioTotal = precioTotal;
	}



	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
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
		return "Venta [id=" + id + ", cliente=" + cliente.getId() + ", createdAt=" + createdAt + ", precioTotal=" + precioTotal
				+"]";//elimino ventaDetalle para que no se me haga un bucle infinito
	}

	

}
