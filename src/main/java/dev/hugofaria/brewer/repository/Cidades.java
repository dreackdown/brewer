package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Cidade;
import dev.hugofaria.brewer.model.Estado;
import dev.hugofaria.brewer.repository.helper.cidade.CidadesQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {

    public List<Cidade> findByEstadoCodigo(Long codigoEstado);

    public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);

}