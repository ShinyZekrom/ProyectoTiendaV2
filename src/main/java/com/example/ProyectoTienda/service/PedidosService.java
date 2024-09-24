package com.example.ProyectoTienda.service;

import com.example.ProyectoTienda.Repository.PedidosDAO;
import com.example.ProyectoTienda.model.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {

    @Autowired
    PedidosDAO pedidosDAO;

    public List<Pedidos> listarPedidos(){
        return pedidosDAO.listar();
    }

    public void savePedido(Pedidos pedido){
         pedidosDAO.savePedido(pedido);
    }

    public void updatePedido(Pedidos pedido){
        pedidosDAO.updatePedido(pedido);
    }

    public void deletePedido(Pedidos pedido){
        pedidosDAO.deletePedido(pedido);
    }

}
