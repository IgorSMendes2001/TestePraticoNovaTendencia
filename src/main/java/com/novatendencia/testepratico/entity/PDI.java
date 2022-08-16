package com.novatendencia.testepratico.entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "pdi")
public class PDI {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    private String avaliacao;
    private LocalDate data;
    public PDI() {
    }
    public PDI(Long id, Funcionario funcionario, String avaliacao, LocalDate data) {
        this.id = id;
        this.funcionario = funcionario;
        this.avaliacao = avaliacao;
        this.data = data;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
    
}
