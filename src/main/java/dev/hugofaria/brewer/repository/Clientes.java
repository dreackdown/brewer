package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Cliente;
import dev.hugofaria.brewer.repository.helper.cliente.ClientesQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries {

    Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

    List<Cliente> findByNomeStartingWithIgnoreCase(String nome);
}