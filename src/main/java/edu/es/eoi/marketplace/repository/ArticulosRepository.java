package edu.es.eoi.marketplace.repository;

import edu.es.eoi.marketplace.entity.Articulos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticulosRepository extends JpaRepository<Articulos, Integer> {

    List<Articulos> findByNombreContaining(String nombreparcial);

}
