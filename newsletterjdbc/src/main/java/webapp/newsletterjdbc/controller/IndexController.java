package webapp.newsletterjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webapp.newsletterjdbc.connection.IndexDAO;
import webapp.newsletterjdbc.model.Usuario;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");

        new IndexDAO().criaTabela();
        new IndexDAO().criaTabelaForms();
        String mensagem = "Olá, seja bem-vinda(o)!";
        mv.addObject("msg", mensagem);

        // Adicione um objeto Usuario ao modelo para preencher os campos do formulário
        mv.addObject("usuario", new Usuario());

        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView enviarEmailBanco(@RequestParam("email") String email) {
        ModelAndView mv = new ModelAndView("index");
        new IndexDAO().cadastrar(email);
        return mv;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ModelAndView enviarFormsBanco(@ModelAttribute("usuario") Usuario usuario) {
        ModelAndView mv = new ModelAndView("cadastro");

        // Use os dados do objeto Usuario
        new IndexDAO().cadastrarForms(usuario.getEmail(), usuario.getSenha(), usuario.getRepeatSenha());

        return mv;
    }

}
