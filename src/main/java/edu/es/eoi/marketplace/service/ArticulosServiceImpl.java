package edu.es.eoi.marketplace.service;

import edu.es.eoi.marketplace.dto.ArticulosDto;
import edu.es.eoi.marketplace.entity.Articulos;
import edu.es.eoi.marketplace.repository.ArticulosRepository;
import edu.es.eoi.marketplace.service.ArticulosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticulosServiceImpl  implements ArticulosService {

    private final ArticulosRepository articuloRepository;

    public ArticulosServiceImpl(ArticulosRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public ArticulosDto findById(Integer id) {
        return articuloRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public List<ArticulosDto> findByNombre(String nombreparcial) {
        return articuloRepository.findByNombreContaining(nombreparcial).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ArticulosDto create(ArticulosDto articuloDto) {
        Articulos articulo = convertToEntity(articuloDto);
        articulo = articuloRepository.save(articulo);
        return convertToDto(articulo);
    }

    @Override
    public ArticulosDto update(Integer id, ArticulosDto articuloDto) {
        Articulos articulo = convertToEntity(articuloDto);
        articulo.setId(id);
        articulo = articuloRepository.save(articulo);
        return convertToDto(articulo);
    }

    private ArticulosDto convertToDto(Articulos articulo) {
        if (articulo == null) {
            return null;
        }
        ArticulosDto dto = new ArticulosDto();
        dto.setId(articulo.getId());
        dto.setNombre(articulo.getNombre());
        dto.setPrecio(articulo.getPrecio());
        dto.setStock(articulo.getStock());
        return dto;
    }

    private Articulos convertToEntity(ArticulosDto articuloDto) {
        if (articuloDto == null) {
            return null;
        }
        Articulos articulo = new Articulos();
        articulo.setId(articuloDto.getId());
        articulo.setNombre(articuloDto.getNombre());
        articulo.setPrecio(articuloDto.getPrecio());
        articulo.setStock(articuloDto.getStock());
        return articulo;
    }

}
