package com.facturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.models.VentaDetalle;
import com.facturacion.services.VentaDetalleService;

@RestController
@RequestMapping("/api/ventaDetalles")
public class VentaDetalleController {

    @Autowired
    private VentaDetalleService ventaDetalleService;

    @GetMapping
    public ResponseEntity<List<VentaDetalle>> getAllVentaDetalles() {
        try {
            List<VentaDetalle> detalles = ventaDetalleService.getAllVentaDetalles();
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDetalle> getVentaDetalleById(@PathVariable Long id) {
        try {
            VentaDetalle detalle = ventaDetalleService.getVentaDetalleById(id);
            return ResponseEntity.ok(detalle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<VentaDetalle> createVentaDetalle(@RequestBody VentaDetalle ventaDetalle) {
        try {
            VentaDetalle createdVentaDetalle = ventaDetalleService.createVentaDetalle(ventaDetalle);
            return ResponseEntity.ok(createdVentaDetalle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDetalle> updateVentaDetalle(@PathVariable Long id, @RequestBody VentaDetalle ventaDetalleDetails) {
        try {
            VentaDetalle updatedVentaDetalle = ventaDetalleService.updateVentaDetalle(id, ventaDetalleDetails);
            return ResponseEntity.ok(updatedVentaDetalle);
        } catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVentaDetalle(@PathVariable Long id) {
        try {
            ventaDetalleService.deleteVentaDetalle(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
