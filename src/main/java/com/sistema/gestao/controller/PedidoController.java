package com.sistema.gestao.controller;

import com.sistema.gestao.model.Pedido;
import com.sistema.gestao.service.ClienteService;
import com.sistema.gestao.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.listarTodos());
        return "pedidos";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("clientes", clienteService.listarTodos());
        return "pedido_formulario";
    }

    @PostMapping
    public String salvar(@Validated @ModelAttribute("pedido") Pedido pedido, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido_formulario";
        }
        pedidoService.salvar(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.encontrarPorId(id);
        model.addAttribute("pedido", pedido);
        model.addAttribute("clientes", clienteService.listarTodos());
        return "pedido_formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return "redirect:/pedidos";
    }
}
