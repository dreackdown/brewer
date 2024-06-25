package dev.hugofaria.brewer.repository.helper.estilo;

import dev.hugofaria.brewer.model.Estilo;
import dev.hugofaria.brewer.repository.filter.EstiloFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstilosQueries {

    public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);

}