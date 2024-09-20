package com.example.ProyectoTienda.Repository;

import com.example.ProyectoTienda.model.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class DireccionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY = "INSERT INTO Direcciones (id_usuario, direccion, ciudad, estado, codigo_postal) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Direcciones";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM Direcciones WHERE id_direccion = ?";
    private static final String UPDATE_QUERY = "UPDATE Direcciones SET id_usuario = ?, direccion = ?, ciudad = ?, estado = ?, codigo_postal = ? WHERE id_direccion = ?";
    private static final String DELETE_QUERY = "DELETE FROM Direcciones WHERE id_direccion = ?";

    public List<Direccion> findAll() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new DireccionRowMapper());
    }

    public Direccion findById(Long id) {
        List<Direccion> results = jdbcTemplate.query(SELECT_BY_ID_QUERY, new Object[]{id}, new DireccionRowMapper());
        return results.isEmpty() ? null : results.get(0);
    }

    public Direccion save(Direccion direccion) {
        if (direccion.getId() == null) {
            jdbcTemplate.update(INSERT_QUERY,
                    direccion.getIdUsuario(), direccion.getDireccion(), direccion.getCiudad(),
                    direccion.getEstado(), direccion.getCodigoPostal());
            // Nota: Esto no devolverá el ID generado. Para eso, necesitarías usar KeyHolder
        } else {
            jdbcTemplate.update(UPDATE_QUERY,
                    direccion.getIdUsuario(), direccion.getDireccion(), direccion.getCiudad(),
                    direccion.getEstado(), direccion.getCodigoPostal(), direccion.getId());
        }
        return direccion;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    private static class DireccionRowMapper implements RowMapper<Direccion> {
        @Override
        public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException {
            Direccion direccion = new Direccion();
            direccion.setId(rs.getLong("id_direccion"));
            direccion.setIdUsuario(rs.getLong("id_usuario"));
            direccion.setDireccion(rs.getString("direccion"));
            direccion.setCiudad(rs.getString("ciudad"));
            direccion.setEstado(rs.getString("estado"));
            direccion.setCodigoPostal(rs.getString("codigo_postal"));
            return direccion;
        }
    }
}
