package com.projeto.UPX2.Service;

import com.projeto.UPX2.Model.PessoaJuridica;
import com.projeto.UPX2.Repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridica cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public List<PessoaJuridica> buscarPorCidade(String cidade) {
        return pessoaJuridicaRepository.findByCidadeIgnoreCase(cidade);
    }
}
