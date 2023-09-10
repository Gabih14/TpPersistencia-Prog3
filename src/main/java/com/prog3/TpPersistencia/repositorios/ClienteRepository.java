package com.prog3.TpPersistencia.repositorios;

import com.prog3.TpPersistencia.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
}
