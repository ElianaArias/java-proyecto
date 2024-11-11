package com.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.models.Cliente;
import com.facturacion.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired														// Inyecto repositorio
	private ClienteRepository clienteRepository;
	
																	// Creo mis métodos
	public List<Cliente> getAllClientes() {							// Listar todos los clientes
        return clienteRepository.findAll();
    }

   
    public Cliente findById(Long id) {		 						// Listar cliente por id
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
    }
    
    

    
    @Transactional
    public Cliente createCliente(Cliente cliente) {					// Crear nuevo cliente
        return clienteRepository.save(cliente);
    }
    
    @Transactional
    public Cliente saveCliente(Cliente cliente) {			   		// Guardar venta
    	return clienteRepository.save(cliente);
    }

    
    @Transactional													// Modificar cliente
    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setMail(clienteDetails.getMail());
        cliente.setDni(clienteDetails.getDni());
        
        if(clienteDetails.getDni() != 0) {							// Validacion para confirmar que estoy enviando un dni
        	cliente.setDni(clienteDetails.getDni());
        }
        return clienteRepository.save(cliente);
    }

   
    public void deleteCliente(Long id) {							 // Eliminar cliente por id
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }
}