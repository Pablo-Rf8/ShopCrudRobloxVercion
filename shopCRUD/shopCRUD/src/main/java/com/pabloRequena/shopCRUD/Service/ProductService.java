package com.pabloRequena.shopCRUD.Service;

import com.pabloRequena.shopCRUD.Entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> listar();
    Product agregar(Product product);
    Product buscarPorId(Long id);
    void eliminar(Long id); // <--- Este es el que busca el controlador
}