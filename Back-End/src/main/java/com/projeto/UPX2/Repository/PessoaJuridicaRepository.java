package com.projeto.UPX2.Repository;

import com.projeto.UPX2.Model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    @Query("SELECT p FROM PessoaJuridica p WHERE LOWER(p.cidade) = LOWER(:cidade)")
    List<PessoaJuridica> findByCidadeIgnoreCase(@Param("cidade") String cidade);
}
