
package com.practica.Bazar.Service;

import com.practica.Bazar.Model.Producto;
import java.util.List;


public interface IProductoService {
    
    public List <Producto> getProductos();
    
    public void saveProducto(Producto prod);
    
    public void deleteProducto(Long id);
    
    public Producto findProducto(Long id);
    
}
