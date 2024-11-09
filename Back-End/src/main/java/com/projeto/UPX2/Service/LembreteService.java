package com.projeto.UPX2.Service;

import com.projeto.UPX2.Model.Lembrete;
import com.projeto.UPX2.Model.Pessoa;
import com.projeto.UPX2.Repository.LembreteRepository;
import com.projeto.UPX2.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    // Método para cadastrar um lembrete associado a uma pessoa
    public Lembrete cadastrarLembrete(Long pessoaId, Lembrete lembrete) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + pessoaId));
        lembrete.setPessoa(pessoa);
        return lembreteRepository.save(lembrete);
    }

    // Método para buscar todos os lembretes de uma pessoa
    public List<Lembrete> buscarLembretesPorPessoa(Long pessoaId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + pessoaId));
        return lembreteRepository.findByPessoa(pessoa);
    }
}
