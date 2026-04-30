package com.pabloRequena.shopCRUD.Service;
import com.pabloRequena.shopCRUD.Entity.Sale;
import java.util.List;

public interface SaleService {
    List<Sale> listar();
    Sale agregar(Sale sale);
    Sale buscarPorId(Long id);
    void eliminar(Long id);
}