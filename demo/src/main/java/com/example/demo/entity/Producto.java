package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio",nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;


}
