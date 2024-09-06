package edu.es.eoi.marketplace.service;

import edu.es.eoi.marketplace.dto.ArticulosDto;
import edu.es.eoi.marketplace.dto.PedidosDto;
import edu.es.eoi.marketplace.dto.UsuariosDto;
import edu.es.eoi.marketplace.entity.Pedidos;
import edu.es.eoi.marketplace.entity.Usuarios;
import edu.es.eoi.marketplace.repository.UsuariosRepository;
import edu.es.eoi.marketplace.service.UsuariosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    private final UsuariosRepository usuarioRepository;

    public UsuariosServiceImpl(UsuariosRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuariosDto> findAll() {
        return usuarioRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuariosDto findById(Integer id) {
        return usuarioRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public UsuariosDto create(UsuariosDto usuarioDto) {
        // Solo utilizo username y password para crear el usuario - ignoro el resto
        Usuarios usuario = new Usuarios();
        usuario.setUsername(usuarioDto.getUsername());
        usuario.setPassword(usuarioDto.getPassword());

        usuario = usuarioRepository.save(usuario);
        return convertToDto(usuario);
    }

    @Override
    public UsuariosDto update(Integer id, UsuariosDto usuarioDto) {
        Usuarios usuario = convertToEntity(usuarioDto);
        usuario.setId(id);
        usuario = usuarioRepository.save(usuario);
        return convertToDto(usuario);
    }

    @Override
    public UsuariosDto login(String username, String password) {
        Usuarios usuario = usuarioRepository.findByUsernameAndPassword(username, password);
        return convertToDto(usuario);
    }

    private UsuariosDto convertToDto(Usuarios usuario) {
        if (usuario == null) {
            return null;
        }
        UsuariosDto dto = new UsuariosDto();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());

        return dto;
    }

    private PedidosDto convertPedidoToDto(Pedidos pedido) {
        if (pedido == null) {
            return null;
        }
        PedidosDto dto = new PedidosDto();
        dto.setId(pedido.getId());
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

    private Usuarios convertToEntity(UsuariosDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }
        Usuarios usuario = new Usuarios();
        usuario.setId(usuarioDto.getId()); 
        usuario.setUsername(usuarioDto.getUsername());
        usuario.setPassword(usuarioDto.getPassword());

        return usuario;
    }

}


