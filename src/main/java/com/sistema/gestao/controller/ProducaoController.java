package com.sistema.gestao.controller;

import com.sistema.gestao.model.Pedido;
import com.sistema.gestao.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producao")
public class ProducaoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String listar(@RequestParam(value = "search", required = false) String search,
                         @RequestParam(value = "status", required = false) String status,
                         Model model) {
        List<Pedido> pedidos;
        if (search != null && !search.isEmpty()) {
            pedidos = pedidoService.findBySearch(search);
        } else if (status != null && !status.isEmpty()) {
            pedidos = pedidoService.findByStatus(status);
        } else {
            pedidos = pedidoService.listarTodos();
        }
        model.addAttribute("pedidos", pedidos);
        return "/producao"; 
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.encontrarPorId(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            return "editar_producao";
        }
        return "redirect:/producao";
    }

    @PostMapping("/editar/{id}")
    public String atualizarStatus(@PathVariable Long id, @RequestParam("status") String status) {
        Pedido pedido = pedidoService.encontrarPorId(id);
        if (pedido != null) {
            pedido.setStatus(status);
            pedidoService.salvar(pedido);
        }
        return "redirect:/producao";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return "redirect:/producao";
    }
}
