/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senacead.Podologia.controller;

import com.senacead.Podologia.model.CarouseItem;
import com.senacead.Podologia.model.Avaliacao;
import com.senacead.Podologia.service.AvaliacaoService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class SiteController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/")
    public String home(Model model) {
        // Adiciona o título e subtítulo
        model.addAttribute("title", "Podologia - Cuidando dos seus pés");
        model.addAttribute("subtitle", "Especialistas em cuidar do bem-estar dos seus pés.");

        // Adiciona os serviços (se necessário)
        model.addAttribute("services", new String[]{
            "Onicomicose - Tratamento de doenças das unhas.",
            "Podologia Avançada - Cuidados completos para os pés.",
            "Cuidados Preventivos - Evite problemas futuros com nossos serviços."
        });

        // Adiciona os itens do carrossel
        List<CarouseItem> carouselItems = Arrays.asList(
                new CarouseItem(
                        "https://imgs.search.brave.com/CenGaWRGY0lK0LDOJzDnzQ_YJDRojbexQH-ehsh08kQ/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/YW1hdG8uY29tLmJy/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDIz/LzA1L2Nsb3NlLXVw/LW9mLWEtbGVnLXdp/dGgtYS1mdW5ndXMt/b24tbmFpbHMtb24t/YS13b29kLTIwMjMt/MDMtMjItMTQtMzEt/MjUtdXRjLUdyYW5k/ZS0yLTkzMHg2MjAu/anBlZw",
                        "Tratamento de Onicomicose",
                        "A onicomicose, também conhecida como fungo das unhas, é uma infecção fúngica que atinge principalmente as unhas dos pés, embora também possa afetar as mãos. "
                ),
                new CarouseItem(
                        "https://imgs.search.brave.com/p62CsCkXR2gG22ThSJmQ--vzrXcsD-TypLSx1S4ez3s/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9hc3Nl/dHMucGxhbm5lLmNv/bS5ici9hcHBzLzdY/VkVJTDQyT0ZQL2lt/YWdlcy9oaWdoL3Vn/b1ZJT1lEN3JQNTB0/d2Q3aGZQRFRIRU1G/a2FIckRCVEpnUldE/cVUuanBn",
                        "Reflexologia",
                        "A reflexologia é uma técnica terapêutica que envolve a aplicação de pressão em pontos específicos dos pés, mãos e orelhas, com o objetivo de promover o equilíbrio e a saúde do corpo como um todo."
                ),
                new CarouseItem(
                        "https://i0.wp.com/www.clinicadospes.com.br/wp-content/uploads/2016/10/calosidade.jpg?fit=1000%2C509&ssl=1",
                        "Calosidade",
                        "Áreas endurecidas da pele que se formam como resposta ao atrito, contusões ou pressão repetida."
                )
        );
        model.addAttribute("carouselItems", carouselItems);

        return "index"; // Nome do template HTML que será renderizado
    }

    @GetMapping("/sobre")
    public String about(Model model) {
        model.addAttribute("title", "Sobre Nós");
        model.addAttribute("description", "Somos especialistas em podologia com anos de experiência cuidando da saúde dos pés de nossos pacientes.");
        return "sobre"; // Página sobre
    }

    @GetMapping("/servicos")
    public String services(Model model) {
        model.addAttribute("title", "Nossos Serviços");
        model.addAttribute("services", new String[]{
            "Onicomicose", "Podologia Avançada", "Cuidados Preventivos"
        });
        return "servicos"; // Página de serviços
    }

    @GetMapping("/contato")
    public String contact(Model model) {
        model.addAttribute("title", "Entre em Contato");
        model.addAttribute("description", "Fale conosco para agendar uma consulta ou tirar dúvidas.");
        return "contato"; // Página de contato
    }

    @GetMapping("/Onicomicose")
    public String onicomicose(Model model) {
        model.addAttribute("title", "Onicomicose - Tratamento de Fungos nas Unhas");
        model.addAttribute("description", "A onicomicose é uma infecção fúngica que afeta as unhas. Saiba mais sobre os sintomas, tratamentos e prevenção.");
        return "Onicomicose"; // Nome do template HTML que será renderizado
    }

    @GetMapping("/Reflexologia")
    public String reflexologia(Model model) {
        model.addAttribute("title", "Reflexologia - Equilíbrio e Bem-Estar");
        model.addAttribute("description", "A reflexologia é uma técnica terapêutica que promove o equilíbrio e a saúde do corpo através da estimulação de pontos específicos nos pés.");
        return "Reflexologia"; // Nome do template HTML que será renderizado
    }

    @GetMapping("/Calosidade")
    public String calosidade(Model model) {
        model.addAttribute("title", "Calosidade - Tratamento e Prevenção");
        model.addAttribute("description", "A calosidade é uma área de pele espessada que se forma devido ao atrito ou pressão. Saiba mais sobre os tratamentos e cuidados preventivos.");
        return "Calosidade"; // Nome do template HTML que será renderizado
    }

    @GetMapping("/PodologiaPreventiva")
    public String podologiaPreventiva(Model model) {
        model.addAttribute("title", "Podologia Preventiva - Cuidados com os Pés");
        model.addAttribute("description", "A podologia preventiva visa manter a saúde dos pés, evitando problemas como calos, unhas encravadas e infecções.");
        return "Podologia Preventiva"; // Nome do template HTML que será renderizado
    }

    @GetMapping("/UnhaEncravada")
    public String unhaEncravada(Model model) {
        model.addAttribute("title", "Unha Encravada - Tratamento e Prevenção");
        model.addAttribute("description", "A unha encravada ocorre quando a unha cresce e penetra na pele ao redor. Saiba mais sobre os tratamentos e cuidados preventivos.");
        return "UnhaEncravada"; // Nome do template HTML que será renderizado
    }

    @GetMapping("/OrteseUnha")
    public String orteseUnha(Model model) {
        model.addAttribute("title", "Órtese para Unhas - Correção e Tratamento");
        model.addAttribute("description", "A órtese para unhas é um dispositivo utilizado para corrigir unhas encravadas e deformidades ungueais de forma não cirúrgica.");
        return "OrteseUnha"; // Nome do template HTML que será renderizado
    }

    @GetMapping("/VerrugaPlantar")
    public String verrugaPlantar(Model model) {
        model.addAttribute("title", "Verruga Plantar - Tratamento e Cuidados");
        model.addAttribute("description", "A verruga plantar é uma lesão causada pelo vírus HPV que aparece na sola dos pés. Conheça os sintomas, tratamentos e prevenção.");
        return "VerrugaPlantar"; // Nome do template HTML que será renderizado
    }

    // Método para exibir a página de avaliações
    @GetMapping("/avaliacoes")
    public String avaliacoes(Model model) {
        model.addAttribute("title", "Avaliações dos Clientes");
        model.addAttribute("avaliacoes", avaliacaoService.buscarTodas()); // Busca todas as avaliações
        return "avaliacoes"; // Nome do template HTML que será renderizado
    }
}