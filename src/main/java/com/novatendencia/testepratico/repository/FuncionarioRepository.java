package com.novatendencia.testepratico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novatendencia.testepratico.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
    
}
