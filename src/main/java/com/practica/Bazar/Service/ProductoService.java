
package com.practica.Bazar.Service;

import com.practica.Bazar.Model.Producto;
import com.practica.Bazar.Repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private ProductoRepository prodRepo;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProd = prodRepo.findAll();
        return listaProd;
    }

    @Override
    public void saveProducto(Producto prod) {
        prodRepo.save(prod);
    }

    @Override
    public void deleteProducto(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        Producto prod = prodRepo.findById(id).orElse(null);
        return prod;
    }
    
}
