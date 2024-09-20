package com.example.ProyectoTienda.controller;

import com.example.ProyectoTienda.model.Direccion;
import com.example.ProyectoTienda.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public List<Direccion> executeGetAllAddress() {
        return direccionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> executeGetAddressById(@PathVariable Long id) {
        Direccion direccion = direccionService.findById(id);
        if (direccion != null) {
            return ResponseEntity.ok(direccion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Direccion executeCreateAddress(@RequestBody Direccion direccion) {
        return direccionService.save(direccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> executeUpdateAddress(@PathVariable Long id, @RequestBody Direccion direccionDetails) {
        Direccion direccion = direccionService.findById(id);
        if (direccion != null) {
            direccion.setIdUsuario(direccionDetails.getIdUsuario());
            direccion.setDireccion(direccionDetails.getDireccion());
            direccion.setCiudad(direccionDetails.getCiudad());
            direccion.setEstado(direccionDetails.getEstado());
            direccion.setCodigoPostal(direccionDetails.getCodigoPostal());
            return ResponseEntity.ok(direccionService.save(direccion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> executeDeleteAddress(@PathVariable Long id) {
        Direccion direccion = direccionService.findById(id);
        if (direccion != null) {
            direccionService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
