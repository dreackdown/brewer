package dev.hugofaria.brewer.repository.helper.cliente;

import dev.hugofaria.brewer.model.Cliente;
import dev.hugofaria.brewer.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientesQueries {

    Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);

}