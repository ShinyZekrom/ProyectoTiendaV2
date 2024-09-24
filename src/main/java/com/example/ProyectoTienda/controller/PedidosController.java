package com.example.ProyectoTienda.controller;

import com.example.ProyectoTienda.model.Pedidos;
import com.example.ProyectoTienda.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    PedidosService pedidosService;

    //localhost:8080/pedidos/listarPedidos
    @GetMapping("listarPedidos")
    public List<Pedidos> listar(){
        return pedidosService.listarPedidos();
    }

    //localhost:8080/pedidos/guardar
    @GetMapping("guardar")
    public ResponseEntity<String> guardarPedido(@RequestBody Pedidos pedido){
        pedidosService.savePedido(pedido);
        return new ResponseEntity<String>("SE GUARDO CORRECTAMENTE", HttpStatus.OK);
    }

    @PutMapping("editar")
    public ResponseEntity<String> editarPedido(@RequestBody Pedidos pedido){
        pedidosService.updatePedido(pedido);
        return new ResponseEntity<String>("SE EDITO CORRECTAMENTE",HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<String> eliminarPedido(@RequestBody Pedidos pedido){
        pedidosService.deletePedido(pedido);
        return new ResponseEntity<String>("SE ELIMINO CORRECTAMENTE",HttpStatus.OK);
    }

}
