package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Clientes extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

}