package com.example.ProyectoTienda;

import com.example.ProyectoTienda.Repository.DireccionDAO;
import com.example.ProyectoTienda.model.Direccion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ProyectoTiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoTiendaApplication.class, args);
	}

}
