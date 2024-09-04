package dev.hugofaria.brewer.repository.helper.venda;

import dev.hugofaria.brewer.model.Venda;
import dev.hugofaria.brewer.repository.filter.VendaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface VendasQueries {

    Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);

    Venda buscarComItens(Long codigo);
}