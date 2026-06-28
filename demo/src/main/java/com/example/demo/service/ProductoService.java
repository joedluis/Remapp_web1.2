package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto guardarPoducto(Producto producto) {
        return productoRepository.save(producto);
    }

}
