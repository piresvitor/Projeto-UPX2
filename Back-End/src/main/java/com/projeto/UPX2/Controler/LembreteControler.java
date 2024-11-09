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

    // Rota para cadastrar um lembrete associado a uma pessoa
    @PostMapping("/cadastro/{pessoaId}")
    public ResponseEntity<Lembrete> cadastrarLembrete(@PathVariable Long pessoaId, @RequestBody Lembrete lembrete) {
        Lembrete novoLembrete = lembreteService.cadastrarLembrete(pessoaId, lembrete);
        return ResponseEntity.status(201).body(novoLembrete);
    }

    // Rota para buscar todos os lembretes de uma pessoa
    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<Lembrete>> buscarLembretesPorPessoa(@PathVariable Long pessoaId) {
        List<Lembrete> lembretes = lembreteService.buscarLembretesPorPessoa(pessoaId);
        return ResponseEntity.ok(lembretes);
    }
}
