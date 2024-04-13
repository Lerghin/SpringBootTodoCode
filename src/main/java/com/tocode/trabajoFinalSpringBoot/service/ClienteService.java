package com.tocode.trabajoFinalSpringBoot.service;

import com.tocode.trabajoFinalSpringBoot.model.Cliente;
import com.tocode.trabajoFinalSpringBoot.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository clieRepo;

    @Override
    public List<Cliente> getClientes() {
       List<Cliente> listaClientes= clieRepo.findAll();
       return listaClientes;
    }

    @Override
    public void SaveClientes(Cliente cliente) {
        clieRepo.save(cliente);

    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clieRepo.deleteById(id_cliente);

    }

    @Override
    public Cliente findCliente(Long id_cliente) {
       Cliente cliente= clieRepo.findById(id_cliente).orElse(null);
               return cliente;
    }

    @Override
    public void editCliente(Cliente cliente) {
     clieRepo.save(cliente);
    }
}
