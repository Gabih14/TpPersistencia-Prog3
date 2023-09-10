package com.prog3.TpPersistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "configuracionGeneral")
public class ConfiguracionGeneral extends BaseEntidad{
    private int cantidadCocineros;
    private String emailEmpresa;
    private String tokenMercadoPago;
}
