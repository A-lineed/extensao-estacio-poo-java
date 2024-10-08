package com.sistema.gestao.repository;

import com.sistema.gestao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByNome(String string);
}
