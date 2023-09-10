package com.prog3.TpPersistencia.repositorios;

import com.prog3.TpPersistencia.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
