package com.facturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.models.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{} //con esto tengo acceso a todos los métodos de jpa

