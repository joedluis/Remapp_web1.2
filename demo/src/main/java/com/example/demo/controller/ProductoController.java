package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
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

    // ===== GUARDAR =====
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    // ===== LISTAR ======
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }


}
