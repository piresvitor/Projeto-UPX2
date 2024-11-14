package com.projeto.UPX2.Service;

import com.projeto.UPX2.Model.Pessoa;
import com.projeto.UPX2.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isPresent()) {
            Pessoa pessoa = pessoaExistente.get();
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setEmail(pessoaAtualizada.getEmail());
            pessoa.setSenha(pessoaAtualizada.getSenha());
            pessoa.setCep(pessoaAtualizada.getCep());
            pessoa.setRua(pessoaAtualizada.getRua());
            pessoa.setBairo(pessoaAtualizada.getBairo());
            pessoa.setCidade(pessoaAtualizada.getCidade());
            pessoa.setEstado(pessoaAtualizada.getEstado());
            return pessoaRepository.save(pessoa);
        }
        return null;
    }

    public boolean deletarPessoa(Long id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
