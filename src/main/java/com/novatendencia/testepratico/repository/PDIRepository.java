package com.novatendencia.testepratico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novatendencia.testepratico.entity.PDI;
@Repository
public interface PDIRepository extends JpaRepository<PDI,Long>{

    boolean existsByFuncionarioNome(String funcionarioNome);

    PDI findByFuncionarioNome(String funcionarioNome);
    
}
