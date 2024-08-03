package com.sistema.gestao.service;

import com.sistema.gestao.model.Pedido;
import com.sistema.gestao.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> listarTodos() {
		return pedidoRepository.findAll();
	}

	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public Pedido encontrarPorId(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	public void deletar(Long id) {
		pedidoRepository.deleteById(id);
	}
}
