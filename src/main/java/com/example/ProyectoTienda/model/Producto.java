package com.example.ProyectoTienda.model;

public class Producto {
	private Long idProducto;
	private String nombre;
	private String descripcion;
	private String categoria;
	private Double precio;
	private Integer stock;
	
	// Constructor
	public Producto(Long idProducto, String nombre, String descripcion, String categoria, Double precio, Integer stock) {
			this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
	} // constructor
	
	// Constructor vacío
	public Producto() {} // constructor vacío
	
	// Getters and Setters
	
	public Long getIdProducto() {
		return idProducto;
	}// getId
	
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}// getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//	setNombre

	public String getDescripcion() {
		return descripcion;
	} // getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} // setDescripcion

	public String getCategoria() {
		return categoria;
	} // getCategoria

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	} // setCategoria

	public Double getPrecio() {
		return precio;
	} // getPrecio

	public void setPrecio(Double precio) {
		this.precio = precio;
	} // setPrecio

	public Integer getStock() {
		return stock;
	} // getStock

	public void setStock(Integer stock) {
		this.stock = stock;
	} // setStock

	// toString
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria
				+ ", precio=" + precio + ", stock=" + stock + "]";
	} // toString
	
}// class Producto
