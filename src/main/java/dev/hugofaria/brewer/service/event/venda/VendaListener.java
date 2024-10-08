package dev.hugofaria.brewer.service.event.venda;

import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.model.ItemVenda;
import dev.hugofaria.brewer.repository.Cervejas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class VendaListener {

    @Autowired
    private Cervejas cervejas;

    @EventListener
    public void vendaEmitida(VendaEvent vendaEvent) {
        for (ItemVenda item : vendaEvent.getVenda().getItens()) {
            Cerveja cerveja = cervejas.getOne(item.getCerveja().getCodigo());
            cerveja.setQuantidadeEstoque(cerveja.getQuantidadeEstoque() - item.getQuantidade());
            cervejas.save(cerveja);
        }
    }
}