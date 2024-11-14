package com.projeto.UPX2.Service;

import com.projeto.UPX2.Model.PessoaJuridica;
import com.projeto.UPX2.Repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridica cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public Optional<PessoaJuridica> buscarPorId(Long id) {
        return pessoaJuridicaRepository.findById(id);
    }

    public PessoaJuridica atualizarPessoaJuridica(Long id, PessoaJuridica pessoaJuridicaAtualizada) {
        pessoaJuridicaAtualizada.setId(id);
        return pessoaJuridicaRepository.save(pessoaJuridicaAtualizada);
    }

    public boolean deletarPessoaJuridica(Long id) {
        if (pessoaJuridicaRepository.existsById(id)) {
            pessoaJuridicaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
