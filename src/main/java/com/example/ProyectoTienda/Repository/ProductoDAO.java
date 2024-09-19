package com.example.ProyectoTienda.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.ProyectoTienda.model.Producto;

@Repository
public class ProductoDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProductoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	// Metodo para crear un producto
	public void crearProducto(Producto producto) {
		String sql = "INSERT INTO Productos (nombre, descripcion, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, producto.getNombre(), producto.getDescripcion(), producto.getCategoria(), producto.getPrecio(), producto.getStock());
    } // insertarProducto()
	
    // Metodo para leer un producto por id
	public Producto leerProductoPorId(Long id) {
        String sql = "SELECT * FROM Productos WHERE id_producto =?";
        return jdbcTemplate.queryForObject(sql, new ProductoRowMapper(), id);
    } // leerProductoPorId()
	
	// Metodo para leer todos los productos
	public List<Producto> leerTodosLosProductos() {
        String sql = "SELECT * FROM Productos";
        return jdbcTemplate.query(sql, new ProductoRowMapper());
    } // leerTodosLosProductos()
	
	// Metodo para actualizar un producto
	public void actualizarProducto(Producto producto) {
		String sql = "UPDATE Productos SET nombre = ?, descripcion = ?, categoria = ?, precio = ?, stock = ? WHERE id_producto = ?";
        jdbcTemplate.update(sql, producto.getNombre(), producto.getDescripcion(), producto.getCategoria(), producto.getPrecio(), producto.getStock(), producto.getIdProducto());
    } //actualizar productos
	
	// Metodo para eliminar un producto
	public void eliminarProducto(Long id) {
        String sql = "DELETE FROM Productos WHERE id_producto =?";
        jdbcTemplate.update(sql, id);
    } // eliminarProducto()
	
	 private static class ProductoRowMapper implements RowMapper<Producto> {
	        @Override
	        public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Producto producto = new Producto();
	            producto.setIdProducto(rs.getLong("id_producto"));
	            producto.setNombre(rs.getString("nombre"));
	            producto.setDescripcion(rs.getString("descripcion"));
	            producto.setCategoria(rs.getString("categoria"));
	            producto.setPrecio(rs.getDouble("precio"));
	            producto.setStock(rs.getInt("stock"));
	            return producto;
	        }
	    }
	 //create a existsById Method for service class
	 
	 public boolean existsById(Long id) {
            return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Productos WHERE id_producto =?", Integer.class, id) > 0;
        }
	}

