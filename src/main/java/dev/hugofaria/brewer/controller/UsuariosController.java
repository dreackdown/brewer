package dev.hugofaria.brewer.controller;

import dev.hugofaria.brewer.model.Usuario;
import dev.hugofaria.brewer.repository.Grupos;
import dev.hugofaria.brewer.repository.Usuarios;
import dev.hugofaria.brewer.repository.filter.UsuarioFilter;
import dev.hugofaria.brewer.service.CadastroUsuarioService;
import dev.hugofaria.brewer.service.exception.EmailUsuarioJaCadastradoException;
import dev.hugofaria.brewer.service.exception.SenhaObrigatoriaUsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Autowired
    private Grupos grupos;

    @Autowired
    private Usuarios usuarios;

    @RequestMapping("/novo")
    public ModelAndView novo(Usuario usuario) {
        ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
        mv.addObject("grupos", grupos.findAll());
        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(usuario);
        }

        try {
            cadastroUsuarioService.salvar(usuario);
        } catch (EmailUsuarioJaCadastradoException e) {
            result.rejectValue("email", e.getMessage(), e.getMessage());
            return novo(usuario);
        } catch (SenhaObrigatoriaUsuarioException e) {
            result.rejectValue("senha", e.getMessage(), e.getMessage());
            return novo(usuario);
        }

        attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso");
        return new ModelAndView("redirect:/usuarios/novo");
    }

    @GetMapping
    public ModelAndView pesquisar(UsuarioFilter usuarioFilter) {
        ModelAndView mv = new ModelAndView("/usuario/PesquisaUsuarios");
        mv.addObject("usuarios", usuarios.filtrar(usuarioFilter));
        mv.addObject("grupos", grupos.findAll());
        return mv;
    }
}