package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

// ====== Anotaciones =====
@RestController
@RequestMapping("/api/productos")

// ======
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // ===== ENDPOINTS =====

    // 1 ===== POST (GUARDAR) =====
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    // 2 ===== GET (LISTAR) ======
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    // 3 ===== GET (BUSCAR POR ID) =====
    @GetMapping("/{idProducto}")
    public Optional<Producto> buscarProductoPorId(@PathVariable Integer idProducto) {
        return productoService.buscarProductoPorId(idProducto);
    }

    // 4 ===== PUT (ACTUALIZAR) =====
    @PutMapping("/{idProducto}")
    public Producto actualizarProducto(@PathVariable Integer idProducto,
                                        @RequestBody Producto producto) {

        return productoService.actualizarProducto(idProducto, producto);
    }

    // 5 ===== DELETE (ELIMINAR)  =====
    @DeleteMapping("/{idProducto}")
    public void eliminarProducto(@PathVariable Integer idProducto) {


       productoService.eliminarProducto(idProducto);

    }

}
