package com.tocode.trabajoFinalSpringBoot.dto;


import com.tocode.trabajoFinalSpringBoot.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ventaProductoDTO {


    private Long codigo_venta;
    private List<Producto> listaProducto;

    public ventaProductoDTO() {
    }

    public ventaProductoDTO(Long codigo_venta, List<Producto> listaProducto) {
        this.codigo_venta = codigo_venta;
        this.listaProducto = listaProducto;
    }
}
