package dev.hugofaria.brewer.service;

import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.repository.Cervejas;
import dev.hugofaria.brewer.service.event.cerveja.CervejaSalvaEvent;
import dev.hugofaria.brewer.service.exception.ImpossivelExcluirEntidadeException;
import dev.hugofaria.brewer.storage.FotoStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Service
public class CadastroCervejaService {

    @Autowired
    private Cervejas cervejas;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private FotoStorage fotoStorage;

    @Transactional
    public void salvar(Cerveja cerveja) {
        cervejas.save(cerveja);

        publisher.publishEvent(new CervejaSalvaEvent(cerveja));
    }

    @Transactional
    public void excluir(Cerveja cerveja) {
        try {
            String foto = cerveja.getFoto();
            cervejas.delete(cerveja);
            cervejas.flush();
            fotoStorage.excluir(foto);
        } catch (PersistenceException e) {
            throw new ImpossivelExcluirEntidadeException("Impossível apagar cerveja. Já foi usada em alguma venda.");
        }
    }
}