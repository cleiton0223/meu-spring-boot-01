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
    private double nmDepartamento;

    @Column(name = "id_funcionario")
    private int idFuncionario;

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
    private Departamentoentity departamento;

    public FuncionarioEntity(int idFuncionario, String nome, String email, String senha, double salario, Departamentoentity departamento) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.salario = salario;
        this.departamento = departamento;
    }
    public FuncionarioEntity() {

    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public Departamentoentity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamentoentity departamento) {
        this.departamento = departamento;
    }
}