package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.entity.Producto;

// ====== Anotaciones =====
@RestController
@RequestMapping("/productos")

// ======
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // ===== METODOS =====

    // 1 ===== GUARDAR =====
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    // 2 ===== LISTAR ======
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    // 3 ===== BUSCAR =====
    @GetMapping("/{idProducto}")
    public Optional<Producto> buscarProductoPorId(@PathVariable Integer idProducto) {
        return productoService.buscarproductoPorId(idProducto);

    }





}
