package edu.es.eoi.marketplace.repository;

import edu.es.eoi.marketplace.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    Usuarios findByUsernameAndPassword(String username, String password);

}
