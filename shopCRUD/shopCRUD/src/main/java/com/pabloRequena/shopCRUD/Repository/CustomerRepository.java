package com.pabloRequena.shopCRUD.Repository;

import com.pabloRequena.shopCRUD.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Asegurate que diga Long aquí ^
}