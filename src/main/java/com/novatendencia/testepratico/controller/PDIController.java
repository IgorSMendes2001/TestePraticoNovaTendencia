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

import com.novatendencia.testepratico.dto.PDIDto;
import com.novatendencia.testepratico.entity.PDI;
import com.novatendencia.testepratico.service.PDIService;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "API REST PDI")
@RestController
@RequestMapping({"/pdi"})
public class PDIController {
    @Autowired
    PDIService pdiService;
    @GetMapping
    public List<PDI> findAll( ) {

		List<PDI> listPdiDTO= pdiService.findAll();
		

		return listPdiDTO;
	}
	

    @GetMapping(path = "/{id}")
	public ResponseEntity<PDIDto> findById(@PathVariable Long id) {

		PDIDto listPdiDTO = pdiService.findByid(id);
		
		return ResponseEntity.ok(listPdiDTO);
	}

    @PostMapping
	public ResponseEntity<PDIDto> save(@Valid @RequestBody PDIDto pdiDTO) {

		pdiDTO = pdiService.save(pdiDTO);	
		return ResponseEntity.status(HttpStatus.CREATED).body(pdiDTO);		
	}

    @GetMapping("/funcionario")
    public PDI findByFuncionarioNome(@RequestParam String funcionarioNome) {
        PDI pdiFuncionario=pdiService.findByFuncionarioNome(funcionarioNome);
        return pdiFuncionario;
    }
    
}
