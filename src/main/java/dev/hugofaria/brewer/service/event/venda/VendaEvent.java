package dev.hugofaria.brewer.service.event.venda;

import dev.hugofaria.brewer.model.Venda;

public class VendaEvent {

    private final Venda venda;

    public VendaEvent(Venda venda) {
        this.venda = venda;
    }

    public Venda getVenda() {
        return venda;
    }
}