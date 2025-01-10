package com.senacead.Podologia.repository;

import com.senacead.Podologia.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
   // Busca avaliações por ID do serviço
    List<Avaliacao> findByServicoId(Integer servicoId);

    // Busca as últimas avaliações (ordenadas por data decrescente)
    List<Avaliacao> findTop3ByOrderByDataAvaliacaoDesc();
}