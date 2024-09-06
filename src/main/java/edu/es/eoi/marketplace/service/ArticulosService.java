package edu.es.eoi.marketplace.service;

import edu.es.eoi.marketplace.dto.ArticulosDto;

import java.util.List;

public interface ArticulosService {

	ArticulosDto findById(Integer id);

    List<ArticulosDto> findByNombre(String nombreparcial);

    ArticulosDto create(ArticulosDto articuloDto);

    ArticulosDto update(Integer id, ArticulosDto articuloDto);

}
