package dev.hugofaria.brewer.repository.helper.cidade;

import dev.hugofaria.brewer.model.Cidade;
import dev.hugofaria.brewer.repository.filter.CidadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CidadesQueries {

    Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable);

}