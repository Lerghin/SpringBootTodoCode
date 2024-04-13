package com.tocode.trabajoFinalSpringBoot.service;

import com.tocode.trabajoFinalSpringBoot.model.Cliente;
import com.tocode.trabajoFinalSpringBoot.model.Producto;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();

    public void SaveClientes(Cliente cliente);
    public void deleteCliente(Long id_cliente);

    public Cliente findCliente(Long id_cliente);
    public void editCliente( Cliente cliente);

}
