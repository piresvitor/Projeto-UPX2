package com.projeto.UPX2.Repository;

import com.projeto.UPX2.Model.Materiais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MateriaisRepository extends JpaRepository<Materiais, Long>{
    @Query("SELECT m FROM Materiais m WHERE LOWER(m.objeto) LIKE LOWER(CONCAT('%', :texto, '%'))")
    List<Materiais> findByObjetoContainingIgnoreCase(@Param("texto") String texto);
}



