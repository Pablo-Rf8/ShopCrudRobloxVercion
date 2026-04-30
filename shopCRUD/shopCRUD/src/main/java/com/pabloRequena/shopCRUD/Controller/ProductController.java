package com.pabloRequena.shopCRUD.Controller;

import com.pabloRequena.shopCRUD.Entity.Product;
import com.pabloRequena.shopCRUD.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired private ProductRepository repository;

    @GetMapping
    public List<Product> list() { return repository.findAll(); }

    @PostMapping
    public Product Add(@RequestBody Product product) { return repository.save(product); }
}