package com.pabloRequena.shopCRUD.Service;
import com.pabloRequena.shopCRUD.Entity.User;
import com.pabloRequena.shopCRUD.Exception.ResourceNotFoundException;
import com.pabloRequena.shopCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserRepository repository;
    @Override public List<User> listar() { return repository.findAll(); }
    @Override public User agregar(User user) { return repository.save(user); }
    @Override public User buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }
    @Override public void eliminar(Long id) { repository.delete(buscarPorId(id)); }
}