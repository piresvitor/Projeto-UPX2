package com.projeto.UPX2.Repository;

import com.projeto.UPX2.Model.Lembrete;
import com.projeto.UPX2.Model.Materiais;
import com.projeto.UPX2.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaisRepository extends JpaRepository<Materiais, Long>{
    //metodos de busca com JPQL
}



