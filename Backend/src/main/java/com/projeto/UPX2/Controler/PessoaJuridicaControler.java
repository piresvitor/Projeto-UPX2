package com.projeto.UPX2.Controler;

import com.projeto.UPX2.Model.PessoaJuridica;
import com.projeto.UPX2.Service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas-juridicas")
public class PessoaJuridicaControler {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    // Rota para buscar centros comunitários por cidade
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<PessoaJuridica>> buscarPorCidade(@PathVariable String cidade) {
        List<PessoaJuridica> centros = pessoaJuridicaService.buscarPorCidade(cidade);
        if (centros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(centros);
    }

    // Rota para cadastro de Pessoa Jurídica
    @PostMapping("/cadastro")
    public ResponseEntity<PessoaJuridica> cadastrarPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica) {
        // Validação do CNPJ
        if (!isCnpjValido(pessoaJuridica.getCnpj())) {
            return ResponseEntity.badRequest().body(null);
        }
        PessoaJuridica novaPessoaJuridica = pessoaJuridicaService.cadastrarPessoaJuridica(pessoaJuridica);
        return ResponseEntity.status(201).body(novaPessoaJuridica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaJuridica> atualizarPessoaJuridica(@PathVariable Long id, @RequestBody PessoaJuridica pessoaJuridicaAtualizada) {
        Optional<PessoaJuridica> pessoaJuridicaExistente = pessoaJuridicaService.buscarPorId(id);
        if (pessoaJuridicaExistente.isPresent()) {
            // Validação do CNPJ antes de atualizar
            if (!isCnpjValido(pessoaJuridicaAtualizada.getCnpj())) {
                return ResponseEntity.badRequest().body(null);
            }
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

    // Função auxiliar para validar CNPJ
    private boolean isCnpjValido(String cnpj) {
        if (cnpj == null || cnpj.isEmpty()) {
            return false;
        }
        // Lógica simples para verificar o formato (substituir por validação de dígitos se necessário)
        return cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");
    }
}

