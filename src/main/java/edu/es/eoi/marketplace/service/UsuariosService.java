package edu.es.eoi.marketplace.service;

import edu.es.eoi.marketplace.dto.UsuariosDto;

import java.util.List;

public interface UsuariosService {

    List<UsuariosDto> findAll();

    UsuariosDto findById(Integer id);

    UsuariosDto create(UsuariosDto usuarioDto);

    UsuariosDto update(Integer id, UsuariosDto usuarioDto);

    UsuariosDto login(String username, String password);

}

