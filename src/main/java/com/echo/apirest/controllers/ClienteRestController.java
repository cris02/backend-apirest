package com.echo.apirest.controllers;

import com.echo.apirest.models.entity.Cliente;
import com.echo.apirest.models.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    //metodo para actualizar el cliente
    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteNuevo = clienteService.findById(id);
        clienteNuevo.setNombre(cliente.getNombre());
        clienteNuevo.setApellido(cliente.getApellido());
        clienteNuevo.setEmail(cliente.getEmail());
        return clienteService.save(clienteNuevo);
    }

    //metodo para eliminar un cliente
    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
