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