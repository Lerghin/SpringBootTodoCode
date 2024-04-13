package com.tocode.trabajoFinalSpringBoot.dto;


import com.tocode.trabajoFinalSpringBoot.model.Venta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter@Setter
public class VentaFechaDTO {
    private LocalDate fecha_venta;
    private List<Venta> listaVenta;
    private Double sumaVentaDia;



    public VentaFechaDTO() {
    }

    public VentaFechaDTO(LocalDate fecha_venta, List<Venta> listaVenta, Double sumaVentaDia) {
        this.fecha_venta = fecha_venta;
        this.listaVenta = listaVenta;
        this.sumaVentaDia = sumaVentaDia;
    }
}

