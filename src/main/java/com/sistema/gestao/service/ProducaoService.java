package com.sistema.gestao.service;

import com.sistema.gestao.model.Producao;
import com.sistema.gestao.repository.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducaoService {

	@Autowired
	private ProducaoRepository producaoRepository;

	public List<Producao> listarTodos() {
		return producaoRepository.findAll();
	}

	public Producao salvar(Producao producao) {
		return producaoRepository.save(producao);
	}

	public Producao encontrarPorId(Long id) {
		return producaoRepository.findById(id).orElse(null);
	}

	public void deletar(Long id) {
		producaoRepository.deleteById(id);
	}
}
