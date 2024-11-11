package com.facturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{}


