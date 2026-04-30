package com.pabloRequena.shopCRUD.Controller;

import com.pabloRequena.shopCRUD.Entity.Customer;
import com.pabloRequena.shopCRUD.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired private CustomerRepository repository;

    @GetMapping
    public List<Customer> list() { return repository.findAll(); }

    @PostMapping
    public Customer add(@RequestBody Customer customer) { return repository.save(customer); }
}