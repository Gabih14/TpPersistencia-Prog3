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
@Table(name = "rubro")
public class Rubro extends BaseEntidad{
    private String denominacion;

    @OneToMany()//cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER
    @JoinColumn(name = "Rubro_id")
    @Builder.Default
    private List<Producto> productos= new ArrayList<>();

    //Metodos
    public void agregarProducto(Producto pro){
        productos.add(pro);
    }
}
