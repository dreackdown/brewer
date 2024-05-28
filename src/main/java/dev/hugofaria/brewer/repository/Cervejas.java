package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long> {

    public Optional<Cerveja> findBySkuIgnoreCase(String sku);
}