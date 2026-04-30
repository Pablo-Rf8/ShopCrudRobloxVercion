package com.pabloRequena.shopCRUD.Controller;

import com.pabloRequena.shopCRUD.Entity.Customer;
import com.pabloRequena.shopCRUD.Entity.Product;
import com.pabloRequena.shopCRUD.Entity.Sale;
import com.pabloRequena.shopCRUD.Entity.User;
import com.pabloRequena.shopCRUD.Service.CustomerService;
import com.pabloRequena.shopCRUD.Service.ProductService;
import com.pabloRequena.shopCRUD.Service.SaleService;
import com.pabloRequena.shopCRUD.Service.UserService;
import com.pabloRequena.shopCRUD.Entity.SaleDetail;
import com.pabloRequena.shopCRUD.Service.SaleDetailService;
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

    // ── INDEX (pasa productos para el home) ──
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.listar());
        return "index";
    }

    // ══════════════════════════════════════════
    // CUSTOMERS
    // ══════════════════════════════════════════
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
    public String showEditCustomerForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.buscarPorId(id));
        return "customer-edit";
    }

    @PostMapping("/view/customers/edit/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer customer) {
        customer.setCustomerDpi(id);
        customerService.agregar(customer);
        return "redirect:/view/customers";
    }

    @GetMapping("/view/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.eliminar(id);
        return "redirect:/view/customers";
    }

    // ══════════════════════════════════════════
    // PRODUCTS
    // ══════════════════════════════════════════
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
    public String showEditProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.buscarPorId(id));
        return "product-edit";
    }

    @PostMapping("/view/products/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setProductId(id); // Corregido: Ya no necesita Math.toIntExact
        productService.agregar(product);
        return "redirect:/view/products";
    }

    @GetMapping("/view/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.eliminar(id);
        return "redirect:/view/products";
    }

    // ══════════════════════════════════════════
    // USERS
    // ══════════════════════════════════════════
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

    @GetMapping("/view/users/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.buscarPorId(id));
        return "user-edit";
    }

    @PostMapping("/view/users/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setUserId(id);
        userService.agregar(user);
        return "redirect:/view/users";
    }

    @GetMapping("/view/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.eliminar(id);
        return "redirect:/view/users";
    }


    @GetMapping("/view/sales")
    public String sales(Model model) {
        model.addAttribute("sales", saleService.listar());
        model.addAttribute("sale", new Sale());
        model.addAttribute("customers", customerService.listar());
        model.addAttribute("products", productService.listar());
        return "sales";
    }

    @PostMapping("/view/sales/add")
    public String addSale(@ModelAttribute Sale sale) {
        saleService.agregar(sale);
        return "redirect:/view/sales";
    }

    @GetMapping("/view/sales/edit/{id}")
    public String showEditSaleForm(@PathVariable Long id, Model model) {
        model.addAttribute("sale", saleService.buscarPorId(id));
        model.addAttribute("customers", customerService.listar());
        model.addAttribute("products", productService.listar());
        return "sale-edit";
    }

    @PostMapping("/view/sales/edit/{id}")
    public String updateSale(@PathVariable Long id, @ModelAttribute Sale sale) {
        Sale ventaExistente = saleService.buscarPorId(id);
        sale.setSaleId(id);
        sale.setSaleDate(ventaExistente.getSaleDate());
        saleService.agregar(sale);
        return "redirect:/view/sales";
    }

    @GetMapping("/view/sales/delete/{id}")
    public String deleteSale(@PathVariable Long id) {
        saleService.eliminar(id);
        return "redirect:/view/sales";
    }
    // Añade esta inyección junto a las otras al principio de la clase:
    @Autowired private SaleDetailService saleDetailService;

    // ================== SALE DETAILS (DETALLES DE VENTA) ==================

    @GetMapping("/view/saledetails")
    public String saleDetails(Model model) {
        model.addAttribute("saleDetails", saleDetailService.listar());
        model.addAttribute("saleDetail", new SaleDetail());
        // Pasamos ventas y productos para los select del formulario
        model.addAttribute("sales", saleService.listar());
        model.addAttribute("products", productService.listar());
        return "saledetails";
    }

    @PostMapping("/view/saledetails/add")
    public String addSaleDetail(@ModelAttribute SaleDetail saleDetail) {
        saleDetailService.guardar(saleDetail);
        return "redirect:/view/saledetails";
    }

    @GetMapping("/view/saledetails/edit/{id}")
    public String showEditSaleDetailForm(@PathVariable Long id, Model model) {
        model.addAttribute("saleDetail", saleDetailService.buscarPorId(id));
        model.addAttribute("sales", saleService.listar());
        model.addAttribute("products", productService.listar());
        return "saledetail-edit";
    }

    @PostMapping("/view/saledetails/edit/{id}")
    public String updateSaleDetail(@PathVariable Long id, @ModelAttribute SaleDetail saleDetail) {
        saleDetail.setDetailId(id);
        saleDetailService.guardar(saleDetail);
        return "redirect:/view/saledetails";
    }

    @GetMapping("/view/saledetails/delete/{id}")
    public String deleteSaleDetail(@PathVariable Long id) {
        saleDetailService.eliminar(id);
        return "redirect:/view/saledetails";
    }
}