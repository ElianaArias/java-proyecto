package com.facturacion.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	
	@Id 												 //id primary key
	@GeneratedValue (strategy = GenerationType.IDENTITY) //autoincremental
	private Long id;
	private String nombre;
	private String apellido;
	
	@Column(unique = true, nullable = false)			//porque dni debe ser unico y no nulo
	private int dni;
	@Column(nullable = false)
	private String mail;
	
	
	@OneToMany( 										//one to many porque un cliente puede hacer varias ventas
			mappedBy = "cliente",						//mappedBy es para recorrer la tabla Venta en base a cliente
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			) 
	
	@JsonIgnore //para que no se me haga un bucle infinito en postman
	private List<Venta> ventas;		//como resultado voy a ver una lista de ventas relacionadas con los clientes

	
	
	//genero constructores
	public Cliente() {
		super();
	}
	
	
	public Cliente(String nombre, String apellido, int dni, String mail) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public List<Venta> getVentas() {
		return ventas;
	}


	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}


	//toString
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + 
				", mail=" + mail + "]";
	}

	
}

