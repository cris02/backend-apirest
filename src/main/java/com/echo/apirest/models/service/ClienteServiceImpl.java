package com.echo.apirest.models.service;

import com.echo.apirest.models.dao.IClienteDao;
import com.echo.apirest.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepo.deleteById(id);
    }
}
