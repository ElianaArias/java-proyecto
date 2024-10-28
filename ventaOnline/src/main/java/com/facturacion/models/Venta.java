package com.facturacion.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Venta {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 	//autoincremental
	private Long id;
	
	@ManyToOne												//many to one porque cada venta está relacionada a un solo cliente
	@JoinColumn(name = "cliente_id", nullable = false)		//cliente_id es primary key en la tabla cliente
	private Cliente cliente;
	
	private LocalDateTime createdAt = LocalDateTime.now(); //fecha de la venta
	private double precioTotal;
	
	@OneToMany(												//one to many porque cada venta puede tener varios detalles de venta dentro, es decir varios productos
			mappedBy = "venta", 
			cascade = CascadeType.ALL						//cascade sirve para que los cambios que haga en venta tambien se reflejen en VentaDetalles
			)
	private List<VentaDetalle> detalles = new ArrayList<>();

	
	
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

	public List<VentaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<VentaDetalle> detalles) {
		this.detalles = detalles;
	}

	
	//toString
	@Override
	public String toString() {
		return "Venta [id=" + id + ", cliente=" + cliente + ", createdAt=" + createdAt + ", precioTotal=" + precioTotal
				+ ", detalles=" + detalles + "]";
	}

	

}
