
package com.senacead.Podologia.service;

import com.senacead.Podologia.model.Avaliacao;
import com.senacead.Podologia.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvaliacaoService {
     @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    // Método para criar uma nova avaliação
    public Avaliacao criar(Avaliacao avaliacao, MultipartFile foto) {
    avaliacao.setDataAvaliacao(LocalDateTime.now());

    if (foto != null && !foto.isEmpty()) {
        try {
            String diretorio = "src/main/resources/static/uploads/";
            Path caminho = Paths.get(diretorio + foto.getOriginalFilename());

            // Cria o diretório se não existir
            Files.createDirectories(caminho.getParent());

            // Salva a imagem
            Files.write(caminho, foto.getBytes());

            // Define o caminho da imagem no banco de dados
            avaliacao.setFotoUrl("/uploads/" + foto.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return avaliacaoRepository.save(avaliacao);
}

    // Método para buscar todas as avaliações
    public List<Avaliacao> buscarTodas() {
        return avaliacaoRepository.findAll();
    }

    // Método para buscar avaliações por ID do serviço
    public List<Avaliacao> buscarPorServicoId(Integer servicoId) {
        return avaliacaoRepository.findByServicoId(servicoId);
    }

    // Método para buscar as últimas avaliações (ordenadas por data decrescente)
    public List<Avaliacao> buscarUltimasAvaliacoes(int limite) {
        return avaliacaoRepository.findTop3ByOrderByDataAvaliacaoDesc();
    }

    // Método para buscar uma avaliação por ID
    public Avaliacao buscarPorId(Integer id) {
        return avaliacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    // Método para excluir uma avaliação por ID
    public void excluir(Integer id) {
        Avaliacao avaliacaoEncontrada = buscarPorId(id);
        avaliacaoRepository.deleteById(avaliacaoEncontrada.getId());
    }

    // Método para atualizar uma avaliação
    public Avaliacao atualizar(Integer id, Avaliacao avaliacao, MultipartFile foto) {
        Avaliacao avaliacaoEncontrada = buscarPorId(id);

        // Atualiza os dados da avaliação
        avaliacaoEncontrada.setNomeCliente(avaliacao.getNomeCliente());
        avaliacaoEncontrada.setEstrelas(avaliacao.getEstrelas());
        avaliacaoEncontrada.setComentario(avaliacao.getComentario());
        avaliacaoEncontrada.setServicoId(avaliacao.getServicoId());

        // Atualiza a foto, se fornecida
        if (foto != null && !foto.isEmpty()) {
            try {
                String diretorio = "src/main/resources/static/uploads/";
                Path caminho = Paths.get(diretorio + foto.getOriginalFilename());
                Files.write(caminho, foto.getBytes());
                avaliacaoEncontrada.setFotoUrl("/uploads/" + foto.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return avaliacaoRepository.save(avaliacaoEncontrada);
    }
}
