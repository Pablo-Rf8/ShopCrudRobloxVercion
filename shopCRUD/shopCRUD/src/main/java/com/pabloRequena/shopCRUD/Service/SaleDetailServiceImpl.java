package com.pabloRequena.shopCRUD.Service;

import com.pabloRequena.shopCRUD.Entity.SaleDetail;
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

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}