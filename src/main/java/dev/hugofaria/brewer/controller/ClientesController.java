package dev.hugofaria.brewer.controller;

import dev.hugofaria.brewer.controller.page.PageWrapper;
import dev.hugofaria.brewer.model.Cliente;
import dev.hugofaria.brewer.model.TipoPessoa;
import dev.hugofaria.brewer.repository.Clientes;
import dev.hugofaria.brewer.repository.Estados;
import dev.hugofaria.brewer.repository.filter.ClienteFilter;
import dev.hugofaria.brewer.service.CadastroClienteService;
import dev.hugofaria.brewer.service.exception.CpfCnpjClienteJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private Estados estados;

    @Autowired
    private CadastroClienteService cadastroClienteService;

    @Autowired
    private Clientes clientes;

    @RequestMapping("/novo")
    public ModelAndView novo(Cliente cliente) {
        ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
        mv.addObject("tiposPessoa", TipoPessoa.values());
        mv.addObject("estados", estados.findAll());
        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(cliente);
        }

        try {
            cadastroClienteService.salvar(cliente);
        } catch (CpfCnpjClienteJaCadastradoException e) {
            result.rejectValue("cpfOuCnpj", e.getMessage(), e.getMessage());
            return novo(cliente);
        }

        attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
        return new ModelAndView("redirect:/clientes/novo");
    }

    @GetMapping
    public ModelAndView pesquisar(ClienteFilter clienteFilter, BindingResult result
            , @PageableDefault(size = 3) Pageable pageable, HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView("cliente/PesquisaClientes");
        mv.addObject("tiposPessoa", TipoPessoa.values());

        PageWrapper<Cliente> paginaWrapper = new PageWrapper<>(clientes.filtrar(clienteFilter, pageable)
                , httpServletRequest);
        mv.addObject("pagina", paginaWrapper);
        return mv;
    }

    @RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Cliente> pesquisar(String nome) {
        validarTamanhoNome(nome);
        return clientes.findByNomeStartingWithIgnoreCase(nome);
    }

    private void validarTamanhoNome(String nome) {
        if (StringUtils.isEmpty(nome) || nome.length() < 3) {
            throw new IllegalArgumentException();
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Void> tratarIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
    }
}