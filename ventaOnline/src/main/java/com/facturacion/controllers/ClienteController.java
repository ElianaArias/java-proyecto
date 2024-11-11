package com.facturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.models.Cliente;
import com.facturacion.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")//le va a pedir solicitudes a la url api/clientes
public class ClienteController {
	
	@Autowired//hago que el controlador se comunique con el servicio
	private ClienteService clienteService;
	
	//creo los métodos y el controlador me tiene que dar una respuesta de responseEntity
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes(){
		try {
			List<Cliente> cliente = clienteService.getAllClientes();
			return ResponseEntity.ok(clientes);
		}
	}
	

}
