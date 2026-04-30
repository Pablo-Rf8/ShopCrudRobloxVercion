package com.pabloRequena.shopCRUD.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private Long customerDpi;
    private String firstName;
    private String lastName;
    private String address;
    private Integer status;

    // Constructores
    public Customer() {}

    // Getters y Setters
    public Long getCustomerDpi() { return customerDpi; }
    public void setCustomerDpi(Long customerDpi) { this.customerDpi = customerDpi; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}