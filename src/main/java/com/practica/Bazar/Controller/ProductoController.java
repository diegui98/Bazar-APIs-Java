
package com.practica.Bazar.Controller;

import com.practica.Bazar.Model.Producto;
import com.practica.Bazar.Service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService interProd;
    
    @GetMapping("bazar/traer")
    public List<Producto> getProductoList(){
        
        return interProd.getProductos();
        
    }
    
    @GetMapping("bazar/traer/{id}")
    public Producto getProducto(@PathVariable Long id){
        
        return interProd.findProducto(id);
        
    }
    
    @PostMapping("bazar/crear")
    public String saveProducto(@RequestBody Producto prod){
        
        interProd.saveProducto(prod);
        return "Se añadio un nuevo producto";
        
    }
    
    @DeleteMapping("bazar/borrar/{id}")
    public String deleteProducto(@PathVariable Long id){
        
        interProd.deleteProducto(id);
        return "Se elimino el producto indicado";
        
    }
    
    @PutMapping("bazar/editar/{id}")
    public Producto editProducto(@PathVariable Long id,
                                 @RequestParam ("nombre") String nuevoNombre,
                                 @RequestParam ("precio") int nuevoPrecio){
        Producto prod = interProd.findProducto(id);
        
        prod.setNombre(nuevoNombre);
        prod.setPrecio(nuevoPrecio);
        
        interProd.saveProducto(prod);
        return prod;
    }
    
}
