package com.senacead.Podologia.controller;

import com.senacead.Podologia.model.Avaliacao;
import com.senacead.Podologia.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    // Exibir a página de avaliações
    @GetMapping("/lista")
    public String listarAvaliacoes(Model model) {
        model.addAttribute("avaliacoes", avaliacaoService.buscarTodas());
        return "avaliacoes";
    }

    // Exibir formulário para criar uma nova avaliação
    @GetMapping("/novo")
    public String exibirFormularioCriacao(Model model) {
        model.addAttribute("avaliacao", new Avaliacao());
        return "formulario-avaliacao";
    }

    // Processar o formulário de criação de avaliação
    @PostMapping
    public String criarAvaliacao(@ModelAttribute Avaliacao avaliacao, @RequestParam("foto") MultipartFile foto) {
        avaliacaoService.criar(avaliacao, foto);
        return "redirect:/avaliacoes";
    }

    // Exibir formulário para editar uma avaliação
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Integer id, Model model) {
        Avaliacao avaliacao = avaliacaoService.buscarPorId(id);
        model.addAttribute("avaliacao", avaliacao);
        return "formulario-avaliacao";
    }

    // Processar o formulário de edição de avaliação
    @PostMapping("/editar/{id}")
    public String atualizarAvaliacao(@PathVariable Integer id, @ModelAttribute Avaliacao avaliacao, @RequestParam("foto") MultipartFile foto) {
        avaliacaoService.atualizar(id, avaliacao, foto);
        return "redirect:/avaliacoes";
    }

    // Excluir uma avaliação
    @GetMapping("/excluir/{id}")
    public String excluirAvaliacao(@PathVariable Integer id) {
        avaliacaoService.excluir(id);
        return "redirect:/avaliacoes";
    }
}
