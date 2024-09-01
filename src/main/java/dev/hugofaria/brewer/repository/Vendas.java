package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Venda;
import dev.hugofaria.brewer.repository.helper.venda.VendasQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries {
}