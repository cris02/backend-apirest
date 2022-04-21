package com.echo.apirest.models.dao;

import com.echo.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
}
