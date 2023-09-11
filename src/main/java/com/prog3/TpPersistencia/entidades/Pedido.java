package com.prog3.TpPersistencia.entidades;

import com.prog3.TpPersistencia.enums.Estado;
import com.prog3.TpPersistencia.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="pedido")
public class Pedido extends BaseEntidad{
    private String fecha;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private LocalTime horaEstimada;
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;
    private double total;

    @OneToOne()//cascade = CascadeType.ALL, orphanRemoval = true
    @JoinColumn(name = "factura_id")
    private Factura factura;


    @OneToMany()//cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER
    @JoinColumn(name = "Pedido_id")
    @Builder.Default
    private List<DetallePedido> dPedidos= new ArrayList<>();

    //Metodos
    public void agregarDetPedido(DetallePedido dp){
        dPedidos.add(dp);
    }

    public void mostrarDetPedidos() {
        System.out.println("Detalle pedido de la factura n°: " + this.getFactura().getNumero() + ":");
        for (DetallePedido detallePedido : dPedidos) {
            System.out.println("Fecha: " + this.fecha+"/nSubtotal: "+ detallePedido.getSubtotal());
        }
    }

}
