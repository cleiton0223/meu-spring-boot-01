package com.bertoldi.meu_spring_boot_01.dto;

import jakarta.validation.constraints.*;

import java.lang.annotation.Target;

public class FuncionarioDto {

    private int idFuncionario;


    @NotBlank(message = "Nome do funcionário não pode ser vazio")
    @Size(max = 100, message = "Nome do funcionário não pode ultrapassar 100 caracteres")
    private String nome;

    @NotBlank(message = "Email do funcionário não pode ser vazio")
    @Size(max = 50, message = "Email do funcionário não pode ultrapassar 50 caracteres")
    @Email(message = "Email do funcionário inválido")
    private String email;

    @NotBlank(message = "Senha do funcionário não pode ser vazia")
    @Size(max = 50, message = "Senha do funcionário não pode ultrapassar 50 caracteres")
    private String senha;

    @Digits(integer = 10, fraction = 2, message = "Salário do funcionário inválido")
    @PositiveOrZero(message = "Salário do funcionário não pode ser negativo")
    private double salario;
    private int departamento;



    public FuncionarioDto(int idFuncionario, String nome, String email, String senha, double salario, int departamento) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.salario = salario;
        this.departamento = departamento;
    }
    public FuncionarioDto() {

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

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "FuncionarioDto{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", salario=" + salario +
                ", departamento=" + departamento +
                '}';
    }
}

