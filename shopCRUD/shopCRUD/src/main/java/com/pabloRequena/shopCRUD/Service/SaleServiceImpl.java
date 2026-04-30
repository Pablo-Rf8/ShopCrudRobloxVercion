package com.pabloRequena.shopCRUD.Service;
import com.pabloRequena.shopCRUD.Entity.Sale;
import com.pabloRequena.shopCRUD.Exception.ResourceNotFoundException;
import com.pabloRequena.shopCRUD.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired private SaleRepository repository;
    @Override public List<Sale> listar() { return repository.findAll(); }
    @Override public Sale agregar(Sale sale) { return repository.save(sale); }
    @Override public Sale buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venta no encontrada"));
    }
    @Override public void eliminar(Long id) { repository.delete(buscarPorId(id)); }
}