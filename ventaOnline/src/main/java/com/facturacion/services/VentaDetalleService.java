package com.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.models.VentaDetalle;
import com.facturacion.repositories.VentaDetalleRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaDetalleService {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;


    public List<VentaDetalle> getAllVentaDetalles() {						 			   // Listar detalles de ventas
        return ventaDetalleRepository.findAll();
    }


    public VentaDetalle getVentaDetalleById(Long id) {									    // Listar venta por id

        return ventaDetalleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Detalle de venta no encontrado"));
    }


    @Transactional
    public VentaDetalle createVentaDetalle(VentaDetalle ventaDetalle) {						// Crear nuevo detalle de venta
        return ventaDetalleRepository.save(ventaDetalle);
    }
    
    
    @Transactional
    public VentaDetalle saveVentaDetalle(VentaDetalle ventaDetalle) {			    		// Guardar ventaDetalle
    	return ventaDetalleRepository.save(ventaDetalle);
    }


    @Transactional
    public VentaDetalle updateVentaDetalle(Long id, VentaDetalle ventaDetalleDetails) {		// Modificar un detalle de venta
        VentaDetalle ventaDetalle = ventaDetalleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Detalle de venta no encontrado"));
        ventaDetalle.setCantidad(ventaDetalleDetails.getCantidad());
        ventaDetalle.setPrecio(ventaDetalleDetails.getPrecio());
        ventaDetalle.setProducto(ventaDetalleDetails.getProducto());
        return ventaDetalleRepository.save(ventaDetalle);
    }


    public void deleteVentaDetalle(Long id) {												// Eliminar detalle de venta por id
        if (!ventaDetalleRepository.existsById(id)) {
            throw new IllegalArgumentException("Detalle de venta no encontrado");
        }
        ventaDetalleRepository.deleteById(id);
    }
}
