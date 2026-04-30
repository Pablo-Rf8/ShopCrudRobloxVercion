package com.pabloRequena.shopCRUD.Service;

import com.pabloRequena.shopCRUD.Entity.Customer;
import com.pabloRequena.shopCRUD.Exception.ResourceNotFoundException;
import com.pabloRequena.shopCRUD.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> listar() {
        return repository.findAll();
    }

    @Override
    public Customer agregar(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con DPI: " + id));
    }

    @Override
    public void eliminar(Long id) {
        Customer customer = buscarPorId(id);
        repository.delete(customer);
    }
}