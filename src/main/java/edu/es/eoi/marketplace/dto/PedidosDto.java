package edu.es.eoi.marketplace.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
public class PedidosDto {

	@JsonIgnore
    private Integer id;

    @JsonIgnore
    private Integer usuarioId;

    private List<ArticulosDto> articulos;

    private Double total;
    
    private Date fecha; 
    
    private String nombre; 

}
