package com.novatendencia.testepratico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.novatendencia.testepratico.entity.PDI;

import java.util.Optional;

@Repository
public interface PDIRepository extends JpaRepository<PDI,Long>{


    boolean existsByFuncionarioNome(String funcionarioNome);
    @Query(value = "SELECT *  \n" +
            "FROM pdi p \n" +
            "inner join funcionario f on (p.funcionario_id=f.id)" +
            "WHERE f.nome=:funcionarioNome",nativeQuery = true)
    PDI findByFuncionarioNome(@Param("funcionarioNome") String funcionarioNome);

    @Query(value = "SELECT * FROM pdi p where p.id=id ",nativeQuery = true)
    PDI procurarPorId(@Param("id") Long id);
}
