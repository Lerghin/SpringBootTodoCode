package com.tocode.trabajoFinalSpringBoot.controller;

import com.tocode.trabajoFinalSpringBoot.model.Cliente;
import com.tocode.trabajoFinalSpringBoot.model.Producto;
import com.tocode.trabajoFinalSpringBoot.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService produServ;

    @GetMapping("/products/get")
    public List<Producto> getProductos(){
        return produServ.getProductos();

    }
    @GetMapping("/products/traer/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){

        return produServ.findProducto(codigo_producto);
    }

    @PostMapping("/productos/crear")
    public String createProduct(@RequestBody Producto producto){
        produServ.SaveProductos(producto);
        return "The client has created succesfully";
    }

    @DeleteMapping("/productos/borrar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        produServ.deleteProducto(codigo_producto);
        return "fue borrada the owner";


    }

    @PutMapping("/productos/editar")
    public String editProducto(@RequestBody Producto producto) {
        produServ.editProducto(producto);
        return "se ha editado correctly";

    }
    @GetMapping("/products/traer/falta_stock")
    public List<Producto> prodMenores5(){
        return produServ.prodMenores5();
    }
    @GetMapping("/products/ventas/{venta_codigo_venta}")
    public List<Producto> prodCodigoVenta(@PathVariable Long venta_codigo_venta){
        return produServ.prodCodigoVenta(venta_codigo_venta);
    }




}
