package com.pabloRequena.shopCRUD.Controller;

import com.pabloRequena.shopCRUD.Entity.Sale;
import com.pabloRequena.shopCRUD.Entity.User;
import com.pabloRequena.shopCRUD.Repository.SaleRepository;
import com.pabloRequena.shopCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired private SaleRepository repository;

    @GetMapping
    public List<Sale> list() { return repository.findAll(); }

    @PostMapping
    public Sale Add(@RequestBody Sale sale) { return repository.save(sale); }
}