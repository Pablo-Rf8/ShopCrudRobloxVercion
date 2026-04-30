package com.pabloRequena.shopCRUD.Repository;

import com.pabloRequena.shopCRUD.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}