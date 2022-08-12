package com.novatendencia.testepratico.service;

import org.springframework.stereotype.Service;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.novatendencia.testepratico.dto.PDIDto;
import com.novatendencia.testepratico.entity.PDI;
import com.novatendencia.testepratico.repository.PDIRepository;


@Service
public class PDIService {
   

    @Autowired
    PDIRepository pdiRepository;
    @Autowired
    private ModelMapper modelMapper;
	

    public List<PDI> findAll() {
		List<PDI> listPDI = pdiRepository.findAll();
		return listPDI;
    }

    public PDIDto findByid(Long id) {

		boolean existe = pdiRepository.existsById(id);
		if (existe == true) {
			PDI pdi = pdiRepository.getReferenceById(id);
			PDIDto pdiDTO = modelMapper.map(pdi, PDIDto.class);
			return pdiDTO;
		}
		return new PDIDto();

	}

    public PDIDto save(PDIDto pdiDTO) {

		try {
			PDI pdi = modelMapper.map(pdiDTO, PDI.class);
			 pdiRepository.save(pdi).getId();

			return pdiDTO;

		} catch (Exception e) {
			return new PDIDto();
		}
	}
	public PDI findByFuncionarioNome(String funcionarioNome){
		boolean existe = pdiRepository.existsByFuncionarioNome(funcionarioNome);
		if (existe == true) {
			PDI pdi=pdiRepository.findByFuncionarioNome(funcionarioNome);
			return pdi;
	}
	return new PDI();
}
}


