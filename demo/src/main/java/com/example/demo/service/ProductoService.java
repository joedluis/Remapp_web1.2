package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarproductoPorId(Integer idProducto) {
        return productoRepository.findById(idProducto);
    }

    public Producto actualizarProducto(Integer idProducto, Producto producto) {

        Optional<Producto> productoExistente = productoRepository.findById(idProducto);

        if (productoExistente.isPresent()) {

            Producto productoActual = productoExistente.get();

            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());
            productoActual.setStock(producto.getStock());

            return productoRepository.save(productoActual);

        }

        throw new RuntimeException("Producto no encontrado");
    }

    public void eliminarProducto(Integer idProducto) {

        Optional<Producto> productoExistente = productoRepository.findById(idProducto);

        if (productoExistente.isPresent()) {

            productoRepository.deleteById(idProducto);

        } else {

            throw new RuntimeException("Producto no encontrado");

        }
    }

}
