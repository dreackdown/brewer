package dev.hugofaria.brewer.controller;

import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.model.Venda;
import dev.hugofaria.brewer.repository.Cervejas;
import dev.hugofaria.brewer.security.UsuarioSistema;
import dev.hugofaria.brewer.service.CadastroVendaService;
import dev.hugofaria.brewer.session.TabelasItensSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private Cervejas cervejas;

    @Autowired
    private TabelasItensSession tabelaItens;

    @Autowired
    private CadastroVendaService cadastroVendaService;

    @GetMapping("/nova")
    public ModelAndView nova(Venda venda) {
        ModelAndView mv = new ModelAndView("venda/CadastroVenda");
        venda.setUuid(UUID.randomUUID().toString());
        return mv;
    }

    @PostMapping("/nova")
    public ModelAndView salvar(Venda venda, RedirectAttributes attributes, @AuthenticationPrincipal UsuarioSistema usuarioSistema) {
        venda.setUsuario(usuarioSistema.getUsuario());
        venda.adicionarItens(tabelaItens.getItens(venda.getUuid()));

        cadastroVendaService.salvar(venda);
        attributes.addFlashAttribute("mensagem", "Venda salva com sucesso");
        return new ModelAndView("redirect:/vendas/nova");
    }

    @PostMapping("/item")
    public ModelAndView adicionarItem(Long codigoCerveja, String uuid) {
        Cerveja cerveja = cervejas.findOne(codigoCerveja);
        tabelaItens.adicionarItem(uuid, cerveja, 1);
        return mvTabelaItensVenda(uuid);
    }

    @PutMapping("/item/{codigoCerveja}")
    public ModelAndView alterarQuantidadeItem(@PathVariable("codigoCerveja") Cerveja cerveja
            , Integer quantidade, String uuid) {
        tabelaItens.alterarQuantidadeItens(uuid, cerveja, quantidade);
        return mvTabelaItensVenda(uuid);
    }

    @DeleteMapping("/item/{uuid}/{codigoCerveja}")
    public ModelAndView excluirItem(@PathVariable("codigoCerveja") Cerveja cerveja
            , @PathVariable String uuid) {
        tabelaItens.excluirItem(uuid, cerveja);
        return mvTabelaItensVenda(uuid);
    }

    private ModelAndView mvTabelaItensVenda(String uuid) {
        ModelAndView mv = new ModelAndView("venda/TabelaItensVenda");
        mv.addObject("itens", tabelaItens.getItens(uuid));
        mv.addObject("valorTotal", tabelaItens.getValorTotal(uuid));
        return mv;
    }
}