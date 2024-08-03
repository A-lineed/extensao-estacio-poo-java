package com.sistema.gestao.controller;

import com.sistema.gestao.model.Usuario;
import com.sistema.gestao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("usuarios", usuarioService.listarTodos());
		return "usuarios";
	}

	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario_formulario";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping
	public String salvar(@Validated @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return "usuario_formulario";
		}
		usuarioService.salvar(usuario);
		return "redirect:/usuarios";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioService.encontrarPorId(id);
		model.addAttribute("usuario", usuario);
		return "usuario_formulario";
	}

	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable Long id) {
		usuarioService.deletar(id);
		return "redirect:/usuarios";
	}

}
