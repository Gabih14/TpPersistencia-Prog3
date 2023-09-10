package com.prog3.TpPersistencia;

import com.prog3.TpPersistencia.entidades.ConfiguracionGeneral;
import com.prog3.TpPersistencia.entidades.DetallePedido;
import com.prog3.TpPersistencia.entidades.Producto;
import com.prog3.TpPersistencia.entidades.Rubro;
import com.prog3.TpPersistencia.enums.Tipo;
import com.prog3.TpPersistencia.repositorios.ConfiguracionGeneralRepository;
import com.prog3.TpPersistencia.repositorios.DetallePedidoRepository;
import com.prog3.TpPersistencia.repositorios.ProductoRepository;
import com.prog3.TpPersistencia.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class TpPersistenciaApplication {

	@Autowired
	ConfiguracionGeneralRepository configuracionGeneralRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpPersistenciaApplication.class, args);
		System.out.println("hola");
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			//builders

			//Configuración general
			ConfiguracionGeneral configuracionGeneral=ConfiguracionGeneral.builder()
					.emailEmpresa("email@email.com")
					.cantidadCocineros(15)
					.tokenMercadoPago("mp.mp")
					.build();
			configuracionGeneralRepository.save(configuracionGeneral);


			//Producto
			Producto producto =Producto.builder()
					.tipo(Tipo.insumo)
					.tiempoEstimadoCocina(40)
					.denominacion("den")
					.precioVenta(1000)
					.precioCompra(500)
					.stockActual(550)
					.stockMinimo(400)
					.unidadMedida("unidad de Medida")
					.foto("foto.jpg")
					.receta("Pan-carne-queso")
					.build();

			productoRepository.save(producto);

			//Rubro
			Rubro rubro = Rubro.builder()
					.denominacion("denominacion")
					.build();


			//Agregar producto al rubro
			rubro.agregarProducto(producto);
			rubroRepository.save(rubro);

			//Detalle pedido
			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(14)
					.subtotal(16000)
					.build();

			//Agregar producto a detalle pedido
			detallePedido.setProducto(producto);

			detallePedidoRepository.save(detallePedido);

		};
	}
}
