const apiBaseURL = "http://localhost:8080";  // URL base da API

// Função para buscar materiais com base no nome
async function buscarMateriais() {
    const material = document.getElementById("material").value;
    const url = `${apiBaseURL}/materiais/buscar?texto=${encodeURIComponent(material)}`;

    try {
        const response = await fetch(url);
        if (response.ok) {
            const materiais = await response.json();
            exibirMateriais(materiais);
        } else {
            alert("Erro na busca de materiais.");
        }
    } catch (error) {
        console.error("Erro:", error);
    }
}

// Função para exibir materiais na tela
function exibirMateriais(materiais) {
    const lista = document.getElementById("resultados-lista");
    lista.innerHTML = "";  // Limpa os resultados anteriores

    if (materiais.length === 0) {
        lista.innerHTML = "<p>Nenhum material encontrado.</p>";
        return;
    }

    materiais.forEach(material => {
        const item = document.createElement("div");
        item.classList.add("result-item");
        item.innerHTML = `
            <h3>${material.objeto}</h3>
            <p>Material: ${material.material}</p>
            <p>Reciclável: ${material.ehreciclavel ? "Sim" : "Não"}</p>
            <p>Forma de Reciclagem: ${material.formaReciclagem}</p>
        `;
        lista.appendChild(item);
    });
}

// Função para buscar centros de reciclagem com base na cidade
async function buscarCentros() {
    const cidade = document.getElementById("cidade").value;
    const url = `${apiBaseURL}/pessoas-juridicas/cidade/${encodeURIComponent(cidade)}`;

    try {
        const response = await fetch(url);
        if (response.ok) {
            const centros = await response.json();
            exibirCentros(centros);
        } else {
            alert("Erro na busca de centros de reciclagem.");
        }
    } catch (error) {
        console.error("Erro:", error);
    }
}

// Função para exibir centros na tela
function exibirCentros(centros) {
    const lista = document.getElementById("centros-lista");
    lista.innerHTML = "";  // Limpa os resultados anteriores

    if (centros.length === 0) {
        lista.innerHTML = "<p>Nenhum centro de reciclagem encontrado.</p>";
        return;
    }

    centros.forEach(centro => {
        const item = document.createElement("div");
        item.classList.add("centro-item");
        item.innerHTML = `
            <h3>${centro.nome}</h3>
            <p>Email: ${centro.email}</p>
            <p>Cidade: ${centro.cidade}</p>
            <p>Endereço: ${centro.rua}, ${centro.bairro} - ${centro.cep}</p>
        `;
        lista.appendChild(item);
    });
}

// Função para cadastrar pessoa física
async function cadastrarPessoa() {
    const pessoaData = {
        nome: document.getElementById("nome").value,
        email: document.getElementById("email").value,
        senha: document.getElementById("senha").value,
        cep: document.getElementById("cep").value,
        rua: document.getElementById("rua").value,
        bairo: document.getElementById("bairro").value,
        cidade: document.getElementById("cidade").value,
        estado: document.getElementById("estado").value
    };

    try {
        const response = await fetch(`${apiBaseURL}/pessoas/cadastro`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(pessoaData)
        });
        
        if (response.ok) {
            alert("Pessoa cadastrada com sucesso!");
            document.getElementById("pessoa-form").reset();
        } else {
            alert("Erro ao cadastrar pessoa.");
        }
    } catch (error) {
        console.error("Erro:", error);
    }
}

async function cadastrarPessoaJuridica() {
    // Captura os dados do formulário
    const tiposMateriaisSelecionados = Array.from(document.querySelectorAll("input[name='tiposMateriaisReciclados']:checked"))
        .map(checkbox => checkbox.value);

    const pessoaJuridicaData = {
        nome: document.getElementById("nome-juridico").value,
        email: document.getElementById("email-juridico").value,
        senha: document.getElementById("senha-juridico").value,
        cep: document.getElementById("cep-juridico").value,
        rua: document.getElementById("rua-juridico").value,
        bairro: document.getElementById("bairro-juridico").value,
        cidade: document.getElementById("cidade-juridico").value,
        estado: document.getElementById("estado-juridico").value,
        cnpj: document.getElementById("cnpj-juridico").value,
        razaoSocial: document.getElementById("razao-social-juridico").value,
        tiposMateriaisReciclados: tiposMateriaisSelecionados
    };

    try {
        // Envia a solicitação para o backend
        const response = await fetch(`${apiBaseURL}/pessoas-juridicas/cadastro`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(pessoaJuridicaData)
        });

        // Verifica a resposta do backend
        if (response.ok) {
            alert("Centro de Reciclagem cadastrado com sucesso!");
            document.getElementById("pessoa-juridica-form").reset();
        } else {
            alert("Erro ao cadastrar centro de reciclagem.");
        }
    } catch (error) {
        console.error("Erro:", error);
        alert("Ocorreu um erro ao processar sua solicitação.");
    }
}

async function cadastrarLembrete() {
    const idPessoa = document.getElementById("idPessoa").value;
    const nome = document.getElementById("nome").value;
    const data = document.getElementById("data").value;
    const horario = document.getElementById("horario").value;

    const lembrete = {
        nome: nome,
        data: data,
        horario: horario
    };

    try {
        const response = await fetch(`http://localhost:8080/lembretes/cadastro/${idPessoa}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(lembrete)
        });

        if (response.ok) {
            const resultado = await response.json();
            document.getElementById("resultado").innerHTML = `<p style="color: green;">Lembrete cadastrado com sucesso! ID: ${resultado.id}</p>`;
            document.getElementById("lembreteForm").reset();
        } else {
            const error = await response.json();
            document.getElementById("resultado").innerHTML = `<p style="color: red;">Erro: ${error.message}</p>`;
        }
    } catch (error) {
        document.getElementById("resultado").innerHTML = `<p style="color: red;">Erro ao cadastrar o lembrete.</p>`;
        console.error("Erro:", error);
    }
}
