package com.sistema.gestao.repository;

import com.sistema.gestao.model.Producao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {
}
