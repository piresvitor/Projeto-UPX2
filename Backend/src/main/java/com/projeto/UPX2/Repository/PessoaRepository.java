package com.projeto.UPX2.Repository;

import com.projeto.UPX2.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
