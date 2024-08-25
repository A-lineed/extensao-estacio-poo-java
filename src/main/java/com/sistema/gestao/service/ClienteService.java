package com.sistema.gestao.service;

import com.sistema.gestao.model.Cliente;
import com.sistema.gestao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente encontrarPorNome(String string) {
		return clienteRepository.findByNome(string);
	}

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

}
