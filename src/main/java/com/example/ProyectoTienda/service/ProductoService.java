package com.example.ProyectoTienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoTienda.Repository.ProductoDAO;
import com.example.ProyectoTienda.model.Producto;

@Service
public class ProductoService {
	
	public final ProductoDAO productoDAO;
	
	@Autowired
	public ProductoService(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }// constructor
	
	public void crearProducto(Producto producto) {
		productoDAO.crearProducto(producto);
	}// crearProducto()
	
	public List<Producto> obtenerTodosLosProductos() {
		return productoDAO.leerTodosLosProductos();
	} // obtenerTodosLosProductos()
	
	public Producto obtenerProductoPorId(Long idProducto) {
        return productoDAO.leerProductoPorId(idProducto);
    }// obtenerProductoPorId()
	
	public Producto actualizarProducto(Producto producto) {
		productoDAO.actualizarProducto(producto);
		return producto;
	}// actualizarProducto()
	
    public void eliminarProducto(Long id) {
        productoDAO.eliminarProducto(id);
    }// eliminarProducto()
	
	
	
}
