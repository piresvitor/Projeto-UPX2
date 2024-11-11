const apiBaseURL = "http://localhost:8080";  // URL base da API

// Função para buscar materiais com base no nome
async function buscarMateriais() {
    const material = document.getElementById("material").value;
    const url = `${apiBaseURL}/materiais/busca?nome=${encodeURIComponent(material)}`;

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

// Função para cadastrar pessoa jurídica (centro de reciclagem)
async function cadastrarPessoaJuridica() {
    const pessoaJuridicaData = {
        nome: document.getElementById("nome-juridico").value,
        email: document.getElementById("email-juridico").value,
        senha: document.getElementById("senha-juridico").value,
        cep: document.getElementById("cep-juridico").value,
        rua: document.getElementById("rua-juridico").value,
        bairo: document.getElementById("bairro-juridico").value,
        cidade: document.getElementById("cidade-juridico").value,
        estado: document.getElementById("estado-juridico").value
    };

    try {
        const response = await fetch(`${apiBaseURL}/pessoas-juridicas/cadastro`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(pessoaJuridicaData)
        });

        if (response.ok) {
            alert("Centro de Reciclagem cadastrado com sucesso!");
            document.getElementById("pessoa-juridica-form").reset();
        } else {
            alert("Erro ao cadastrar centro de reciclagem.");
        }
    } catch (error) {
        console.error("Erro:", error);
    }
}
