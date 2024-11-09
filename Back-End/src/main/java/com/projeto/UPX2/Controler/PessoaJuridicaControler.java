package com.projeto.UPX2.Controler;

import com.projeto.UPX2.Model.PessoaJuridica;
import com.projeto.UPX2.Service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas-juridicas")
public class PessoaJuridicaControler {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    // Rota para cadastro de Pessoa Jurídica
    @PostMapping("/cadastro")
    public ResponseEntity<PessoaJuridica> cadastrarPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) {
        PessoaJuridica novaPessoaJuridica = pessoaJuridicaService.cadastrarPessoaJuridica(pessoaJuridica);
        return ResponseEntity.status(201).body(novaPessoaJuridica);
    }

    // Rota para buscar centros comunitários por cidade
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<PessoaJuridica>> buscarPorCidade(@PathVariable String cidade) {
        List<PessoaJuridica> centros = pessoaJuridicaService.buscarPorCidade(cidade);
        if (centros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(centros);
    }
}
