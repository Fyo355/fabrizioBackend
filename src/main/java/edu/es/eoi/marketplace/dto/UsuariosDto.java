package edu.es.eoi.marketplace.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
public class UsuariosDto {

    private Integer id;

    private String username;

    private String password;

    @JsonIgnore
    private List<PedidosDto> pedidos;

}
