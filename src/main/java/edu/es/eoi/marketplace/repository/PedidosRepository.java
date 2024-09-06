package edu.es.eoi.marketplace.repository;

import edu.es.eoi.marketplace.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

    List<Pedidos> findByNombreContaining(String nombreparcial);

}
