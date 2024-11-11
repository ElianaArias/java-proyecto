package com.facturacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.models.Producto;
import com.facturacion.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    
    public List<Producto> getAllProductos() {			    				// Listar todos los productos
        return productoRepository.findAll();
    }
    

    public Producto getProductoById(Long id) {								// Listar producto por id
        return productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }


    @Transactional
    public Producto createProducto(Producto producto) {						// Crear producto
        return productoRepository.save(producto);
    }
    
    @Transactional
    public Producto saveProducto(Producto producto) {			    		// Guardar producto
    	return productoRepository.save(producto);
    }

    
    @Transactional
    public Producto updateProducto(Long id, Producto productoDetails) {	    // Modificar producto

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        producto.setNombre(productoDetails.getNombre());
        producto.setMarca(productoDetails.getMarca());
        producto.setStock(productoDetails.getStock());
        producto.setPrecio(productoDetails.getPrecio());
        return productoRepository.save(producto);
    }

    
    public void deleteProducto(Long id) {									    // Eliminar producto por id
        if (!productoRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }
}