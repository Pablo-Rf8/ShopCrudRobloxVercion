package com.pabloRequena.shopCRUD.Service;

import com.pabloRequena.shopCRUD.Entity.SaleDetail;
import com.pabloRequena.shopCRUD.Exception.ResourceNotFoundException;
import com.pabloRequena.shopCRUD.Repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleDetailServiceImpl implements SaleDetailService {

    @Autowired
    private SaleDetailRepository repository;

    @Override
    public List<SaleDetail> listar() {
        return repository.findAll();
    }

    @Override
    public SaleDetail guardar(SaleDetail saleDetail) {
        return repository.save(saleDetail);
    }

    // <-- NUEVO MÉTODO -->
    @Override
    public SaleDetail buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Detalle de venta no encontrado con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}