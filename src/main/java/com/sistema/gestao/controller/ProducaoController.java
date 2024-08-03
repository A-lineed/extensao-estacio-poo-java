package com.sistema.gestao.controller;

import com.sistema.gestao.model.Producao;
import com.sistema.gestao.service.ProducaoService;
import com.sistema.gestao.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/producoes")
public class ProducaoController {

    @Autowired
    private ProducaoService producaoService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("producoes", producaoService.listarTodos());
        return "producoes";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("producao", new Producao());
        model.addAttribute("pedidos", pedidoService.listarTodos());
        return "producao_formulario";
    }

    @PostMapping
    public String salvar(@Validated @ModelAttribute("producao") Producao producao, BindingResult result) {
        if (result.hasErrors()) {
            return "producao_formulario";
        }
        producaoService.salvar(producao);
        return "redirect:/producoes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Producao producao = producaoService.encontrarPorId(id);
        model.addAttribute("producao", producao);
        model.addAttribute("pedidos", pedidoService.listarTodos());
        return "producao_formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        producaoService.deletar(id);
        return "redirect:/producoes";
    }
}
