package com.pabloRequena.shopCRUD.Service;

import com.pabloRequena.shopCRUD.Entity.Product;
import com.pabloRequena.shopCRUD.Exception.ResourceNotFoundException;
import com.pabloRequena.shopCRUD.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> listar() {
        return repository.findAll();
    }

    @Override
    public Product agregar(Product product) {
        return repository.save(product);
    }

    @Override
    public Product buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        Product product = buscarPorId(id);
        repository.delete(product);
    }
}