package com.prog3.TpPersistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
public class Usuario extends BaseEntidad {
    private String nombre;
    private String password;
    private String rol;

    @OneToMany()//cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER

    @JoinColumn(name = "Usuario_id")

    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    //Metodos
    public void agregarPedido(Pedido ped) {
        pedidos.add(ped);
    }

    public void mostrarPedidos() {
        System.out.println("Pedido de " + nombre + ":");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha() + "/nN° de factura: " + pedido.getFactura().getNumero());
        }
    }
}
