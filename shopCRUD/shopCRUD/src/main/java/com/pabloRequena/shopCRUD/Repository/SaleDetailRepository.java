package com.pabloRequena.shopCRUD.Repository;

import com.pabloRequena.shopCRUD.Entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
}