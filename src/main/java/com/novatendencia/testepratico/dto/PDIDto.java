package com.novatendencia.testepratico.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;


public class PDIDto {
    @NotBlank
    private String funcionarioNome;
    private Long funcionarioId;
 
    @NotBlank
    private String avaliacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="dd-MM-yyyy")
    private LocalDate data;
    
    public PDIDto() {
    }
  
    public PDIDto(@NotBlank String funcionario, Long funcionarioId, @NotBlank String avaliacao) {
        this.funcionarioNome = funcionario;
        this.funcionarioId = funcionarioId;
        this.avaliacao = avaliacao;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }
    public void setFuncionarioNome(String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }
    public String getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Long getFuncionarioId() {
        return funcionarioId;
    }
    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
}
