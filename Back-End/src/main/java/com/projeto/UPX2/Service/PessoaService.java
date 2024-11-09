package com.projeto.UPX2.Service;

import com.projeto.UPX2.Model.Pessoa;
import com.projeto.UPX2.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
