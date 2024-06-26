package dev.hugofaria.brewer.service;

import dev.hugofaria.brewer.model.Cidade;
import dev.hugofaria.brewer.repository.Cidades;
import dev.hugofaria.brewer.service.exception.NomeCidadeJaCadastradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CadastroCidadeService {

    @Autowired
    private Cidades cidades;

    @Transactional
    public void salvar(Cidade cidade) {
        Optional<Cidade> cidadeExistente = cidades.findByNomeAndEstado(cidade.getNome(), cidade.getEstado());
        if (cidadeExistente.isPresent()) {
            throw new NomeCidadeJaCadastradaException("Nome de cidade já cadastrado");
        }

        cidades.save(cidade);
    }
}