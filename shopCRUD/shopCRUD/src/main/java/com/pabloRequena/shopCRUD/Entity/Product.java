package com.pabloRequena.shopCRUD.Entity;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer productId;
    private String productName;
    private BigDecimal price;
    private Integer stock;
    private Integer status;
}
