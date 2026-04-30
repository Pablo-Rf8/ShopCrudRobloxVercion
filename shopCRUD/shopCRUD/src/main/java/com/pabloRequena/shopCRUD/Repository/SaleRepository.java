package com.pabloRequena.shopCRUD.Repository;

import com.pabloRequena.shopCRUD.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}