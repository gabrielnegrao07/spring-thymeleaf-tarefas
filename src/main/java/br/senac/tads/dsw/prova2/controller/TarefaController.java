package br.senac.tads.dsw.prova2.controller;

import br.senac.tads.dsw.prova2.Tarefa;
import br.senac.tads.dsw.prova2.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping("/tarefas/alterar")
    public ModelAndView cadUser() {
        ModelAndView mv = new ModelAndView("/tarefa-alterar.html");
        return mv;
    }

    @PutMapping("/tarefas/alterar/{idTarefa}")
    public ModelAndView atualizar(@PathVariable("idTarefa") Integer idTarefa, @ModelAttribute("tarefa")Tarefa tarefa, RedirectAttributes redirAttr) {
        ModelAndView mv = new ModelAndView("redirect:/tarefas/todas");
        service.atualizar(tarefa, idTarefa);
        return mv;
    }

    @GetMapping("/tarefas/todas")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/tarefas-listagem.html");
        List<Tarefa> listaTarefas = service.buscar();
        mv.addObject("tarefas", listaTarefas);
        return mv;
    }

    @GetMapping("/tarefas/alterar/{idTarefa}")
    public ModelAndView buscarPorId(@PathVariable("idTarefa") Integer idTarefa) {
        Tarefa tarefa = service.burcarPorId(idTarefa);
        ModelAndView mv = new ModelAndView("tarefa-alterar.html");
        mv.addObject("tarefa", tarefa);
        return mv;
    }


}
