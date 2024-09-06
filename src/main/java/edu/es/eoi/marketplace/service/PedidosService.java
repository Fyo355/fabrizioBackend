package edu.es.eoi.marketplace.service;

import edu.es.eoi.marketplace.dto.PedidosDto;

import java.util.List;

public interface PedidosService {

	PedidosDto findById(Integer id);

    List<PedidosDto> findByNombre(String nombreparcial);

    PedidosDto create(PedidosDto pedidoDto);

    PedidosDto update(Integer id, PedidosDto pedidoDto);

    void delete(Integer id);

}
