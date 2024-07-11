package dev.hugofaria.brewer.controller;

import dev.hugofaria.brewer.controller.page.PageWrapper;
import dev.hugofaria.brewer.model.Cidade;
import dev.hugofaria.brewer.repository.Cidades;
import dev.hugofaria.brewer.repository.Estados;
import dev.hugofaria.brewer.repository.filter.CidadeFilter;
import dev.hugofaria.brewer.service.CadastroCidadeService;
import dev.hugofaria.brewer.service.exception.NomeCidadeJaCadastradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/cidades")
public class CidadesController {

    @Autowired
    private Cidades cidades;

    @Autowired
    private Estados estados;

    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @RequestMapping("/nova")
    public ModelAndView nova(Cidade cidade) {
        ModelAndView mv = new ModelAndView("cidade/CadastroCidade");
        mv.addObject("estados", estados.findAll());
        return mv;
    }

    @Cacheable(value = "cidades", key = "#codigoEstado")
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Cidade> pesquisarPorCodigoEstado(
            @RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return cidades.findByEstadoCodigo(codigoEstado);
    }

    @PostMapping("/nova")
    @CacheEvict(value = "cidades", key = "#cidade.estado.codigo", condition = "#cidade.temEstado()")
    public ModelAndView salvar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return nova(cidade);
        }

        try {
            cadastroCidadeService.salvar(cidade);
        } catch (NomeCidadeJaCadastradaException e) {
            result.rejectValue("nome", e.getMessage(), e.getMessage());
            return nova(cidade);
        }

        attributes.addFlashAttribute("mensagem", "Cidade salva com sucesso!");
        return new ModelAndView("redirect:/cidades/nova");
    }

    @GetMapping
    public ModelAndView pesquisar(CidadeFilter cidadeFilter, BindingResult result
            , @PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView("cidade/PesquisaCidades");
        mv.addObject("estados", estados.findAll());

        PageWrapper<Cidade> paginaWrapper = new PageWrapper<>(cidades.filtrar(cidadeFilter, pageable)
                , httpServletRequest);
        mv.addObject("pagina", paginaWrapper);
        return mv;
    }
}