package com.projeto.UPX2.Controler;

import com.projeto.UPX2.Model.Pessoa;
import com.projeto.UPX2.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaControler {

    @Autowired
    private PessoaService pessoaService;

    // Endpoint para cadastrar uma nova pessoa
    @PostMapping("/cadastro")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        // Cadastra a pessoa e salva no banco de dados
        Pessoa novaPessoa = pessoaService.cadastrarPessoa(pessoa);

        // Retorna a pessoa cadastrada com o status HTTP 201
        return ResponseEntity.status(201).body(novaPessoa);
    }
}
