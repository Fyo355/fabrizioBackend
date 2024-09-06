package edu.es.eoi.marketplace.service;

import edu.es.eoi.marketplace.dto.ArticulosDto;
import edu.es.eoi.marketplace.dto.PedidosDto;
import edu.es.eoi.marketplace.entity.Pedidos;
import edu.es.eoi.marketplace.repository.PedidosRepository;
import edu.es.eoi.marketplace.service.PedidosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidosServiceImpl implements PedidosService {

    private final PedidosRepository pedidoRepository;

    public PedidosServiceImpl(PedidosRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidosDto findById(Integer id) {
        return pedidoRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public List<PedidosDto> findByNombre(String nombreparcial) {
        return pedidoRepository.findByNombreContaining(nombreparcial).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PedidosDto create(PedidosDto pedidoDto) {
        Pedidos pedido = convertToEntity(pedidoDto);
        pedido = pedidoRepository.save(pedido);
        return convertToDto(pedido);
    }

    @Override
    public PedidosDto update(Integer id, PedidosDto pedidoDto) {
        Pedidos pedido = convertToEntity(pedidoDto);
        pedido.setId(id);
        pedido = pedidoRepository.save(pedido);
        return convertToDto(pedido);
    }

    @Override
    public void delete(Integer id) {
        pedidoRepository.deleteById(id);
    }

    private PedidosDto convertToDto(Pedidos pedido) {
        if (pedido == null) {
            return null;
        }
        PedidosDto dto = new PedidosDto();
        dto.setId(pedido.getId());
        dto.setNombre(pedido.getNombre());
        dto.setFecha(pedido.getFecha());
        dto.setTotal(pedido.getTotal());

        if (pedido.getUsuario() != null) {
            dto.setUsuarioId(pedido.getUsuario().getId());
        }

        if (pedido.getArticulos() != null) {
            List<ArticulosDto> articulosDtoList = pedido.getArticulos().stream()
                    .map(articulo -> {
                        ArticulosDto articulosDto = new ArticulosDto();
                        articulosDto.setId(articulo.getId());
                        articulosDto.setNombre(articulo.getNombre());
                        articulosDto.setPrecio(articulo.getPrecio());
                        articulosDto.setStock(articulo.getStock());
                        return articulosDto;
                    })
                    .collect(Collectors.toList());
            dto.setArticulos(articulosDtoList);
        }

        return dto;
    }


    private Pedidos convertToEntity(PedidosDto pedidoDto) {
        if (pedidoDto == null) {
            return null;
        }
        Pedidos pedido = new Pedidos();
        pedido.setId(pedidoDto.getId());
        pedido.setNombre(pedidoDto.getNombre());
        pedido.setFecha(pedidoDto.getFecha());
        pedido.setTotal(pedidoDto.getTotal());

        return pedido;
    }

}
