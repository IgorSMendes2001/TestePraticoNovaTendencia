package com.novatendencia.testepratico.dto;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class FuncionarioDTO {
    @NotBlank @Length(min = 2)
    private String nome;
    @NotBlank @Length(min=5)
    private String email;
    @NotBlank @Length(min=2)
    private String cargo;
    
    public FuncionarioDTO(@NotBlank @Length(min = 2) String nome, @NotBlank @Length(min = 5) String email,
            @NotBlank @Length(min = 2) String cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }
    public FuncionarioDTO() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
