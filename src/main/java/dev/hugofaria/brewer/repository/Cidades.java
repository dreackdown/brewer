package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Cidades extends JpaRepository<Cidade, Long> {

    List<Cidade> findByEstadoCodigo(Long codigoEstado);

}