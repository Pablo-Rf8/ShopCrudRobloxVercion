package com.pabloRequena.shopCRUD.Controller;

import com.pabloRequena.shopCRUD.Entity.User;
import com.pabloRequena.shopCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired private UserRepository repository;

    @GetMapping
    public List<User> list() { return repository.findAll(); }

    @PostMapping
    public User Add(@RequestBody User user) { return repository.save(user); }
}