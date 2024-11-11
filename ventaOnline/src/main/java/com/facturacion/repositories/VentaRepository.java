package com.facturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{}
