package com.sistema.gestao.controller;

import com.sistema.gestao.model.Cliente;
import com.sistema.gestao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente_formulario";
    }

    @PostMapping
    public String salvar(@Validated @ModelAttribute("cliente") Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente_formulario";
        }
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.encontrarPorId(id);
        model.addAttribute("cliente", cliente);
        return "cliente_formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes";
    }
}