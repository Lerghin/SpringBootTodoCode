package com.tocode.trabajoFinalSpringBoot.service;

import com.tocode.trabajoFinalSpringBoot.dto.ventaProductoDTO;
import com.tocode.trabajoFinalSpringBoot.model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> getProductos();

    public void SaveProductos(Producto producto);
    public void deleteProducto(Long codigo_producto);

    public Producto findProducto(Long codigo_producto);
    public void editProducto( Producto  producto);
    public List<Producto> prodMenores5();

    public List<Producto> prodCodigoVenta(Long codigo_venta);



}
