package com.prog3.TpPersistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="factura")
public class Factura extends BaseEntidad{
    private Date fecha;
    private int numero;
    private double descuento;
    private enum formaPago{
        mp,
        efectivo
    }
    private int total;
}