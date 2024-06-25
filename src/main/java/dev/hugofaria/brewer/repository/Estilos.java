package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Estilo;
import dev.hugofaria.brewer.repository.helper.estilo.EstilosQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long>, EstilosQueries {

    Optional<Estilo> findByNomeIgnoreCase(String nome);
}