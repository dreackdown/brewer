package dev.hugofaria.brewer.service;

import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.repository.Cervejas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CadastroCervejaService {

    @Autowired
    private Cervejas cervejas;

    @Transactional
    public void salvar(Cerveja cerveja) {
        cervejas.save(cerveja);
    }

}