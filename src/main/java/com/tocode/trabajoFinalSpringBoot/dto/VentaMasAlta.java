package com.tocode.trabajoFinalSpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaMasAlta {

    private String nombreCliente;
    private String apellidoCliente;
    private Double monto;

    public VentaMasAlta() {
    }

    public VentaMasAlta(String nombreCliente, String apellidoCliente, Double monto) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.monto = monto;
    }
}
