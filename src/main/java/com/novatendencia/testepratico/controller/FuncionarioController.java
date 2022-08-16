package com.novatendencia.testepratico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novatendencia.testepratico.dto.FuncionarioDTO;
import com.novatendencia.testepratico.entity.Funcionario;
import com.novatendencia.testepratico.service.FuncionarioService;

import io.swagger.annotations.Api;
@Api(value = "API REST Funcionário")
@RequestMapping({"/funcionario"})
@RestController
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;
    @GetMapping
    public List<Funcionario> findAll( ) {

		List<Funcionario> listFuncionarioDTO= funcionarioService.findAll();
		

		return listFuncionarioDTO;
	}
	

    @GetMapping(path = "/{id}")
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {

		FuncionarioDTO listFuncionarioDTO = funcionarioService.findByid(id);
		
		return ResponseEntity.ok(listFuncionarioDTO);
	}

    @PostMapping
	public ResponseEntity<FuncionarioDTO> save(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {

		funcionarioDTO = funcionarioService.save(funcionarioDTO);	
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioDTO);		
	}
}
