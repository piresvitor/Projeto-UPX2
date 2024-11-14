package com.projeto.UPX2.Controler;

import com.projeto.UPX2.Model.Lembrete;
import com.projeto.UPX2.Service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembretes")
public class LembreteControler {

    @Autowired
    private LembreteService lembreteService;

    // Cadastra um lembrete associado a uma pessoa
    @PostMapping("/cadastro/{pessoaId}")
    public ResponseEntity<Lembrete> cadastrarLembrete(@PathVariable Long pessoaId, @RequestBody Lembrete lembrete) {
        Lembrete novoLembrete = lembreteService.cadastrarLembrete(pessoaId, lembrete);
        return ResponseEntity.status(201).body(novoLembrete);
    }

    // Busca todos os lembretes de uma pessoa
    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<Lembrete>> buscarLembretesPorPessoa(@PathVariable Long pessoaId) {
        List<Lembrete> lembretes = lembreteService.buscarLembretesPorPessoa(pessoaId);
        return ResponseEntity.ok(lembretes);
    }

    // Atualiza um lembrete pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Lembrete> atualizarLembrete(@PathVariable Long id, @RequestBody Lembrete lembreteAtualizado) {
        Lembrete atualizado = lembreteService.atualizarLembrete(id, lembreteAtualizado);
        return ResponseEntity.ok(atualizado);
    }

    // Deleta um lembrete pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLembrete(@PathVariable Long id) {
        if (lembreteService.deletarLembrete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
