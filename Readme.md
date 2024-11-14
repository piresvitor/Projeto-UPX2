# Projeto de UPX - Grupo 16

# API de Gerenciamento de Pessoas e Centros de Reciclagem

![API de Gerenciamento de Pessoas e Centros de Reciclagem](./image.png)

API para gerenciar pessoas físicas, centros de reciclagem e lembretes associados.

## Descrição

Essa API permite o gerenciamento de pessoas físicas e jurídicas (centros de reciclagem), bem como o cadastro e busca de lembretes associados a essas pessoas. A API está documentada usando o formato OpenAPI, e você pode visualizá-la e interagir com os endpoints diretamente no [Swagger Editor](https://editor.swagger.io/).

### Funcionalidades Principais


1. **Pesquisa de Materiais Recicláveis**
2. **Cadastro de Pessoas Físicas**
3. **Cadastro de Centros de Reciclagem (Pessoas Jurídicas)**
4. **Busca de Centros de Reciclagem por Cidade**
5. **Cadastro de Lembretes**
6. **Busca de Lembretes por Pessoa**

## Tecnologias Utilizadas

- **Back-end**: Java com Spring Boot e Spring Data JPA
- **Banco de Dados**: PostgreSQL
- **Documentação da API**: Swagger/OpenAPI 3.0
- **Front-end**: HTML, CSS e JavaScript com Fetch API para consumo da API

## Estrutura da API

### Endpoints

## Materiais
- **GET `/materiais/buscar`**: Busca materiais recicláveis contendo um texto específico.
- **POST `/materiais/gravar-materiais`**: Carrega um arquivo JSON de materiais e salva no banco de dados.

## Cadastro de Pessoas Físicas

- **POST `/pessoas/cadastro`**: Cadastra uma nova pessoa física.
- **PUT `/pessoas/{id}`**: Atualiza uma pessoa física existente pelo ID.
- **DELETE `/pessoas/{id}`**: Deleta uma pessoa física pelo ID.


## Cadastro de Centros de Reciclagem

- **POST `/pessoas-juridicas/cadastro`**: Cadastra uma nova pessoa jurídica.
- **PUT `/pessoas-juridicas/{id}`**: Atualiza uma pessoa jurídica existente pelo ID.
- **DELETE `/pessoas-juridicas/{id}`**: Deleta uma pessoa jurídica pelo ID.

### Busca de Centros de Reciclagem por Cidade

**Endpoint:** `/pessoas-juridicas/buscar/{nome_da_cidade}`
**Método:** GET
**Descrição:** Retorna todos os centros de reciclagem de uma cidade especificada.

## Lembretes
- **POST `/lembretes/cadastro/{pessoaId}`**: Cadastra um novo lembrete para uma pessoa (física ou jurídica).
- **GET `/lembretes/pessoa/{pessoaId}`**: Busca todos os lembretes de uma pessoa pelo ID.
- **PUT `/lembretes/{id}`**: Atualiza um lembrete existente pelo ID.
- **DELETE `/lembretes/{id}`**: Deleta um lembrete pelo ID.

### Busca de Lembretes por Pessoa

**Endpoint:** `/lembretes/buscar/{id_pessoa}`
**Método:** GET
**Descrição:** Retorna todos os lembretes cadastrados para uma pessoa especificada.


## Front-end

O front-end foi criado em HTML, CSS e JavaScript para consumir essa API. A interface principal permite a busca de materiais de reciclagem e exibe os resultados de forma interativa. Além disso, há formulários de cadastro para pessoas físicas e jurídicas.

### Como Usar

* **Busca de Materiais:** Interface para busca de materiais de reciclagem.
* **Cadastro de Pessoas:** Formulário para cadastro de pessoas físicas.
* **Cadastro de Centros de Reciclagem:** Formulário para cadastro de centros de reciclagem.

## Executando o Projeto

1. Clone o repositório.
2. Execute o servidor back-end com Spring Boot.
3. Abra `index.html` no navegador para acessar o front-end.

## Dependências

* Spring Boot
* Spring Data JPA
* PostgreSQL
* Jackson

## Como Executar o Swagger

Para visualizar a documentação interativa no Swagger Editor, siga os passos abaixo:

1. **Copie o conteúdo YAML da API.**
2. **Acesse o Swagger Editor.** Você pode encontrá-lo online em https://editor.swagger.io/.
3. **Cole o conteúdo YAML** copiado no editor e visualize os endpoints da API.

## Contato

Para dúvidas ou sugestões, entre em contato com o desenvolvedor.

## Melhorias futuras

Melhoria na interface do frontend
Criação de novas rotas 
