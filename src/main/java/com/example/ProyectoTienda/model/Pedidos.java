package com.example.ProyectoTienda.model;

import java.sql.Timestamp;

public class Pedidos {
    /*CREATE TABLE Pedidos (
    id_pedido NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    id_usuario NUMBER NOT NULL,
    fecha_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR2(50) DEFAULT 'pendiente',
    metodo_pago VARCHAR2(50),
    total NUMBER(10, 2) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);
    * */

    //Atributos del objeto
    private int id_pedido;
    private int id_usuario;
    private Timestamp fecha_pedido;
    private String estado;
    private String metodo_pago;
    private int total;

    

    //Constructor vacio
    public Pedidos(){}

    //Constructor con parametros
    public Pedidos(int id_pedido, int id_usuario, Timestamp fecha_pedido, String estado, String metodo_pago, int total) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.fecha_pedido = fecha_pedido;
        this.estado = estado;
        this.metodo_pago = metodo_pago;
        this.total = total;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Producto{" +
                "id_pedido=" + id_pedido +
                ", id_usuario=" + id_usuario +
                ", fecha_pedido=" + fecha_pedido +
                ", estado='" + estado + '\'' +
                ", metodo_pago='" + metodo_pago + '\'' +
                ", total=" + total +
                '}';
    }

    //Getters

    public int getId_pedido() {
        return id_pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public Timestamp getFecha_pedido() {
        return fecha_pedido;
    }

    public String getEstado() {
        return estado;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public int getTotal() {
        return total;
    }

    //Setters

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setFecha_pedido(Timestamp fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
