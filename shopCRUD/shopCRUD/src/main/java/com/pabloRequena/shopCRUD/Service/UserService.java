package com.pabloRequena.shopCRUD.Service;
import com.pabloRequena.shopCRUD.Entity.User;
import java.util.List;

public interface UserService {
    List<User> listar();
    User agregar(User user);
    User buscarPorId(Long id);
    void eliminar(Long id);
}