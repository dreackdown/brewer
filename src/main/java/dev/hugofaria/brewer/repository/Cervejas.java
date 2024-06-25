package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.repository.helper.cerveja.CervejasQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries {
}