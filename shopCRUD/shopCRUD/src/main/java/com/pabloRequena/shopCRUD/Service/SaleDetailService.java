package com.pabloRequena.shopCRUD.Service;

import com.pabloRequena.shopCRUD.Entity.SaleDetail;
import java.util.List;

public interface SaleDetailService {
    List<SaleDetail> listar();
    SaleDetail guardar(SaleDetail saleDetail);
    SaleDetail buscarPorId(Long id); // <-- NUEVO
    void eliminar(Long id);
}