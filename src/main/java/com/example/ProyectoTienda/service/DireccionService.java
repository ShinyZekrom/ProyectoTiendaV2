package com.example.ProyectoTienda.service;

import com.example.ProyectoTienda.model.Direccion;
import com.example.ProyectoTienda.Repository.DireccionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {

    @Autowired
    private DireccionDAO direccionDAO;

    public List<Direccion> findAll() {
        return direccionDAO.findAll();
    }

    public Direccion findById(Long id) {
        return direccionDAO.findById(id);
    }

    public Direccion save(Direccion direccion) {
        return direccionDAO.save(direccion);
    }

    public void deleteById(Long id) {
        direccionDAO.deleteById(id);
    }
}
