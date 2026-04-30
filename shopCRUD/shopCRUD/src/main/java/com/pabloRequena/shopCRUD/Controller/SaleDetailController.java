package com.pabloRequena.shopCRUD.Controller;

import com.pabloRequena.shopCRUD.Entity.SaleDetail;
import com.pabloRequena.shopCRUD.Repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/saledetails")
public class SaleDetailController {
    @Autowired private SaleDetailRepository repository;

    @GetMapping
    public List<SaleDetail> list() { return repository.findAll(); }

    @PostMapping
    public SaleDetail Add(@RequestBody SaleDetail saleDetail) { return repository.save(saleDetail); }
}
