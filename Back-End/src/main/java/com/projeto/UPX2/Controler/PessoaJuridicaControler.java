package com.projeto.UPX2.Controler;

import com.projeto.UPX2.Model.PessoaJuridica;
import com.projeto.UPX2.Service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoas-juridicas")
public class PessoaJuridicaControler {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @PostMapping("/cadastro")
    public ResponseEntity<PessoaJuridica> cadastrarPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) {
        PessoaJuridica novaPessoaJuridica = pessoaJuridicaService.cadastrarPessoaJuridica(pessoaJuridica);
        return ResponseEntity.status(201).body(novaPessoaJuridica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaJuridica> atualizarPessoaJuridica(@PathVariable Long id, @RequestBody PessoaJuridica pessoaJuridicaAtualizada) {
        Optional<PessoaJuridica> pessoaJuridicaExistente = pessoaJuridicaService.buscarPorId(id);
        if (pessoaJuridicaExistente.isPresent()) {
            PessoaJuridica atualizada = pessoaJuridicaService.atualizarPessoaJuridica(id, pessoaJuridicaAtualizada);
            return ResponseEntity.ok(atualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoaJuridica(@PathVariable Long id) {
        if (pessoaJuridicaService.deletarPessoaJuridica(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
