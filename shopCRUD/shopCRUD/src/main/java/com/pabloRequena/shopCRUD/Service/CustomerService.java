package com.pabloRequena.shopCRUD.Service;

import com.pabloRequena.shopCRUD.Entity.Customer;
import java.util.List;

public interface CustomerService {
    // Aquí está el método que Spring Boot no encontraba
    List<Customer> listar();

    Customer agregar(Customer customer);
    Customer buscarPorId(Long id);
    void eliminar(Long id);
}