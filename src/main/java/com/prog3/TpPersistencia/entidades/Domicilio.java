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
@Table(name = "domicilio")
public class Domicilio extends BaseEntidad{
    private String calle;
    private String numero;
    private String localidad;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)

    @JoinColumn(name = "Domicilio_id")

    @Builder.Default
    private List<Pedido> pedidos= new ArrayList<>();

    //Metodos
    public void agregarPedido(Pedido ped){
        pedidos.add(ped);
    }

    public void mostrarPedidos() {
        System.out.println("Pedido de " + calle + " " + numero +", "+localidad+ ":/n");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha()+"/nID de pedido: "+ pedido.getId());
        }
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)

    @JoinColumn(name = "Domicilio_id")

    @Builder.Default
    private List<Cliente> clientes= new ArrayList<>();

    //Metodos
    public void agregarCliente(Cliente cli){
        clientes.add(cli);
    }

    public void mostrarClientes() {
        System.out.println("Domicilio " + calle + " " + numero +", "+localidad+ ":/n");
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre());
        }
    }

}
