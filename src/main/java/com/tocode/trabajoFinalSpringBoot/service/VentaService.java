package com.tocode.trabajoFinalSpringBoot.service;

import com.tocode.trabajoFinalSpringBoot.dto.VentaFechaDTO;
import com.tocode.trabajoFinalSpringBoot.dto.VentaMasAlta;
import com.tocode.trabajoFinalSpringBoot.dto.ventaProductoDTO;
import com.tocode.trabajoFinalSpringBoot.model.Cliente;
import com.tocode.trabajoFinalSpringBoot.model.Producto;
import com.tocode.trabajoFinalSpringBoot.model.Venta;
import com.tocode.trabajoFinalSpringBoot.repository.IClienteRepository;
import com.tocode.trabajoFinalSpringBoot.repository.IProductoRepository;
import com.tocode.trabajoFinalSpringBoot.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IventaService {
    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IClienteRepository clieRepo;
    @Override
    public List<Venta> getVentas() {
       List<Venta>listaVentas= ventaRepo.findAll();
       return listaVentas;
    }



    @Transactional
    public Venta SaveVenta(Venta venta) {
        // Guarda la venta en la base de datos
        Venta savedVenta = ventaRepo.save(venta);

        // Guarda cada producto asociado a la venta
        for (Producto producto : venta.getListaProductos()) {
            productoRepository.save(producto);
        }

        Cliente cliente=  venta.getUnCliente();
        if(cliente.getId_cliente()==null){
            cliente= clieRepo.save(cliente);
        }else{
            cliente=clieRepo.findById(cliente.getId_cliente()).orElse(null);
        }
        venta.setUnCliente(cliente);


        return savedVenta;
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
     ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        Venta venta= ventaRepo.findById(codigo_venta).orElse(null);
        return venta;
    }

    @Override
    public void editVenta(Venta venta) {
        ventaRepo.save(venta);

    }

    @Override
    public ventaProductoDTO ventaProducto(Long codigo_venta) {
        ventaProductoDTO ventaProductoDTO= new ventaProductoDTO();
        Venta venta= this.findVenta(codigo_venta);
        ventaProductoDTO.setListaProducto(venta.getListaProductos());
        ventaProductoDTO.setCodigo_venta(venta.getCodigo_venta());
        return ventaProductoDTO;
    }

    @Override
    public List<Venta> ventaFecha(LocalDate fecha_venta)  {
        LocalDate fechaComparar;
        Double sumaVentasDia=0.0 ;
        Double montoVenta;

        List<Venta> ventaFechaDTO= new ArrayList<>();
        List <Venta> listaVentaTodas= this.getVentas();
        for(Venta venta:listaVentaTodas) {
           montoVenta= venta.getTotal();
           sumaVentasDia=+montoVenta;

        }
        for(Venta venta: listaVentaTodas){
            fechaComparar= venta.getFecha_venta();
            boolean mismaFecha= fechaComparar.equals(fecha_venta);
            if(mismaFecha== true){
                ventaFechaDTO.add(venta);
            }
        }


        return ventaFechaDTO;
    }

    @Override
    public VentaFechaDTO ventaFechaDTO(LocalDate fecha_venta) {
        LocalDate fechaComparar;
        Double sumaVentasDia=0.0 ;
        Double montoVenta;
        List<Venta> ventaFecha= new ArrayList<>();
         VentaFechaDTO ventaFechaDTO= new VentaFechaDTO();
        List <Venta> listaVentaTodas= this.getVentas();
        for(Venta venta: listaVentaTodas) {
            fechaComparar = venta.getFecha_venta();
            boolean mismaFecha = fechaComparar.isEqual(fecha_venta);
            if (mismaFecha== true) {
                ventaFecha.add(venta);
                montoVenta= venta.getTotal();
                sumaVentasDia+=montoVenta;
            }
        }

            ventaFechaDTO.setFecha_venta(fecha_venta);
            ventaFechaDTO.setListaVenta(ventaFecha);
            ventaFechaDTO.setSumaVentaDia(sumaVentasDia);
        return ventaFechaDTO;
    }

    @Override
    public VentaMasAlta ventaMasAlta() {
        double valorMaximoVenta = Double.MIN_VALUE;
        List<Venta> listaVenta = this.getVentas();
        VentaMasAlta ventaMasAlta = new VentaMasAlta();
         Venta ventaE = null;
        Long idActual = null;

        for (Venta venta : listaVenta) {
            double ventaActual = venta.getTotal();
            idActual = venta.getCodigo_venta();
             ventaE= this.findVenta(idActual);
            if (ventaActual > valorMaximoVenta) {
                valorMaximoVenta = ventaActual;
            }
         
        }
        ventaMasAlta.setNombreCliente(ventaE.getUnCliente().getNombre());
        ventaMasAlta.setApellidoCliente(ventaE.getUnCliente().getApellido());
        ventaMasAlta.setMonto(ventaE.getTotal());

        return ventaMasAlta;
    }


}
