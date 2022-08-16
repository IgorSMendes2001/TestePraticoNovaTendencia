package com.novatendencia.testepratico.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novatendencia.testepratico.dto.FuncionarioDTO;
import com.novatendencia.testepratico.entity.Funcionario;
import com.novatendencia.testepratico.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    private ModelMapper modelMapper;
	
	FuncionarioService(FuncionarioRepository funcionarioService){
        this.funcionarioRepository=funcionarioService;
    }

    public List<Funcionario> findAll() {
		List<Funcionario> listFuncionario = funcionarioRepository.findAll();
		return listFuncionario;
    }

    public FuncionarioDTO findByid(Long id) {

		boolean existe = funcionarioRepository.existsById(id);
		if (existe == true) {
			Funcionario funcionario = funcionarioRepository.getReferenceById(id);
			FuncionarioDTO funcionarioDTO = modelMapper.map(funcionario, FuncionarioDTO.class);
			return funcionarioDTO;
		}
		return new FuncionarioDTO();

	}

    public FuncionarioDTO save(FuncionarioDTO funcionarioDTO) {

		try {
			Funcionario funcionario = modelMapper.map(funcionarioDTO, Funcionario.class);
			 funcionarioRepository.save(funcionario).getId();

			return funcionarioDTO;

		} catch (Exception e) {
			return new FuncionarioDTO();
		}
	}
}
