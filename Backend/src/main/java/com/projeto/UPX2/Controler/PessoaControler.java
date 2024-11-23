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
        Pessoa novaPessoa = pessoaService.cadastrarPessoa(pessoa);
        return ResponseEntity.status(201).body(novaPessoa);
    }

    // Endpoint para atualizar uma pessoa pelo ID
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        Pessoa pessoa = pessoaService.atualizarPessoa(id, pessoaAtualizada);
        if (pessoa == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 caso a pessoa não seja encontrada
        }
        return ResponseEntity.ok(pessoa); // Retorna a pessoa atualizada com status 200
    }

    // Endpoint para deletar uma pessoa pelo ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        boolean deletada = pessoaService.deletarPessoa(id);
        if (!deletada) {
            return ResponseEntity.notFound().build(); // Retorna 404 caso a pessoa não seja encontrada
        }
        return ResponseEntity.noContent().build(); // Retorna 204 No Content caso a pessoa seja deletada
    }
}

