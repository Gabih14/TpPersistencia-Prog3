package com.prog3.TpPersistencia.entidades;

import com.prog3.TpPersistencia.enums.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="factura")
public class Factura extends BaseEntidad{
    private LocalDate fecha;
    private int numero;
    private double descuento;
    private FormaPago formaPago;
    private int total;
}