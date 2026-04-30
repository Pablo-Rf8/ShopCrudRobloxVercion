package com.pabloRequena.shopCRUD.Service;

import com.pabloRequena.shopCRUD.Entity.SaleDetail;
import java.util.List;

public interface SaleDetailService {
    List<SaleDetail> listar();
    SaleDetail guardar(SaleDetail saleDetail);
    void eliminar(Long id);
}