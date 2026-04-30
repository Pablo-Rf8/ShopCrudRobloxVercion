package com.pabloRequena.shopCRUD.Controller;

import com.pabloRequena.shopCRUD.Entity.Customer;
import com.pabloRequena.shopCRUD.Entity.Product;
import com.pabloRequena.shopCRUD.Entity.Sale;
import com.pabloRequena.shopCRUD.Entity.User;
import com.pabloRequena.shopCRUD.Service.CustomerService;
import com.pabloRequena.shopCRUD.Service.ProductService;
import com.pabloRequena.shopCRUD.Service.SaleService;
import com.pabloRequena.shopCRUD.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired private CustomerService customerService;
    @Autowired private ProductService productService;
    @Autowired private UserService userService;
    @Autowired private SaleService saleService;

    // ==========================================
    // PANTALLA PRINCIPAL
    // ==========================================
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // ==========================================
    // CRUD DE CLIENTES (CUSTOMERS)
    // ==========================================
    @GetMapping("/view/customers")
    public String customers(Model model) {
        model.addAttribute("customers", customerService.listar());
        model.addAttribute("customer", new Customer());
        return "customers";
    }

    @PostMapping("/view/customers/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.agregar(customer);
        return "redirect:/view/customers";
    }

    @GetMapping("/view/customers/edit/{id}")
    public String showEditCustomerForm(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.buscarPorId(id);
        model.addAttribute("customer", customer);
        return "customer-edit";
    }

    @GetMapping("/view/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.eliminar(id);
        return "redirect:/view/customers";
    }

    // ==========================================
    // CRUD DE PRODUCTOS (PRODUCTS)
    // ==========================================
    @GetMapping("/view/products")
    public String products(Model model) {
        model.addAttribute("products", productService.listar());
        model.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping("/view/products/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.agregar(product);
        return "redirect:/view/products";
    }

    @GetMapping("/view/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.buscarPorId(id);
        model.addAttribute("product", product);
        return "product-edit";
    }

    @GetMapping("/view/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.eliminar(id);
        return "redirect:/view/products";
    }

    // ==========================================
    // CRUD DE USUARIOS (USERS)
    // ==========================================
    @GetMapping("/view/users")
    public String users(Model model) {
        model.addAttribute("users", userService.listar());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/view/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.agregar(user);
        return "redirect:/view/users";
    }

    @GetMapping("/view/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.eliminar(id);
        return "redirect:/view/users";
    }

    // ==========================================
    // CRUD DE VENTAS (SALES)
    // ==========================================
    @GetMapping("/view/sales")
    public String sales(Model model) {
        model.addAttribute("sales", saleService.listar());
        model.addAttribute("sale", new Sale());
        return "sales";
    }

    @PostMapping("/view/sales/add")
    public String addSale(@ModelAttribute Sale sale) {
        saleService.agregar(sale);
        return "redirect:/view/sales";
    }

    @GetMapping("/view/sales/delete/{id}")
    public String deleteSale(@PathVariable("id") Long id) {
        saleService.eliminar(id);
        return "redirect:/view/sales";
    }
}