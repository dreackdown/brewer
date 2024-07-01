package dev.hugofaria.brewer.service;

import dev.hugofaria.brewer.model.Cliente;
import dev.hugofaria.brewer.repository.Clientes;
import dev.hugofaria.brewer.service.exception.CpfCnpjClienteJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CadastroClienteService {

    @Autowired
    private Clientes clientes;

    @Transactional
    public void salvar(Cliente cliente) {
        Optional<Cliente> clienteExistente = clientes.findByCpfOuCnpj(cliente.getCpfOuCnpjSemFormatacao());
        if (clienteExistente.isPresent()) {
            throw new CpfCnpjClienteJaCadastradoException("CPF/CNPJ já cadastrado");
        }

        clientes.save(cliente);
    }
}