package com.tocode.trabajoFinalSpringBoot.controller;

import com.tocode.trabajoFinalSpringBoot.dto.VentaFechaDTO;
import com.tocode.trabajoFinalSpringBoot.dto.VentaMasAlta;
import com.tocode.trabajoFinalSpringBoot.dto.ventaProductoDTO;
import com.tocode.trabajoFinalSpringBoot.model.Producto;
import com.tocode.trabajoFinalSpringBoot.model.Venta;
import com.tocode.trabajoFinalSpringBoot.service.IClienteService;
import com.tocode.trabajoFinalSpringBoot.service.IProductoService;
import com.tocode.trabajoFinalSpringBoot.service.IventaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IventaService ventaServ;
    @Autowired
    private IClienteService clieServ;

    @Autowired
    private IProductoService produServ;

    @GetMapping("/ventas/get")
    public List<Venta> getVentas(){
        return ventaServ.getVentas();

    }
    @GetMapping("/ventas/traer/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){

        return ventaServ.findVenta(codigo_venta);
    }
    @DeleteMapping("/ventas/borrar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        ventaServ.deleteVenta(codigo_venta);
        return "fue borrada the sell";


    }

    @PutMapping("/ventas/editar")
    public String editventa(@RequestBody Venta venta) {
        ventaServ.editVenta(venta);
        return "se ha editado correctly";

    }

    @PostMapping("/ventas/crear")
    public ResponseEntity<?> createVenta(@RequestBody Venta venta) {
        try {
            // Asigna la venta a cada uno de los productos en la lista de productos
            for (Producto producto : venta.getListaProductos()) {
                producto.setVenta(venta);
            }

            // Guarda la venta y los productos asociados
            ventaServ.SaveVenta(venta);

            // Retorna la venta guardada
            return new ResponseEntity<>(venta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la venta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/ventas/productos/{codigo_venta}")
  public ventaProductoDTO ventaProductoDTO(@PathVariable Long codigo_venta){
        return ventaServ.ventaProducto(codigo_venta);
    }

    @GetMapping("/ventas/{fecha_venta}")
    public VentaFechaDTO ventaFechaDTO(@PathVariable LocalDate fecha_venta){
        return  ventaServ.ventaFechaDTO(fecha_venta);
    }
    @GetMapping("/products/ventas/mayor_venta")
    public VentaMasAlta ventaMasAlta(){
        return ventaServ.ventaMasAlta();
    }


}




