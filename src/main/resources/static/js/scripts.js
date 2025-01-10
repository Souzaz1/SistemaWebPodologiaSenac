// Aguarda o carregamento completo da página
document.addEventListener("DOMContentLoaded", function () {
    // Seleciona os elementos do DOM
    const comentarioInput = document.getElementById("comentario");
    const contadorCaracteres = document.getElementById("contadorCaracteres");
    const limiteCaracteres = 284;

    // Verifica se os elementos existem
    if (comentarioInput && contadorCaracteres) {
        // Atualiza o contador ao digitar
        comentarioInput.addEventListener("input", function () {
            const caracteresDigitados = comentarioInput.value.length;
            const caracteresRestantes = limiteCaracteres - caracteresDigitados;

            // Atualiza o texto do contador
            contadorCaracteres.textContent = `Caracteres restantes: ${caracteresRestantes}`;

            // Altera a cor do contador se o limite for excedido
            if (caracteresRestantes < 0) {
                contadorCaracteres.style.color = "red";
            } else {
                contadorCaracteres.style.color = "gray";
            }
        });
    } else {
        console.error("Elementos do contador de caracteres não encontrados!");
    }
});


// Validação do formulário de avaliação
document.getElementById("formAvaliacao").addEventListener("submit", function (event) {
    const nomeCliente = document.getElementById("nomeCliente").value;
    const estrelas = document.getElementById("estrelas").value;
    const comentario = document.getElementById("comentario").value;
    const foto = document.getElementById("foto").files[0];

    // Validação do nome
    if (nomeCliente.trim() === "") {
        alert("Por favor, insira seu nome.");
        event.preventDefault();
        return;
    }

    // Validação das estrelas
    if (estrelas < 1 || estrelas > 5) {
        alert("A avaliação deve ser entre 1 e 5 estrelas.");
        event.preventDefault();
        return;
    }

    // Validação do comentário
    if (comentario.trim() === "") {
        alert("Por favor, insira um comentário.");
        event.preventDefault();
        return;
    }

    // Validação do número mínimo de caracteres no comentário
    if (comentario.trim().length < 10) {
        alert("O comentário deve ter pelo menos 10 caracteres.");
        event.preventDefault();
        return;
    }

    // Validação do número máximo de caracteres no comentário
    if (comentario.trim().length > limiteCaracteres) {
        alert(`O comentário não pode ultrapassar ${limiteCaracteres} caracteres.`);
        event.preventDefault();
        return;
    }

    // Validação da foto (se fornecida)
    if (foto) {
        const tiposPermitidos = ["image/png", "image/jpeg"];
        if (!tiposPermitidos.includes(foto.type)) {
            alert("Apenas arquivos PNG ou JPEG são permitidos.");
            event.preventDefault();
            return;
        }

        const tamanhoMaximo = 5 * 1024 * 1024; // 5 MB
        if (foto.size > tamanhoMaximo) {
            alert("O arquivo não pode ser maior que 5 MB.");
            event.preventDefault();
            return;
        }
    }
});