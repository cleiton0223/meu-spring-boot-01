package com.bertoldi.meu_spring_boot_01.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "departamento")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private int id_Funcionario;

    @Column(name = "nm_departamento")
    private String nmDepartamento;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "salario")
    private double salario;

    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private DepartamentoEntity departamento;

    public FuncionarioEntity(int id_Funcionario, String nome, String email, String senha, double salario, DepartamentoEntity departamento) {
        this.id_Funcionario = id_Funcionario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.salario = salario;
        this.departamento = departamento;
    }
    public FuncionarioEntity() {

    }

    public int getIdFuncionario() {
        return id_Funcionario;
    }

    public void setIdFuncionario(int id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }
}