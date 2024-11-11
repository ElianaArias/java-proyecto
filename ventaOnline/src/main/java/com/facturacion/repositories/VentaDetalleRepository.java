package com.facturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.models.VentaDetalle;

public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Long>{}