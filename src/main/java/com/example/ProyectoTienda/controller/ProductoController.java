package com.example.ProyectoTienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProyectoTienda.model.Producto;
import com.example.ProyectoTienda.service.ProductoService;

@RestController
//@CrossOrigin(origins = "ip:localhost")
@RequestMapping(path="/api/productos/")
public class ProductoController {
	
	private ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	} // constructor
	
	@GetMapping //http://localhost:8080/api/productos/
	public List<Producto> obtenerTodosLosProductos() {
		return productoService.obtenerTodosLosProductos();
	} // obtenerTodosLosProductos()
	
	@GetMapping(path="{productId}") //http://localhost:8080/api/productos/1
    public Producto obtenerProductoPorId(@PathVariable("productId") Long id) {
        return productoService.obtenerProductoPorId(id);
    } // obtenerProductoPorId()
	
	@PostMapping //http://localhost:8080/api/productos/
	public void crearProducto(@RequestBody Producto producto) {
		productoService.crearProducto(producto);
	} // crearProducto()
	
	@PutMapping(path="{productoId}")
	public Producto actualizarProducto(@PathVariable("productId") Long id,
										@RequestParam(required = false) String nombre,
										@RequestParam(required = false) String descripcion,
										@RequestParam(required = false) String categoria,
                                        @RequestParam(required = false) Double precio,
                                        @RequestParam(required = false) Integer stock) {
		return productoService.actualizarProducto(new Producto(id, nombre, descripcion, categoria, precio, stock));
	} // actualizarProducto()
	
	  @DeleteMapping(path="{productoId}")
	    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
	        productoService.eliminarProducto(id);
	        return ResponseEntity.ok().build();
	    } // eliminarProducto()
	
}

