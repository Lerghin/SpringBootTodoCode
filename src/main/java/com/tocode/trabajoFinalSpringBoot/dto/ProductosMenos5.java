package com.tocode.trabajoFinalSpringBoot.dto;

import com.tocode.trabajoFinalSpringBoot.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductosMenos5 {
    private List<Producto> listaProductos;

    public ProductosMenos5(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

}
