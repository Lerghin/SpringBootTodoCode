package com.tocode.trabajoFinalSpringBoot.service;

import com.tocode.trabajoFinalSpringBoot.dto.ventaProductoDTO;
import com.tocode.trabajoFinalSpringBoot.model.Producto;
import com.tocode.trabajoFinalSpringBoot.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository produRepo;
    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProducto= produRepo.findAll();
        return listaProducto;
    }

    @Override
    public void SaveProductos(Producto producto) {
        produRepo.save(producto);

    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        produRepo.deleteById(codigo_producto);

    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        Producto producto= produRepo.findById(codigo_producto).orElse(null);
        return producto;
    }

    @Override
    public void editProducto(Producto producto) {
        produRepo.save(producto);

    }


    @Override
    public List<Producto> prodMenores5() {
        double cantidad = 5.0;
        List<Producto> productos = this.getProductos();
        List<Producto> prodMenores5 = new ArrayList<>();

        if (productos != null) {
            for (Producto producto : productos) {
                Double compararCantidad = producto.getCantidad_disponible();
                Long id_producto= producto.getCodigo_producto();

                if (compararCantidad != null && compararCantidad < cantidad) {
                    prodMenores5.add(producto);
                }
            }
        }

        return prodMenores5;
    }

    @Override
    public List<Producto> prodCodigoVenta(Long venta_codigo_venta) {
        Long codigo;
       List<Producto> listProductos= this.getProductos();
        List<Producto> prodCodVentas= new ArrayList <Producto>();
        for(Producto producto: listProductos){
         codigo= producto.getVenta().getCodigo_venta();
         if(venta_codigo_venta==codigo){
             prodCodVentas.add(producto);
         }
        }
        return prodCodVentas;
    }



}
