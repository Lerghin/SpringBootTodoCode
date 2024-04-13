package com.tocode.trabajoFinalSpringBoot.controller;

import com.tocode.trabajoFinalSpringBoot.model.Cliente;
import com.tocode.trabajoFinalSpringBoot.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
@Autowired
    private IClienteService clieServ;
    @GetMapping("/clientes/traer")
    public List<Cliente> getClientes(){
        return clieServ.getClientes();

    }
    @GetMapping("/clientes/traer/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return clieServ.findCliente(id_cliente);
    }

    @PostMapping("/clientes/crear")
    public String createCliente(@RequestBody Cliente cliente){
        clieServ.SaveClientes(cliente);
        return "The client has created succesfully";
    }

    @DeleteMapping("/clientes/borrar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clieServ.deleteCliente(id_cliente);
        return "fue borrada the owner";


    }

    @PutMapping("/clientes/editar")
    public String editDueño(@RequestBody Cliente cliente){
        clieServ.editCliente(cliente);
        return "se ha editado correctly";
    }


}
