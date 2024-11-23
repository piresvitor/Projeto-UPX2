package com.projeto.UPX2.Repository;

import com.projeto.UPX2.Model.Lembrete;
import com.projeto.UPX2.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
    List<Lembrete> findByPessoa(Pessoa pessoa);
}
