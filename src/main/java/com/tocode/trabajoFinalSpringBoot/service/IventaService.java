package com.tocode.trabajoFinalSpringBoot.service;

import com.tocode.trabajoFinalSpringBoot.dto.VentaFechaDTO;
import com.tocode.trabajoFinalSpringBoot.dto.VentaMasAlta;
import com.tocode.trabajoFinalSpringBoot.dto.ventaProductoDTO;
import com.tocode.trabajoFinalSpringBoot.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IventaService {
    public List<Venta> getVentas();

    public Venta SaveVenta(Venta venta);
    public void deleteVenta(Long codigo_venta);

    public Venta findVenta(Long codigo_venta);
    public void editVenta( Venta venta);
    public ventaProductoDTO ventaProducto(Long codigo_venta);
    public List<Venta> ventaFecha(LocalDate fecha_venta);
    public VentaFechaDTO ventaFechaDTO(LocalDate fecha_venta);
    public VentaMasAlta ventaMasAlta();

}
