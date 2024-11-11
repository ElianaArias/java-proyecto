package com.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.models.Venta;
import com.facturacion.repositories.VentaRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    
    public List<Venta> getAllVentas() {									    // Listar todas las ventas
        return ventaRepository.findAll();
    }
    

    public Venta getVentaById(Long id) {									// Listar venta por id
        return ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));
    }

    
    @Transactional
    public Venta createVenta(Venta venta) {									// Crear una nueva venta
        return ventaRepository.save(venta);
    }
    
    
    @Transactional
    public Venta saveVenta(Venta venta) {			    					// Guardar venta
    	return ventaRepository.save(venta);
    }

    
    @Transactional
    public Venta updateVenta(Long id, Venta ventaDetails) {					// Modificar venta
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));
        venta.setPrecioTotal(ventaDetails.getPrecioTotal());
        venta.setCliente(ventaDetails.getCliente());
        return ventaRepository.save(venta);
    }

    
    public void deleteVenta(Long id) {									    // Eliminar venta por id
        if (!ventaRepository.existsById(id)) {
            throw new IllegalArgumentException("Venta no encontrada");
        }
        ventaRepository.deleteById(id);
    }
}