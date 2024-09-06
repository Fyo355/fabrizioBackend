package edu.es.eoi.marketplace.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;
    
    @Column(nullable = false)
    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "pedido_articulos",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "articulo_id")
    )
    private List<Articulos> articulos;

    
    @Column(nullable = false)
    private Date fecha;
    
    @Column(nullable = false)
    private Double total;

}
