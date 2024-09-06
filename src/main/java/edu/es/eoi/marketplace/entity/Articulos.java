package edu.es.eoi.marketplace.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "articulos")
public class Articulos{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(nullable = false)
	private String nombre; 
	
	@Column(nullable = false)
	private Double precio;
	
	@Column(nullable =false)
	private Integer stock;
	
	
	
	
	
}
