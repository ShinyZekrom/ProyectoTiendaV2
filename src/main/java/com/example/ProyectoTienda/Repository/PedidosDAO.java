package com.example.ProyectoTienda.Repository;

import com.example.ProyectoTienda.model.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PedidosDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void savePedido(Pedidos pedido) {
        //Query INSERT INTO Pedidos VALUES(1,1,'19-09-2024 12:00:00', DEFAULT,'EFECTIVO',500);
        String query = "INSERT INTO Pedidos VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(query, pedido.getId_pedido(), pedido.getId_usuario(), pedido.getFecha_pedido(), pedido.getEstado(), pedido.getMetodo_pago(), pedido.getTotal());
    }

    public void updatePedido(Pedidos pedido) {
        //UPDATE Pedidos SET id_usuario = 1, fecha_pedido = '20-09-2024 12:00:00', estado = 'COMPLETADO' ,metodo_pago = 'TARJETA', total=505;
        String query = "UPDATE Pedidos SET id_usuario = ?, fecha_pedido = ?, estado = ? ,metodo_pago = ?, total= ? WHERE id_pedido= ?";
        jdbcTemplate.update(query, pedido.getId_usuario(), pedido.getFecha_pedido(), pedido.getEstado(), pedido.getMetodo_pago(), pedido.getTotal(), pedido.getId_pedido());

    }

    public void deletePedido(Pedidos pedido) {
        String query = "DELETE Pedidos WHERE id_pedido = ?";
        jdbcTemplate.update(query, pedido.getId_pedido());
    }

    public Pedidos findByIdPedido(Pedidos pedido) {
        return null;
    }

    public List<Pedidos> listar() {
        String query = "SELECT * FROM Pedidos";
        RowMapper<Pedidos> mapper = new RowMapper<Pedidos>() {
            @Override
            public Pedidos mapRow(ResultSet rs, int rowNum) throws SQLException {
                Pedidos pedido = new Pedidos();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedido.setId_usuario(rs.getInt("id_usuario"));
                pedido.setFecha_pedido(rs.getTimestamp("fecha_pedido"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setMetodo_pago(rs.getString("metodo_pago"));
                pedido.setTotal(rs.getInt("total"));
                return pedido;
            }
        };
        //List<Pedidos> pedidoLista = jdbcTemplate.query(query,mapper);
        return jdbcTemplate.query(query, mapper);
    }


}
